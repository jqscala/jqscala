package jq

trait IdentitySpec[R](using Jq[R], RunnableFilter[R]):
    self: JqBaseSpec =>

    "The identity filter" should "return the same input" in:

        List("a", "b", "c")
            .through[String](id) shouldBe 
                List("a", "b", "c")

        List[String]()
            .through[String](id) shouldBe 
                List()
