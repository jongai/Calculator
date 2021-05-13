package ast;

import visitor.Visitor;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Jonathan Gai
 *
 */
public class Program extends Node {
    /**
     * 
     */
    public ArrayList<Node> list;
    
    /**
     * 
     */
    public Program() {
        list = new ArrayList<Node>();
    }
    
    /**
     * @param n
     */
    public void add(Node n)
    {
        list.add(n);
    }

    /**
     *
     */
    @Override
    public BigInteger accept(Visitor visitor) {
        return null;
    }
}