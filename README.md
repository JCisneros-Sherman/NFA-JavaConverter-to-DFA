# NFA-JavaConverter-to-DFA


Finite state automata (FSA), also known as finite state machines (FSM), are usually classified as being deterministic (DFA) or non-deterministic (NFA). 

A deterministic finite state automaton has exactly one transition from every state for each possible input. In other words, whatever state the FSA is in, if it encounters a symbol for which a transition exists, there will be just one transition and obviously as a result, one follow up state. For a given string, the path through a DFA is deterministic since there is no place along the way where the machine would have to choose between more than one transition.


This program Converts NFAs to their equivalent DFAs According to 

Theorem 

Let language L ⊆ Σ*, and suppose L is accepted by NFA N = (Σ, Q, q0, F, δ). There exists a DFA D= (Σ, Q’, q’0, F’, δ’) that also accepts L. (L(N) = L(D)).


**Algorithm**

Given NFA N = (Σ, Q, q0, F, δ) we want to build DFA D= (Σ, Q’, q’0, F’, δ’). Here’s how:

1. Initially Q’ = ∅.
2. Add q0 to Q’.
3. For each state in Q find the set of possible states for each input symbol using N’s transition table, δ. Add this set of states to Q’, if it is not already there.
4. The set of final states of D, F’, will be all of the the states in Q’ that contain in them a state that is in F.





This program implements part of such construction procedures of equivalent DFA given a NFA given a text file with a NFA

Read part of the transition table of a NFA from a txt file, Table only contains two columns: The first column lists out the states, while the second column lists out what each state jumps to upon the input ε. For example, given the following transition table in a txt file:

1,{2, 3}

2,empty

3,{4}

4,empty

We know the corresponding NFA contains the following set of states:{1, 2, 3, 4}. Also state 1 jumps to states {2, 3} upon the input of ε, while state 2 does not have an outgoing arrowhead with ε on, namely it jumps to ∅ upon the input of ε (in the txt file we use “empty” to denote empty set ∅).

This program reads part of the transition table of a NFA from a txt file, and then print out the set of states the equivalent DFA has and E(q) for each q in the set of states of the NFA. For example, for the above part of the transition table of a NFA, the print out should be State set of the equivalent DFA = {empty, {1}, {2}, {3}, {4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}, {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4}, {1, 2, 3, 4}}

E(1) = {1,2,3,4}

E(2) = {2}

E(3) = {3,4}

E(4) = {4}
