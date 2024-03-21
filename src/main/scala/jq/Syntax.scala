package jq

object Syntax: 

    def id[R](using J: Jq[R]): R = J.id 

    def str[R](using J: Jq[R])(s: String): R = J.str(s)

    def iterator[R](using J: Jq[R]): R = J.iterator

    def error[R](msg: String)(using J: Jq[R]): R = J.error(msg)

    def arr[R](f: R*)(using J: Jq[R]): R = 
        J.array(f.reduce(J.concat(_)(_)))

    def index0[R](k: String)(using J: Jq[R]): R =
        J.id.index(str(k))

    extension [R: scala.reflect.ClassTag](sc: StringContext)(using J: Jq[R])
        def i(args: R*): R = 
            sc.s().split('.').map(index0).reduce(_ | _)

    def map[R](f: R)(using J: Jq[R]): R = 
        J.map(f)