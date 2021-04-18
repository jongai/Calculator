package ast;

import visitor.Visitor;

public class Assign extends Node {
    public final String left;
    public final Exp right;

    public Assign(String left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer accept(Visitor visitor) {
        if (right.hasID(left))
            visitor.symb.add(left.intern(), new IntLit(right.accept(visitor)));
        else
            visitor.symb.add(left.intern(), right);
        return null;
    }
}
