package calculator;

import java.io.IOException;
import java.io.StringReader;

import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.Visitor;

public class Calculator
{
    public static void main(String[] args) throws IOException, Exception
    {
        Scanner lexer = new Lexer(new StringReader("(1 + 2) * 3 + 2"));
        Parser parser = new Parser();
        Visitor visitor = new Visitor();
        Exp result = (Exp) parser.parse(lexer);
        System.out.println(result.accept(visitor));
    }
}
