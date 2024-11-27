package jq
package std
    
import io.circe._

given RunnableFilter[StdSem.Filter, Json] with
    extension (input: List[Json])
        def throughJson(r: StdSem.Filter): List[Json | TypeError[Json]] = 
            r(LazyList(input*)).toList
