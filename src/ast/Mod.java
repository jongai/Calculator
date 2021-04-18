package ast;

import java.math.BigInteger;

import visitor.Visitor;

public class Mod extends BinExp {
    public Mod(Exp left, Exp right) {
        super(left, right);
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
