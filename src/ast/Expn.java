package ast;

import visitor.Visitor;

public class Expn extends BinExp {
    public Expn(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public Integer accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
