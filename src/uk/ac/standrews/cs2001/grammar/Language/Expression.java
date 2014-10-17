package uk.ac.standrews.cs2001.grammar.Language;

import uk.ac.standrews.cs2001.grammar.Interfaces.IExpression;

public class Expression implements IExpression{

    private Variable variable = new Variable();
    /**
     * Removes brackets from expression
     * @param expression expression
     */
    public void parse(String expression) {

        // Exit condition of recursion
        // If there are no brackets, it will parse expression directly
        if (!expression.contains("(") && !expression.contains(")"))   split(expression);

        // Clear brackets if there are at the beginning and the end of expression
        else if (expression.startsWith("(") && expression.endsWith(")"))  parse(expression.substring(1, expression.length() - 1));

        // Check correctness of the syntax
        else if (expression.length() - expression.replace("(", "").length() != expression.length() - expression.replace(")", "").length())
            System.err.println("Wrong number of brackets");

        else if (expression.indexOf("(") > expression.indexOf(")"))
            System.err.println("Wrong brackets order");

        else {
            // find last close bracket
            int indexEnd = lastIndexOf(")".charAt(0), expression);

            // parse after close bracket
            split(expression.substring(indexEnd+1, expression.length()));

            if (expression.startsWith("(")){
                parse(expression.substring(0, indexEnd + 1));
            }
            else{
                int indexBegin = expression.indexOf("(");
                split(expression.substring(0, indexBegin));
                parse(expression.substring(indexBegin + 1, indexEnd));
            }
        }
    }

    /**
     * Finds the last index of the given character in string
     * @param ch character index required to be found
     * @param str string where character needs to be found
     * @return index of the given character in string
     */
    public int lastIndexOf(char ch, String str) {
        if (str.charAt(str.length() - 1) == ch) { return str.length() -1; }
        if (str.length() <= 1) { return -1; }
        return lastIndexOf(ch, str.substring(0, str.length() - 1));
    }

    /**
     * Splits expression by arithmetic symbols and checks are they legal variables
     * @param expression expression
     */
    public void split(String expression){
        String[] tokens = expression.split("([\\+\\-\\*/,])");
        for (String token : tokens) {
            this.variable.isLegalVariable(token);
        }
    }
}