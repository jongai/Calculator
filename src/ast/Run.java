package ast;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import beaver.Parser.Exception;
import parser.Lexer;
import parser.Parser;
import visitor.Visitor;

/**
 * Runs an external file using the language.
 * @author Jonathan Gai
 *
 */
public class Run extends Node {
    /**
     * The name of the file to be run.
     */
    public String f;

    /**
     * @param f The name of the file to be run.
     */
    public Run(String f) {
        this.f = f;
    }

    /**
     * Accepts the visitor.
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        Parser parser = new Parser();
        Lexer lexer = null;
        try {
            lexer = new Lexer(new FileReader(f + ".txt"));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Program result = null;
        try {
            result = (Program) parser.parse(lexer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        visitor.visit(result);
        return null;
    }
}
