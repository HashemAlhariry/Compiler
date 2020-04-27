package parser;
//arg_list → expr arg_list'
public class Arg_list implements Node {
    Expr expr;
    Arg_list_ arg_list_;

    public Arg_list(Expr expr, Arg_list_ arg_list_) {
        this.expr = expr;
        this.arg_list_ = arg_list_;
    }

    @Override
    public void printNode() {
      expr.printNode();
      arg_list_.printNode();
    }
}
