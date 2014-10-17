package uk.ac.standrews.cs2001.grammar.Language;

public class LogicalExpression extends Expression {

    private Variable variable = new Variable();

    /**
     * Splits expression by logic symbols and checks are they legal variables
     * @param expression expression
     */
    public void split(String expression){
        if (isNumOfOccTwo("&".charAt(0), expression) && isNumOfOccTwo("|".charAt(0), expression) && isNumOfOccTwo("=".charAt(0), expression)){
            String[] parts = expression.split("([&|=<>()])");
            for (String part : parts) {
                variable.isLegalVariable(part);
            }
        }
        else {
            System.err.println("Invalid syntax");
        }
    }

    /**
     * Check is a number of occurrences of a given character is even in given string
     * @param ch character
     * @param string string
     * @return is even; false otherwise
     */
    public boolean isNumOfOccTwo(char ch, String string){
        int charCount = 0;
        for (int i = 0; i < string.length(); i++){
            if (ch == string.charAt( i ))
                charCount++;
        }
        return charCount == 2;
    }
}
