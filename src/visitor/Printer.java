package visitor;

import java.math.BigInteger;
import java.util.ArrayList;

import ast.*;

/**
 * The printer extends visitor by changing the behavior from
 * returning the value to printing out the value to stdout.
 * 
 * @author Jonathan Gai
 *
 */
public class Printer extends Visitor {
    /**
     * Does not return anything but prints out the result.
     */
    @Override
    public ArrayList<BigInteger> visit(Program p) {
        for (Node n : p.list) {
            if (n instanceof Exp)
                System.out.println("> " + n.accept(this));
            if (n instanceof For)
                ((For) n).acceptAll(this);
            else
                n.accept(this);
        }
        return null;
    }
}
