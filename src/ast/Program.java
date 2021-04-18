package ast;

import visitor.Visitor;
import java.util.ArrayList;

public class Program extends Node {
    public ArrayList<Node> list;
    
    public Program() {
        list = new ArrayList<Node>();
    }
    
    public void add(Node n)
    {
        list.add(n);
    }

    @Override
    public Integer accept(Visitor visitor) {
        return null;
    }
}