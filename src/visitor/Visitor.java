package visitor;

import ast.*;

public class Visitor {
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
}
