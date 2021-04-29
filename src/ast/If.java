package ast;

import java.math.BigInteger;

import visitor.Visitor;

public class If extends Node {
    private Exp e;
    private Program p;

    public If(Exp e, Program p) {
        this.e = e;
        this.p = p;
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        if (e.acceptBool(visitor)) {
            visitor.visit(p);
        }
        return null;
    }
}
