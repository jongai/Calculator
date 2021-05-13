package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * The square root node.
 * @author Jonathan Gai
 *
 */
public class Sqrt extends Exp {
    /**
     * The value to be square rooted.
     */
    private Exp e;

    /**
     * @param e The value to be square rooted.
     */
    public Sqrt(Exp e) {
        this.e = e;
    }

    /**
     * Check if the expression contains variable a.
     */
    @Override
    public boolean hasID(String a) {
        return e.hasID(a);
    }

    /**
     * Accepts the visitor.
     * 
     * @return The square root of the value.s
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        return e.accept(visitor).sqrt();
    }
}
