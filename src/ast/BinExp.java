package ast;

/**
 * @author Jonathan Gai
 *
 */
public abstract class BinExp extends Exp {
    /**
     * 
     */
    public final Exp left;
    /**
     * 
     */
    public final Exp right;
    
    
    /**
     * @param left
     * @param right
     */
    public BinExp(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
    
    /**
     *
     */
    @Override
    public boolean hasID(String a) {
        return left.hasID(a) || right.hasID(a);
    }
}
