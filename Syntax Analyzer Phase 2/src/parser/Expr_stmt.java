package parser;
//expr_stmt → expr ; | ;
public class Expr_stmt  implements  Node{

    Expr expr;
    Token semicolon;

    public Expr_stmt(Expr expr, Token semicolon) {
        this.expr = expr;
        this.semicolon = semicolon;
    }

    public Expr_stmt(Token semicolon) {
        this.semicolon = semicolon;
    }

    @Override
    public void printNode() {
        if(expr!=null)
        {
            expr.printNode();
            System.out.println(semicolon);
        }
        else
        {
            System.out.println(semicolon);
        }
    }
}
