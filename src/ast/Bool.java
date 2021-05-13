package ast;

import visitor.Visitor;

/**
 * The boolean node.
 * 
 * @author Jonathan Gai
 *
 */
public abstract class Bool extends Exp {
    abstract public Boolean acceptBool(Visitor visitor);
}
