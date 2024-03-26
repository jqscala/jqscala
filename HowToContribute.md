# How to contribute

You are most welcome to contribute either by fixing bugs, improving the testing coverage of the current implementation, or implementing new functionality (i.e. new `jq` filters). 

Note that this repository just contains the syntax and standard semantics of the `jq` embedding. Hence: 

* If you wish to contribute a completely new, production-ready interpretation of the embedding, please create that interpretation on a separate repository, either in the parent organization repository [jqscala](https://github.com/jqscala) or elsewhere. 

* Similarly, if you'd like to contribute to an existing interpretation (e.g. for the `fs2` streaming library), please refer to the corresponding repository (e.g. [jq-fs2](https://github.com/jqscala/jq-fs2)). 

* Lastly, if you wish to contribute examples of use, please refer to the [jq-examples](https://github.com/jqscala/jq-examples) repository. 

## Architecture

This embedding follows the principles of DSL design in general, and the particular guidelines of the tagless-final style. In consequence: 

* This repository is primarily concerned with the syntax and specification of the jq embedding, leaving to separate repositories the task of implementing production-ready interpreters for specific streaming frameworks. It's thus intended to exert a normative power over particular implementations, since they have to comply with the syntax and specification provided here. At the same time, this repository does not enforce and is completely decoupled from any particular streaming framework, thus giving freedom and encouraging the creation of competing implementations. 

* This repository also implements the _standard_ semantics of `jq` in terms of abstractions from the Scala Collections library (currently, `LazyList`s). This is intended solely as a reference semantics, to test the implementation of new filters with the minimum number of dependencies. Although it's not intended to be fully optimized, we don't neglect its use in production environments.

* In accordance with the tagless-final style, the syntax of the language is given in terms of plain functions collected around the `Jq` type-class. Builtin functions are fully implemented in a separate class which is exported from the core type class `Jq`. An additional separate module includes auxiliary functions to provide some syntactic sugar. Particular implementations will thus benefit not only from a set of syntactic conventions (for good or for bad), but also by reusing the whole implementation of these modules. 

* Test cases are also provided for each filter of the language, and implemented in a completely agnostic way. The intention is that these tests can be reused completely to test the _functional_ aspects of production-ready interpreters. The test cases for a given filter are implemented in a separate file.

In summary, the bulk of the implementation is given by the following files: 

```
src
├── main
│   └── scala
│       └── jq
│           ├── Builtin.scala
│           ├── Jq.scala
│           ├── StdSem.scala
│           ├── Syntax.scala
│           ├── TypeError.scala
│           ├── ...
│           └── package.scala
└── test
    └── scala
        └── jq
            ├── <Filter1>Spec.scala
            ├── ...
            ├── JqSpec.scala
            └── StdSpec.scala
```

## Implementing a new filter

The process for implementing a new filter may be roughly structured into the following steps:

1. Consider several examples of the new filter until you get comfortable enough with its semantics and syntactic subtleties.

2. Devise a syntactic incarnation in terms of a Scala function signature (e.g., an extension method) and translate the examples into Scala. This may include additional syntactic sugar.

3. Implement test cases for the new filter. These may include very simple test cases, as well as the more complex examples chosen to understand the new filter in step 1. Include additional type errors as needed.

4. Give an implementation of the filter signature: in the case of primitive filters, this will be part of the standard semantics; in the case of builtin filters, it will be included in the `Builtin` class.

5. Test your implementation and come back to step 4 if you need to fix possible errors.

In accordance with the previous considerations, the implementation of a new primitive filter `<F>` will result in the following modifications/additions to the repository:

* __Modified:__ `main/jq/Jq.scala` . The core type class will include now the syntax of the new filter. 

* __Modified:__ `main/jq/Syntax.scala`. The new filter may require syntactic facilities (not necessarily, though).

* **Modified:** `main/jq/TypeError.scala`. The new filter may require new cases of type errors, not previously identified.

* __Modified:__ `main/jq/StdSem.scala`. The standard semantics will include now the implementation of the new filter.

* **Modified:** `test/jq/JqSpec.scala`. The scalatest `JqSpec` will mix in an additional trait implementing the test cases for the new filter.

* **Untracked**: `test/jq/<F>Spec.scala`. A new separate file which includes the trait that implements the test cases for the filter.

In case that the filter is not primitive, but defined in terms of other filters (i.e. it's a builtin filter), the only modification/additions would be the following ones: 

- **Modified:** `main/jq/Builtin.scala` . The class of builtin filters will include now the syntax and implementation of the new filter.

- **Modified:** `main/jq/Syntax.scala`. The new filter may require syntactic facilities (not necessarily, though).

- **Modified:** `test/jq/JqSpec.scala`. The scalatest `JqSpec` will mix in an additional trait implementing the test cases for the new filter.

- **Untracked**: `test/jq/<F>Spec.scala`. A new separate file which includes the trait that implements the test cases for the filter.
