package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * The minus node.
 * 
 * @author Jonathan Gai
 *
 */
public class Minus extends BinExp {
    /**
     * @param left The left operand.
     * @param right The right operand.
     */
    public Minus(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
