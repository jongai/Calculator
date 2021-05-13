package ast;

import java.math.BigInteger;
import java.util.ArrayList;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class For extends Node {
    /**
     * 
     */
    public Exp e;
    /**
     * 
     */
    public Program p;
    
    /**
     * @param e
     * @param p
     */
    public For(Exp e, Program p) {
        this.e = e;
        this.p = p;
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        return null;
    }
    
    /**
     * @param visitor
     * @return
     */
    public ArrayList<BigInteger> acceptAll(Visitor visitor) {
        for (int i = 0; i < e.accept(visitor).intValue(); i++) {
            visitor.visit(p);
        }
        return null;
    }
}
