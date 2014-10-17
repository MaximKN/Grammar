package uk.ac.standrews.cs2001.grammar.Language;

import uk.ac.standrews.cs2001.grammar.Interfaces.IStatement;

public class Statement implements IStatement{

    private Assignment assignment = new Assignment();
    private LogicalExpression logicalExpression = new LogicalExpression();
    private Expression expression = new Expression();

    /**
     * Splits a statement by a semi-colon
     * @param statement statement
     */
    public void split(String statement) {
        String[] statementList = statement.split(";");
        for (String string : statementList) this.parse(string);
    }

    /**
     * Evaluates a feature of the language by checking the first token
     * @param statement statement
     */
    public void parse(String statement) {
        if (statement.startsWith("while")){
            if (!statement.endsWith("end")){
                System.err.println("Missing \"end\" at the end of the WHILE statement");
                return;
            }
            if (!statement.contains("do")){
                System.err.println("Missing \"do\" at the end of the WHILE statement");
                return;
            }

            int indexDo = statement.indexOf("do");
            int indexEnd = statement.indexOf("end");

            String logicalStatement = statement.substring(5, indexDo);
            String expression = statement.substring(indexDo + 2, indexEnd);

            if (logicalStatement.equals("")) {
                System.err.println("Missing \"logical statement\" in IF statement");
                return;
            }

            this.logicalExpression.split(logicalStatement);
            this.split(expression);
        }
        else if (statement.startsWith("for")){
            if (!statement.endsWith("end")) {
                System.err.println("Missing \"end\" at the end of the FOR statement");
                return;
            }
            if (!statement.contains("do")) {
                System.err.println("Missing \"do\" in FOR statement");
                return;
            }

            int indexDo = statement.indexOf("do");
            int indexEnd = statement.indexOf("end");

            String expressions = statement.substring(3, indexDo);

            if (expressions.length() - expressions.replace(";", "").length() != 2) {
                System.err.println("Incorrect number of \";\" in FOR statement");
                return;
            }

            String[] expressionsList = expressions.split(";");

            this.assignment.parse(expressionsList[0]);
            this.logicalExpression.split(expressionsList[1]);
            this.assignment.parse(expressionsList[2]);

            this.split(statement.substring(indexDo + 2, indexEnd));
        }
        else if (statement.startsWith("if")){
            if (!statement.endsWith("end")) {
                System.err.println("Missing \"end\" at the end of the IF statement");
                return;
            }
            else if (!statement.contains("then")) {
                System.err.println("Missing \"then\" in IF statement");
                return;
            }

            int indexThen = statement.indexOf("then");
            int indexElse = statement.indexOf("else");
            int indexEnd = statement.indexOf("end");

            String logicalExpression = statement.substring(2, indexThen);
            String firstExpression;
            String secondExpression;

            if (indexElse != -1) {
                firstExpression = statement.substring(indexThen + 4, indexElse);
                secondExpression = statement.substring(indexElse + 4, indexEnd);

                this.split(secondExpression);
            }
            else {
                firstExpression = statement.substring(indexThen + 4, indexEnd);
            }

            if (logicalExpression.equals("")){
                System.err.println("Missing \"logical expression\" in IF statement");
                return;
            }

            this.logicalExpression.split(logicalExpression);
            this.split(firstExpression);
        }
        else if (statement.startsWith("print")){
            if (statement.contains(";")){
                this.split(statement);
            }
            else {
                this.expression.parse(statement.substring(5));
            }
        }
        else if (statement.contains("=")){
            if (statement.contains(";")) {
                this.split(statement);
            }
            else{
                this.assignment.parse(statement);
            }
        }
        else{
            System.err.println("Illegal");
        }
    }
}
