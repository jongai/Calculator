package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import beaver.Parser.Exception;
import beaver.Scanner;
import parser.Lexer;
import parser.Parser;
import ast.*;
import visitor.*;

class CalculatorTest {
    Parser parser = new Parser();
    Visitor visitor = new Visitor();

    @Test
    @DisplayName("Addition")
    void add() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 + 3;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(5), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Subtraction")
    void sub() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 - 3;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(-1), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Multiplication")
    void mul() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 3;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(6), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Multiplication by zero")
    void mulByZero() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 0;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(0), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Division")
    void div() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("10 / 3;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(3), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Precedence")
    void prec() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * 3 - 1 * 5 + 5 / 2 + 5 % 2;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(4), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Parenthesis1")
    void paren1() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("2 * (3 - 1) * 5;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(20), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("Parenthesis2")
    void paren2() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("(2 + 3 * ((3 - 1) + 5)) * 4;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(92), visitor.visit(result).get(0));
    }

    @Test
    @DisplayName("ST initiation")
    void STinit() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("1;"));
        Program result = (Program) parser.parse(lexer);
        SymbolTable st = new SymbolTable("one", (Exp) result.list.get(0));
        assertEquals(st.getVal("one"), (Exp) result.list.get(0));
    }

    @Test
    @DisplayName("ST delete last element")
    void STdelLast() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("1;"));
        Program result = (Program) parser.parse(lexer);
        SymbolTable st = new SymbolTable("one", (Exp) result.list.get(0));
        st.del("one");
        assertEquals(st.getVal("one"), null);
    }

    @Test
    @DisplayName("ST delete empty")
    void STdelEmpty() throws IOException, Exception {
        SymbolTable st = new SymbolTable();
        st.del("one");
        assertEquals(st.getVal("one"), null);
    }
    
    @Test
    @DisplayName("ST add empty")
    void STaddEmpty() throws IOException, Exception {
        SymbolTable st = new SymbolTable();
        Scanner lexer = new Lexer(new StringReader("1;"));
        Program result = (Program) parser.parse(lexer);
        st.add("one", (Exp) result.list.get(0));
        assertEquals(st.getVal("one"), (Exp) result.list.get(0));
    }


    @Test
    @DisplayName("ST delete duplicate")
    void STdelDup() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("1;"));
        Program result = (Program) parser.parse(lexer);
        SymbolTable st = new SymbolTable("one", (Exp) result.list.get(0));
        st.del("one");
        st.add("one", (Exp) result.list.get(0));
        assertEquals(st.getVal("one"), (Exp) result.list.get(0));
    }
    
    @Test
    @DisplayName("Simple Assign")
    void simpleAssign() throws IOException, Exception {
        Scanner lexer = new Lexer(new StringReader("a = 1; a;"));
        Program result = (Program) parser.parse(lexer);
        assertEquals(BigInteger.valueOf(1), visitor.visit(result).get(0));
    }
}
