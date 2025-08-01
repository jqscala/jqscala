package jq

trait IteratorSpec[R: Jq, J: Json](using RunnableFilter[R, J]):
    self: JqBaseSpec =>

    "The iterator filter" should "expand objects and arrays" in:

        List(Json[J].obj("a" -> 1.num, "b" -> 2.num))
            .throughJson(iterator) shouldBe 
                List(1.num, 2.num)

        List(Json[J].arr(1.num, 2.num, 3.num))
            .throughJson(iterator) shouldBe 
                List(1.num, 2.num, 3.num)

