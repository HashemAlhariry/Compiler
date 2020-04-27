package parser;
//arg_list' → , expr  arg_list' | ε
public class Arg_list_ implements Node {
    Token comma ;
    Expr expr;
    Arg_list_ arg_list_;

    public Arg_list_(Token comma, Expr expr, Arg_list_ arg_list_) {
        this.comma = comma;
        this.expr = expr;
        this.arg_list_ = arg_list_;
    }

    public Arg_list_() {
    }

    @Override
    public void printNode() {

        if(comma!=null ){
        System.out.println(comma.getValue());
        expr.printNode();
        arg_list_.printNode();
        }

    }
}
