package visitor;

import ast.*;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * The Visitor class that visits the nodes of the abstract syntax
 * tree.
 * 
 * @author Jonathan Gai
 *
 */
public class Visitor {
    public SymbolTable symb = new SymbolTable();

    public ArrayList<BigInteger> visit(Program p) {
        ArrayList<BigInteger> out = new ArrayList<BigInteger>();
        for (Node n : p.list) {
            if (n instanceof Exp)
                out.add(n.accept(this));
            if (n instanceof For)
                out.addAll(((For) n).acceptAll(this));
            if (n instanceof Print)
                ((Print) n).accept(this);
            else
                n.accept(this);
        }
        return out;
    }

    /**
     * @param e The plus node.
     * @return The value of the plus node.
     */
    public BigInteger visit(Plus e) {
        return e.left.accept(this).add(e.right.accept(this));
    }

    /**
     * @param e The minus node.
     * @return The value of the minus node.
     */
    public BigInteger visit(Minus e) {
        return e.left.accept(this).subtract(e.right.accept(this));
    }

    /**
     * @param e The times node.
     * @return The value of the times node.
     */
    public BigInteger visit(Times e) {
        return e.left.accept(this).multiply(e.right.accept(this));
    }

    /**
     * @param e The divide node.
     * @return The value of the divide node.
     */
    public BigInteger visit(Divide e) {
        return e.left.accept(this).divide(e.right.accept(this));
    }

    /**
     * @param e The mod node.
     * @return The value of the mod node.
     */
    public BigInteger visit(Mod e) {
        return e.left.accept(this).mod(e.right.accept(this));
    }

    /**
     * @param e The exponent node.
     * @return The value of the exponent node.
     */
    public BigInteger visit(Expn e) {
        return e.left.accept(this).pow(e.right.accept(this).intValue());
    }

    /**
     * @param e The integer literal node.
     * @return The value of the integer literal node.
     */
    public BigInteger visit(IntLit e) {
        return e.accept(this);
    }

    /**
     * @param e The identifier node.
     * @return The value of the identifier node.
     */
    public BigInteger visit(Identifier i) {
        return i.accept(this);
    }
}
