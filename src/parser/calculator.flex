package parser;
import beaver.Symbol;
import beaver.Scanner;

%%

%class Lexer
%public
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	return newToken(Terminals.EOF, "end-of-file");
%eofval}
%unicode
%line
%column
%{
	private Symbol newToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol newToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}
%}
LineTerminator = \r|\n|\r\n
Comments = ("/*"([^*]|('*'+ [^*/]))*\*+"/") | ("//"[^\r\n]*)
WhiteSpace     = {LineTerminator} | {Comments} | [ \t\f]

Integer        = 0 | [1-9][0-9]*

%%
<YYINITIAL> {
    {Integer}            { return newToken(Terminals.INT_LIT, Integer.valueOf(yytext())); }
    "+"                  { return newToken(Terminals.PLUS); }
    "-"                  { return newToken(Terminals.MINUS); }
    "*"                  { return newToken(Terminals.TIMES); }
    "/"                  { return newToken(Terminals.DIVIDE); }
    "%"                  { return newToken(Terminals.MOD); }
    "("                  { return newToken(Terminals.LPAREN); }
    ")"                  { return newToken(Terminals.RPAREN); }
    {WhiteSpace}+        { /* ignore */ }
}

[^]                      { throw new Scanner.Exception("unexpected character '" + yytext() + "'"); }
