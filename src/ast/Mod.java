package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class Mod extends BinExp {
    /**
     * @param left
     * @param right
     */
    public Mod(Exp left, Exp right) {
        super(left, right);
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
