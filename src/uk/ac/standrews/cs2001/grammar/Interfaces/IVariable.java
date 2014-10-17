package uk.ac.standrews.cs2001.grammar.Interfaces;

public interface IVariable {

    /**
     * Checks is a given token legal
     * @param token token
     * @return is legal
     */
    public boolean isLegalVariable(String token);
}
