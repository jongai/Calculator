package parser;

import ast.*;
import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "calculator.grammar".
 */
public class Parser extends beaver.Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(Parser.class);

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = Exp
			new Action() {	// [1] Exp = Exp.e1 PLUS Exp.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final Exp e1 = (Exp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final Exp e2 = (Exp) _symbol_e2.value;
					 return new Plus(e1, e2);
				}
			},
			new Action() {	// [2] Exp = Exp.e1 MINUS Exp.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final Exp e1 = (Exp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final Exp e2 = (Exp) _symbol_e2.value;
					 return new Minus(e1, e2);
				}
			},
			new Action() {	// [3] Exp = Exp.e1 TIMES Exp.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final Exp e1 = (Exp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final Exp e2 = (Exp) _symbol_e2.value;
					 return new Times(e1, e2);
				}
			},
			new Action() {	// [4] Exp = Exp.e1 DIVIDE Exp.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final Exp e1 = (Exp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final Exp e2 = (Exp) _symbol_e2.value;
					 return new Divide(e1, e2);
				}
			},
			new Action() {	// [5] Exp = Exp.e1 MOD Exp.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final Exp e1 = (Exp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final Exp e2 = (Exp) _symbol_e2.value;
					 return new Mod(e1, e2);
				}
			},
			new Action() {	// [6] Exp = INT_LIT.i
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_i = _symbols[offset + 1];
					final Integer i = (Integer) _symbol_i.value;
					 return new IntLit(i);
				}
			},
			new Action() {	// [7] Exp = LPAREN Exp.e RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Exp e = (Exp) _symbol_e.value;
					 return e;
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
