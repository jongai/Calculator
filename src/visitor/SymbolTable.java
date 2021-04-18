package visitor;

import ast.*;

public class SymbolTable {
    private SymbolTable next;
    private SymbolTable prev;
    private String key;
    private Exp val;

    public SymbolTable(String key, Exp val) {
        this();
        this.next = new SymbolTable();
        this.next.prev = this;
        this.next.key = key;
        this.next.val = val;
    }

    public SymbolTable() {
    }

    public Exp getVal(String key) {
        SymbolTable temp = this;
        while (temp.key != key.intern()) {
            if (temp.next == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp.val;
    }

    public void del(String key) {
        SymbolTable temp = this;
        while (temp.key != key.intern()) {
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }
        temp.prev.next = temp.next;
    }

    public void add(String key, Exp val) {
        SymbolTable temp = new SymbolTable(key, val);
        temp.next.next = this.next;
        if (this.next != null) {
            this.next.prev = temp.next;
        }
        this.next = temp.next;
        temp.next.prev = this;
    }
}
