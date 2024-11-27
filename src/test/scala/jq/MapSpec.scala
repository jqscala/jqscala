package jq

trait MapSpec[R: Jq, J: Json](using RunnableFilter[R, J]):
    self: JqBaseSpec =>

    "Map" should "work" in: 
        val input = List(Json[J].arr(1.num,2.num,3.num), Json[J].arr(), Json[J].arr(1.num))

        input.throughJson(map(id)) shouldBe input 

        input.throughJson(map(str("dummy"))) shouldBe 
            List(Json[J].arr("dummy".str,"dummy".str,"dummy".str), Json[J].arr(), Json[J].arr("dummy".str))
