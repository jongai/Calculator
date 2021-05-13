package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class Plus extends BinExp {
    /**
     * @param left
     * @param right
     */
    public Plus(Exp left, Exp right) {
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
