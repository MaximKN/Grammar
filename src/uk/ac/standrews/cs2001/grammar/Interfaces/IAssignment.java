package uk.ac.standrews.cs2001.grammar.Interfaces;

public interface IAssignment {

    /**
     * Parses assignment by separating it into the variable and expression
     * @param assignment assignment
     */
    void parse(String assignment);
}
