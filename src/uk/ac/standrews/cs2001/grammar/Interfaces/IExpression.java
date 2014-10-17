package uk.ac.standrews.cs2001.grammar.Interfaces;

public interface IExpression {

    /**
     * Removes brackets from expression
     * @param expression expression
     */
    public void parse(String expression);

    /**
     * Finds the last index of the given character in string
     * @param ch character index required to be found
     * @param str string where character needs to be found
     * @return index of the given character in string
     */
    public int lastIndexOf(char ch, String str);

    /**
     * Splits expression by arithmetic symbols and checks are they legal variables
     * @param expression expression
     */
    public void split(String expression);
}
