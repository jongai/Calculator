package calculator;

import java.io.IOException;
import java.math.BigInteger;
import java.io.FileReader;

import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.Visitor;

public class TextCalculator {
    public static void main(String[] args) throws IOException, Exception {
        Parser parser = new Parser();
        Visitor visitor = new Visitor();
        Scanner lexer = new Lexer(new FileReader("calculations.txt"));
        Program result = (Program) parser.parse(lexer);
        for (BigInteger i : visitor.visit(result))
            System.out.println("> " + i);
        System.out.println("Successful");
    }
}
