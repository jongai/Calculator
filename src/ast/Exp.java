package ast;

import visitor.Visitor;

public abstract class Exp extends Node {
    public abstract boolean hasID(String a);
    public Boolean acceptBool(Visitor visitor) {
        return this.accept(visitor).intValue() > 0;
    }
}
