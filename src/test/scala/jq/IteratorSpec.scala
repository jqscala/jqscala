package jq

import io.circe.Json
import io.circe.syntax._

trait IteratorSpec[R](using Jq[R], RunnableFilter[R]):
    self: JqBaseSpec =>

    "The iterator filter" should "expand objects and arrays" in:

        List(Json.obj("a" -> 1.asJson, "b" -> 2.asJson))
            .through[Int](iterator) shouldBe 
                List(1, 2)

        List(List(1,2,3))
            .through[Int](iterator) shouldBe 
                List(1, 2, 3)

