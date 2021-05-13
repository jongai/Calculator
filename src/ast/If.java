package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class If extends Node {
    /**
     * 
     */
    private Exp e;
    /**
     * 
     */
    private Program p;

    /**
     * @param e
     * @param p
     */
    public If(Exp e, Program p) {
        this.e = e;
        this.p = p;
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        if (e.acceptBool(visitor)) {
            visitor.visit(p);
        }
        return null;
    }
}
