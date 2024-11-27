package jq

enum TypeError[J: Json]: 
    case CannotIterateOver[J: Json](j: J) extends TypeError[J]
    case CannotIndexObjectWith[J: Json](j: J) extends TypeError[J]
    case CannotIndex[J: Json](what: J, _with: J) extends TypeError[J]
    case Custom[J: Json](msg: String = "") extends TypeError[J]

