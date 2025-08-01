package jq
package std

import io.circe.Json
import io.circe.syntax._

object StdSem: 

    type Filter = LazyList[Json] => LazyList[Json | TypeError[Json]]

    given Jq[Filter] with
        def id: Filter = identity

        def iterator: Filter = 
            _.flatMap:
                case IsObject(j) => j.values.toStream
                case IsArray(j) => j.toStream
                case j => LazyList(TypeError.CannotIterateOver(j))
            
        def str(s: String): Filter = 
            _.map: _ => 
                s.asJson

        def array(f: Filter): Filter = 
            _.flatMap: v => 
                val elements = f(LazyList(v))
                elements
                    .find:
                        case e: TypeError[Json] => true
                        case _ => false 
                    .fold(
                        LazyList(Json.arr(elements.toList.map:
                            case e: Json => e
                            case _ => ??? /*should not happen*/ 
                        *))
                    ):
                        case e: TypeError[Json] => LazyList(e)
                        case _ => ??? // should not happen

        def error(msg: String): Filter = 
            _ map: _ => 
                TypeError.Custom(msg)

        extension (f1: Filter) 
            def |(f2: Filter): Filter = 
                _.flatMap: v => 
                    f1(LazyList(v)).flatMap:
                        case e: TypeError[Json] => LazyList(e)
                        case j: Json => f2(LazyList(j)) 

            def concat(f2: Filter): Filter = 
                _.flatMap: v => 
                    f1(LazyList(v)) ++ f2(LazyList(v))

            private def indexArray(idx: Int): Filter =
                _.flatMap: v1 => 
                    f1(LazyList(v1)).flatMap:
                        case e: TypeError[Json] => LazyList(e)
                        case IsArray(vec) => LazyList(vec.lift(idx).getOrElse(Json.Null))
                        case v2: Json => LazyList(TypeError.CannotIndex(v2, idx.asJson)) 
                            
            private def indexObj(key: String): Filter =
                _.flatMap: v1 => 
                    f1(LazyList(v1)).flatMap:
                        case e: TypeError[Json] => LazyList(e)
                        case IsObject(obj) => LazyList(obj(key).getOrElse(Json.Null))
                        case v2: Json => LazyList(TypeError.CannotIndex(v2, key.asJson))     

            def index(keyF: Filter): Filter = 
                _.flatMap: v => 
                    keyF(LazyList(v)) flatMap:
                        case e: TypeError[Json] => LazyList(e)
                        case IsInt(idx) => indexArray(idx)(LazyList(v))
                        case IsString(str) => indexObj(str)(LazyList(v))
                        case k: Json => LazyList(TypeError.CannotIndex(what = v, _with = k))
     
            def `catch`(f2: Filter): Filter = 
                _ flatMap: j => 
                    f1(LazyList(j)) flatMap:
                        case j: Json => LazyList(j)
                        case e: TypeError[Json] => 
                            f2(LazyList(Json.fromString(e.toString)))

