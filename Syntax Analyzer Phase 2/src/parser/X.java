package parser;

//x → ; | expr ;
public class X implements Node {
    Token simicolon;
    Expr expr;
    @Override
    public void printNode() {

        if(expr!=null)
            expr.printNode();

        System.out.println(simicolon.getValue());
    }

    public X(Token simicolon) {
        this.simicolon = simicolon;
    }

    public X(Token simicolon, Expr expr) {
        this.simicolon = simicolon;
        this.expr = expr;
    }
}
