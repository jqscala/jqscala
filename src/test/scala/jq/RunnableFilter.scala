package jq

import io.circe.{`export` as _, *}
import io.circe.generic.auto.*
import io.circe.parser._
import io.circe.syntax._

trait RunnableFilter[R]:
    extension (input: List[Json])
        def throughJson(r: R): List[Json | TypeError]

    extension [A: Encoder](st: List[A])
        def through[B: Decoder](f: R): List[B | TypeError] = 
            st.map(_.asJson)
                .throughJson(f)
                .map:
                    case j: Json => j.as[B].fold(t => throw t, identity)
                    case t: TypeError => t

object RunnableFilter:

    given RunnableFilter[StdSem.Filter] with
        extension (input: List[Json])
            def throughJson(r: StdSem.Filter): List[Json | TypeError] = 
                r(LazyList(input*)).toList
