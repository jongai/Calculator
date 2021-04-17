package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.Exp;

class CalculatorTest {
    Parser parser = new Parser();

    @Test
    @DisplayName("Addition")
    void add() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 + 3"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(5, result.val);
    }

    @Test
    @DisplayName("Subtraction")
    void sub() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 - 3"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(-1, result.val);
    }

    @Test
    @DisplayName("Multiplication")
    void mul() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 3"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(6, result.val);
    }

    @Test
    @DisplayName("Multiplication by zero")
    void mulByZero() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 0"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(0, result.val);
    }

    @Test
    @DisplayName("Division")
    void div() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("10 / 3"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(3, result.val);
    }

    @Test
    @DisplayName("Precedence")
    void prec() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 3 - 1 * 5 + 5 / 2 + 5 % 2"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(4, result.val);
    }

    @Test
    @DisplayName("Parenthesis1")
    void paren1() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * (3 - 1) * 5"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(20, result.val);
    }

    @Test
    @DisplayName("Parenthesis2")
    void paren2() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("(2 + 3 * ((3 - 1) + 5)) * 4"));
        Exp result = (Exp) parser.parse(lexer);
        assertEquals(92, result.val);
    }
}
