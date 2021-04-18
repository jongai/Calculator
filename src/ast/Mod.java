package ast;

import visitor.Visitor;

public class Mod extends BinExp {
    public Mod(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public Integer accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
