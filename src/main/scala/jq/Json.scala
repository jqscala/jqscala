package jq

trait Json[J]:
  
    extension (i: Int)
        def num: J

    extension (i: String)
        def str: J

    def obj(kv: (String, J)*): J

    def arr(elems: J*): J

object Json:

    def apply[J](using j: Json[J]): Json[J] = j
