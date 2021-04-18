package visitor;

import ast.*;
import java.util.ArrayList;

public class Visitor {
    public SymbolTable symb = new SymbolTable();

    public ArrayList<Integer> visit(Program p) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (Node n : p.list) {
            if (n instanceof Exp)
                out.add(n.accept(this));
            else
                n.accept(this);
        }
        return out;
    }

    public Integer visit(Plus e) {
        return e.left.accept(this) + e.right.accept(this);
    }

    public Integer visit(Minus e) {
        return e.left.accept(this) - e.right.accept(this);
    }

    public Integer visit(Times e) {
        return e.left.accept(this) * e.right.accept(this);
    }

    public Integer visit(Divide e) {
        return e.left.accept(this) / e.right.accept(this);
    }

    public Integer visit(Mod e) {
        return e.left.accept(this) % e.right.accept(this);
    }

    public Integer visit(IntLit e) {
        return e.accept(this);
    }

    public Integer visit(Identifier i) {
        return i.accept(this);
    }
}
