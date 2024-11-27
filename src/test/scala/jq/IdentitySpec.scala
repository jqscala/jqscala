package jq

trait IdentitySpec[R: Jq, J: Json](using RunnableFilter[R, J]):
    self: JqBaseSpec =>

    "The identity filter" should "return the same input" in:

        List("a".str, "b".str, "c".str)
            .throughJson(id) shouldBe 
                List("a".str, "b".str, "c".str)

        List[J]()
            .throughJson(id) shouldBe 
                List()
