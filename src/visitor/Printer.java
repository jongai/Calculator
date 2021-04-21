package visitor;

import java.math.BigInteger;
import java.util.ArrayList;

import ast.Exp;
import ast.For;
import ast.Node;
import ast.Print;
import ast.Program;

public class Printer extends Visitor {
    @Override
    public ArrayList<BigInteger> visit(Program p) {
        for (Node n : p.list) {
            if (n instanceof Exp)
                System.out.println("> " + n.accept(this));
            if (n instanceof For)
                ((For) n).acceptAll(this);
            if (n instanceof Print)
                ((Print) n).accept(this);
            else
                n.accept(this);
        }
        return null;
    }
}
