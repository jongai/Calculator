package ast;

import java.math.BigInteger;

import visitor.Visitor;

public class Sqrt extends Exp {
    private Exp e;

    public Sqrt(Exp e) {
        this.e = e;
    }

    @Override
    public boolean hasID(String a) {
        return e.hasID(a);
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        return e.accept(visitor).sqrt();
    }
}
