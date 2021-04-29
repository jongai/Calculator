package calculator;

import java.io.IOException;
import java.io.StringReader;
import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.Printer;
import visitor.Visitor;

public class Calculator {
    public static void main(String[] args) throws IOException, Exception {
        Parser parser = new Parser();
        Visitor visitor = new Printer();
        var scanner = new java.util.Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("quit;") || input.equals(""))
                break;
            Scanner lexer = new Lexer(new StringReader(input));
            Program result = (Program) parser.parse(lexer);
            visitor.visit(result);
        }
        scanner.close();
        System.out.println("Successful");
    }
}
