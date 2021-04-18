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
        Scanner lexer = new Lexer(new StringReader("a = 1; b = 2; a = a + 1; a;"));
        Parser parser = new Parser();
        Visitor visitor = new Visitor();
        Program result = (Program) parser.parse(lexer);
        System.out.println(visitor.visit(result));
    }
}
