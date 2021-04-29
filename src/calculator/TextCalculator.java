package calculator;

import java.io.IOException;
import java.io.FileReader;

import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.Printer;
import visitor.Visitor;

public class TextCalculator {
    public static void main(String[] args) throws IOException, Exception {
        Parser parser = new Parser();
        Visitor visitor = new Printer();
        Scanner lexer = new Lexer(new FileReader("p111.txt"));
        Program result = (Program) parser.parse(lexer);
        visitor.visit(result);
        System.out.println("Successful");
    }
}
