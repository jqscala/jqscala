This repository is intended to contain the syntax and standard semantics of the Scala embedding of the [`jq`](https://jqlang.github.io/jq/) language. Particular interpreters for specific streaming libraries, like `fs2`, `Akka Streaming`, `ZIO Streams`, etc., will be found in their corresponding repositories. These will be hosted at the parent organization [jqscala](https://github.com/jqscala) or elsewhere. 

Currently, this repository just contains a preliminary implementation of a few jq filters. This is very much work in progress. 

This project originated from the slides and notebooks used in the talk: 

[Embedding external DSLs in Scala: Why and How?](https://docs.google.com/presentation/d/1hbouiiLdZwlYKLEjDd5OM1EDYsAdGKzsHw5FxtCSZLg/edit?usp=sharing)

which was part of the following conferences and meetups: 

* [Art of Scala 2023](https://artofscala.com/) ([video](https://www.youtube.com/watch?v=G_EavBszz3E&list=PL4Hghgaxe72DtCAfCdl7QWOaVUMYE3YR_&index=5))
* [Scala meetup at Krakow](https://www.meetup.com/krakow-scala-user-group/events/297280692/)
* [Scala meetup at Madrid](https://www.meetup.com/scala-programming-madrid/events/296792248/)

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a>

This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
