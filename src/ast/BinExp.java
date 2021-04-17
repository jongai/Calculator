package ast;

public abstract class BinExp extends Exp {
    public final Exp left;
    public final Exp right;
    
    
    public BinExp(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
