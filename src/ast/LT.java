package ast;

import java.math.BigInteger;

import visitor.Visitor;

public class LT extends Bool {
    private Exp e1;
    private Exp e2;

    public LT(Exp e1, Exp e2) {
        super();
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @Override
    public BigInteger accept(Visitor visitor) {
        return BigInteger.valueOf(e1.accept(visitor).compareTo(e2.accept(visitor)));
    }

    @Override
    public boolean hasID(String a) {
        return e1.hasID(a) || e2.hasID(a);
    }

    @Override
    public Boolean acceptBool(Visitor visitor) {
        return e1.accept(visitor).compareTo(e2.accept(visitor)) == -1;
    }
}
