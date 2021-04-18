package ast;

import visitor.Visitor;

public class Plus extends BinExp {
    public Plus(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public Integer accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
