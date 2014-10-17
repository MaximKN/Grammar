package uk.ac.standrews.cs2001.grammar.Main;

import uk.ac.standrews.cs2001.grammar.Language.Statement;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Statement statement = new Statement();

        String line = scanner.nextLine();

        while (!line.equals("quit")){
            statement.parse(line.replaceAll("\\s+", ""));
            line = scanner.nextLine();
        }
    }
}
