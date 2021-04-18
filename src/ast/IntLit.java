package ast;
import java.math.BigInteger;

import visitor.*;

public class IntLit extends Exp {
    public final BigInteger val;

    public IntLit(BigInteger val) {
        this.val = val;
    }

    @Override
    public BigInteger accept(Visitor visitor) {
        return val;
    }

    @Override
    public boolean hasID(String a) {
        return false;
    }
}
