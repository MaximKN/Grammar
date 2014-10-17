package uk.ac.standrews.cs2001.grammar.Language;

import uk.ac.standrews.cs2001.grammar.Interfaces.IAssignment;

public class Assignment implements IAssignment{

    private Variable variable = new Variable();
    private Expression expression = new Expression();

    /**
     * Parses assignment by separating it into the variable and expression
     * @param assignment assignment
     */
    public void parse(String assignment){
        int i = assignment.indexOf("=");
        this.variable.isLegalVariable(assignment.substring(0, i));
        this.expression.parse(assignment.substring(i+1));
    }
}
