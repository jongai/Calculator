package visitor;

import ast.*;

import java.math.BigInteger;
import java.util.ArrayList;

public class Visitor {
    public SymbolTable symb = new SymbolTable();

    public ArrayList<BigInteger> visit(Program p) {
        ArrayList<BigInteger> out = new ArrayList<BigInteger>();
        for (Node n : p.list) {
            if (n instanceof Exp)
                out.add(n.accept(this));
            else
                n.accept(this);
        }
        return out;
    }

    public BigInteger visit(Plus e) {
        return e.left.accept(this).add(e.right.accept(this));
    }

    public BigInteger visit(Minus e) {
        return e.left.accept(this).subtract(e.right.accept(this));
    }

    public BigInteger visit(Times e) {
        return e.left.accept(this).multiply(e.right.accept(this));
    }

    public BigInteger visit(Divide e) {
        return e.left.accept(this).divide(e.right.accept(this));
    }

    public BigInteger visit(Mod e) {
        return e.left.accept(this).mod(e.right.accept(this));
    }
    
    public BigInteger visit(Expn e) {
        return e.left.accept(this).pow(e.right.accept(this).intValue());
    }

    public BigInteger visit(IntLit e) {
        return e.accept(this);
    }

    public BigInteger visit(Identifier i) {
        return i.accept(this);
    }
}
