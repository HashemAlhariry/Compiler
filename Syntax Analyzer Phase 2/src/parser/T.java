
package parser;


//T → OR expr | EQ expr | NE expr |LE expr | < expr |GE expr |> expr|AND exp|+ expr| - expr | * expr | / expr | % expr
public class T implements Node {
    Token or;
    Expr expr;
    Token eq;
    Token NE;
    Token LE;
    Token lessthan;
    Token ge;
    Token greaterthan;
    Token and;
    Token plus;
    Token minus;
    Token multi;
    Token divide;
    Token remainder;

    public T(Token or, Expr expr) {
        this.or = or;
        this.expr = expr;
    }

    @Override
    public void printNode() {
        System.out.println(or.getValue());
        expr.printNode();
    }
}
