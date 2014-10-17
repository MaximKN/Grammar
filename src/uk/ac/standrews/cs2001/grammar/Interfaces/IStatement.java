package uk.ac.standrews.cs2001.grammar.Interfaces;

public interface IStatement {

    /**
     * Splits a statement by a semi-colon
     * @param statement statement
     */
    void split(String statement);

    /**
     * Evaluates a feature of the language by checking the first token
     * @param statement statement
     */
    void parse(String statement);
}
