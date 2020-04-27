package parser;
// while_stmt → WHILE ( expr ) stmt
public class While_stmt implements Node {
    Token while_;
    Token left_round_b;
    Expr expr;
    Token right_round_b;
    Stmt stmt;

    public While_stmt(Token while_, Token left_round_b, Expr expr, Token right_round_b, Stmt stmt) {
        this.while_ = while_;
        this.left_round_b = left_round_b;
        this.expr = expr;
        this.right_round_b = right_round_b;
        this.stmt = stmt;
    }

    @Override
    public void printNode() {
        System.out.println(while_.getValue());
        System.out.println(left_round_b.getValue());
        expr.printNode();
        System.out.println(right_round_b.getValue());
        stmt.printNode();
    }
}
