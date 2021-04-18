package ast;

import visitor.Visitor;

public class Identifier extends Exp {
    public final String val;

    public Identifier(String val) {
        this.val = val;
    }

    @Override
    public Integer accept(Visitor visitor){
        if (visitor.symb.getVal(val) == null) {
            System.out.println("Undefined Variables");
            System.exit(1);
        }
        return visitor.symb.getVal(val).accept(visitor);
    }

    @Override
    public boolean hasID(String a) {
        return val.equals(a);
    }
}
