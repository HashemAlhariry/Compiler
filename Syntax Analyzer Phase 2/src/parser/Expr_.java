package parser;

//expr`→ T expr` | ε
public class Expr_ implements Node {
    T t;
    Expr_ expr_;

    public Expr_(T t, Expr_ expr_) {
        this.t = t;
        this.expr_ = expr_;
    }
    @Override
    public void printNode() {
        if(t!=null)
        {
           t.printNode();
           expr_.printNode();
        }
    }
}
