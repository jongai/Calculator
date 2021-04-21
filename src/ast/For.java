package ast;

import java.math.BigInteger;
import java.util.ArrayList;

import visitor.Visitor;

public class For extends Node {
    public Exp e;
    public Program p;
    
    public For(Exp e, Program p) {
        this.e = e;
        this.p = p;
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        return null;
    }
    
    public ArrayList<BigInteger> acceptAll(Visitor visitor) {
        for (int i = 0; i < e.accept(visitor).intValue(); i++) {
            visitor.visit(p);
        }
        return null;
    }
}
