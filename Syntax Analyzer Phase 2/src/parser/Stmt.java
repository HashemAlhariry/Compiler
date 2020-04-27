package parser;
//stmt → expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt | break_stmt
public class Stmt implements Node {

    Expr_stmt expr_stmt;
    Compound_stmt compound_stmt;
    If_stmt if_stmt;
    While_stmt while_stmt;
    Return_stmt return_stmt;
    Token break_stmt;
    @Override
    public void printNode() {
        if(expr_stmt!=null)
        {
            expr_stmt.printNode();
        }else   if(compound_stmt!=null)
        {
            compound_stmt.printNode();
        }
        else   if(if_stmt!=null)
        {
            if_stmt.printNode();
        }else   if(while_stmt!=null)
        {
            while_stmt.printNode();
        }else   if(return_stmt!=null)
        {
            return_stmt.printNode();
        }else {
            System.out.println(break_stmt.getValue());
        }
    }

    public Stmt(Token break_stmt) {
        this.break_stmt = break_stmt;
    }

    public Stmt(Return_stmt return_stmt) {
        this.return_stmt = return_stmt;
    }

    public Stmt(While_stmt while_stmt) {
        this.while_stmt = while_stmt;
    }

    public Stmt(If_stmt if_stmt) {
        this.if_stmt = if_stmt;
    }

    public Stmt(Compound_stmt compound_stmt) {
        this.compound_stmt = compound_stmt;
    }

    public Stmt(Expr_stmt expr_stmt) {
        this.expr_stmt = expr_stmt;
    }
}
