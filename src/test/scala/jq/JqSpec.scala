package jq

class JqSpec[R](using Jq[R], RunnableFilter[R]) extends JqBaseSpec 
    with IdentitySpec[R]
    with IteratorSpec[R]
    with MapSpec[R]
