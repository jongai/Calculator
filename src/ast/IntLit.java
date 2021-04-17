package ast;
import visitor.*;

public class IntLit extends Exp {
    public final Integer val;

    public IntLit(Integer val) {
        this.val = val;
    }

    @Override
    public Integer getValue() {
        return val;
    }
    
    @Override
    public Integer accept(Visitor visitor) {
        return val;
    }
}