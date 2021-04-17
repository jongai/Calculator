package ast;
import visitor.*;
import beaver.Symbol;

public abstract class Node extends Symbol {
    public abstract Integer accept(Visitor visitor);
}
