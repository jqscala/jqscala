package jq

class Builtin[R](using J: Jq[R]):
    import J.*
  
    def map(f: R): R = 
        array(iterator | f)
