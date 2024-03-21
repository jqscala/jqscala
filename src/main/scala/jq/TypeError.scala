package jq

import io.circe.Json

enum TypeError: 
    case CannotIterateOver(j: Json)
    case CannotIndexObjectWith(j: Json)
    case CannotIndex(what: Json, _with: Json)
    case Custom(msg: String = "")

