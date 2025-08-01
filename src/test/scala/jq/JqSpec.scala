package jq

class JqSpec[R: Jq, J: Json](using RunnableFilter[R, J]) extends JqBaseSpec 
    with IdentitySpec[R, J]
    with IteratorSpec[R, J]
    with MapSpec[R, J]
