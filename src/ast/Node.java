package ast;
import visitor.*;

import java.math.BigInteger;

import beaver.Symbol;

/**
 * @author Jonathan Gai
 *
 */
public abstract class Node extends Symbol {
    /**
     * @param visitor The visitor visiting the node.
     * @return The value of the node.
     */
    public abstract BigInteger accept(Visitor visitor);
}
