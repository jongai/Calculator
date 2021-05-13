package ast;

import visitor.Visitor;

/**
 * @author Jonathan Gai
 *
 */
public abstract class Exp extends Node {
	/**
	 * @param a
	 * @return
	 */
	public abstract boolean hasID(String a);

	/**
	 * @param visitor
	 * @return
	 */
	public Boolean acceptBool(Visitor visitor) {
		return this.accept(visitor).intValue() > 0;
	}
}
