# Jq Scala
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/jqscala/jqscala?label=Latest%20release&logo=github)](https://github.com/jqscala/jqscala/releases/latest)
[![GitHub Release Date](https://img.shields.io/github/release-date/jqscala/jqscala?display_date=published_at&logo=github&label=Release%20date&link=https%3A%2F%2Fgithub.com%2Fjqscala%2Fjqscala%2Freleases%2Flatest)](https://github.com/jqscala/jqscala/releases/latest)
[![Scala CI](https://github.com/jqscala/jqscala/actions/workflows/scala.yml/badge.svg?branch=main)](https://github.com/jqscala/jqscala/actions/workflows/scala.yml)
[![Release](https://github.com/jqscala/jqscala/actions/workflows/release.yml/badge.svg?branch=main)](https://github.com/jqscala/jqscala/actions/workflows/release.yml)
[![Codecov](https://codecov.io/gh/jqscala/jqscala/graph/badge.svg?token=3SMUFD4MXB)](https://codecov.io/gh/jqscala/jqscala)

This repository is intended to contain the syntax and standard semantics of the Scala embedding of the [`jq`](https://jqlang.github.io/jq/) language. 

Particular interpreters for specific streaming libraries, like `fs2`, `Akka Streaming`, `ZIO Streams`, etc., can be found in their corresponding repositories (hosted at the parent organization [jqscala](https://github.com/jqscala) or elsewhere):

* [Fs2 implementation](https://github.com/jqscala/jq-fs2)

## Current status

This project originated from the slides and notebooks used in the talk [Embedding external DSLs in Scala: Why and How?](https://github.com/hablapps/embeddinginscala) and the related [training](https://scaladays.org/workshops/embedding-of-domain-specific-languages-in-scala) at Scala Days Madrid 2023.

Currently, this repository just contains a preliminary implementation of a few jq filters. This is very much work in progress. 

## How to contribute

We endorse the [Scala code of conduct](https://www.scala-lang.org/conduct/) in order to create a welcoming environment to anyone wishing to contribute and learn from this project. Please, visit this [technical guide](HowToContribute.md) on how to contribute to the project. 

# 

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a>
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
