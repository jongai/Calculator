package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * The assign node.
 * 
 * @author Jonathan Gai
 *
 */
public class Assign extends Node {
    /**
     * The identifier.
     */
    public final String left;
    /**
     * The assignement Value.
     */
    public final Exp right;

    /**
     * Creates an Assign node with the identifier and the value.
     * 
     * @param left The identifier.
     * @param right The assigned value.
     */
    public Assign(String left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        if (right.hasID(left))
            visitor.symb.add(left.intern(), new IntLit(right.accept(visitor)));
        else
            visitor.symb.add(left.intern(), right);
        return null;
    }
}
