package uk.ac.standrews.cs2001.grammar.Language;

import uk.ac.standrews.cs2001.grammar.Interfaces.IVariable;

public class Variable implements IVariable{

    /**
     * Checks is a given token legal
     * @param token token
     * @return is legal
     */
    public boolean isLegalVariable(String token) {
        if (!token.matches("^[$*a-zA-Z0-9]*$")) {
            System.err.println("Illegal variable: " + token);
            return false;
        }
        return true;
    }
}
