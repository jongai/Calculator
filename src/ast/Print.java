package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class Print extends Node {
    /**
     * 
     */
    public String i;
    
    /**
     * @param i
     */
    public Print(String i) {
        this.i = i;
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        System.out.println("> " + i);
        return null;
    }
}
