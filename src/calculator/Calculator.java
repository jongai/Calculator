package calculator;

import java.io.IOException;
import java.io.StringReader;
import beaver.Parser.Exception;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.Printer;

/**
 * The calculator that takes command line input and prints out
 * the result.
 * 
 * @author Jonathan Gai
 *
 */
public class Calculator {
    public static void main(String[] args) throws IOException, Exception {
        Parser parser = new Parser();
        Printer visitor = new Printer();
        var scanner = new java.util.Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("quit;") || input.equals(""))
                break;
            Lexer lexer = new Lexer(new StringReader(input));
            Program result = (Program) parser.parse(lexer);
            visitor.visit(result);
        }
        scanner.close();
        System.out.println("Successful");
    }
}
