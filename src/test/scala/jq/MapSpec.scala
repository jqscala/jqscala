package jq

trait MapSpec[R](using Jq[R], RunnableFilter[R]):
    self: JqBaseSpec =>

    "Map" should "work" in: 
        val input = List(List(1,2,3), List(), List(1))

        input.through[List[Int]](map(id)) shouldBe input 

        input.through[List[String]](map(str("dummy"))) shouldBe 
            List(List("dummy","dummy","dummy"), List(), List("dummy"))
