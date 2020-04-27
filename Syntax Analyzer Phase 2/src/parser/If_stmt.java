package parser;


//if_stmt → IF ( expr ) stmt BBBB
public class If_stmt implements Node {
    Token if_;
    Token leftroundbracket;
    Expr expr;
    Token rightroundbracket;
    Stmt stmt;
    BBBB bbbb;
    @Override
    public void printNode() {
        System.out.println(if_.getValue());
        System.out.println(leftroundbracket.getValue());
        expr.printNode();
        System.out.println(rightroundbracket.getValue());
        stmt.printNode();
        bbbb.printNode();
    }

    public If_stmt(Token if_, Token leftroundbracket, Expr expr, Token rightroundbracket, Stmt stmt, BBBB bbbb) {
        this.if_ = if_;
        this.leftroundbracket = leftroundbracket;
        this.expr = expr;
        this.rightroundbracket = rightroundbracket;
        this.stmt = stmt;
        this.bbbb = bbbb;
    }
}
