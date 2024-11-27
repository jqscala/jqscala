package jq
package std

import io.circe.{Json => CJson}

given Json[CJson] with

    extension (i: Int)
        def num: CJson = CJson.fromInt(i)
    
    extension (i: String)
        def str: CJson = CJson.fromString(i)

    def obj(kv: (String, CJson)*): CJson = 
        CJson.obj(kv*)

    def arr(elems: CJson*): CJson =
        CJson.arr(elems*)