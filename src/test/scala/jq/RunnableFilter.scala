package jq

trait RunnableFilter[R, J: Json]:
    extension (input: List[J])
        def throughJson(r: R): List[J | TypeError[J]]
