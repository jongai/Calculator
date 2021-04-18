package ast;

import visitor.Visitor;

public class Times extends BinExp {
    public Times(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public Integer accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
