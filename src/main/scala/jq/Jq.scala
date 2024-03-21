package jq 

trait Jq[R]:

    def id: R
    def str(s: String): R
    def iterator: R
    def array(f: R): R
    def error(msg: String): R
    
    extension (f1: R)
        def |(f2: R): R
        def concat(f2: R): R
        def index(f2: R): R
        def `catch`(f2: R): R

    val B: Builtin[R] = Builtin[R](using this)
    export B.*

object Jq: 

    def apply[R](using J: Jq[R]): Jq[R] = J