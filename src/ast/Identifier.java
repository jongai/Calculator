package ast;

import java.math.BigInteger;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public class Identifier extends Exp {
    /**
     * 
     */
    public final String val;

    /**
     * @param val
     */
    public Identifier(String val) {
        this.val = val;
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor){
        if (visitor.symb.getVal(val) == null) {
            System.out.println("Undefined Variables");
            System.exit(1);
        }
        return visitor.symb.getVal(val).accept(visitor);
    }

    /**
     *
     */
    @Override
    public boolean hasID(String a) {
        return val.equals(a);
    }
}
