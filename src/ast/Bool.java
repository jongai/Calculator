package ast;

import visitor.Visitor;

public abstract class Bool extends Exp {
    abstract public Boolean acceptBool(Visitor visitor);
}
