package ast;
import visitor.*;

import java.math.BigInteger;

import beaver.Symbol;

public abstract class Node extends Symbol {
    public abstract BigInteger accept(Visitor visitor);
}
