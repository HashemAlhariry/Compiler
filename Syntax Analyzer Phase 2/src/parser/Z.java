package parser;

//Z  → = expr | [ expr ] = expr |  ε  |  [ expr ] |  ( args ) | . size
public class Z implements Node {
    Expr expr;
    Expr expr1;
    Token leftsquarebacket;
    Token rightsquarebracket;
    Token assign;
    Token leftroundbracket;
    Token rightroundbracket;
    Args args;
    Token dot;
    Token size;

    public Z(Token dot, Token size) {
        this.dot = dot;
        this.size = size;
    }

    public Z(Token leftroundbracket, Token rightroundbracket, Args args) {
        this.leftroundbracket = leftroundbracket;
        this.rightroundbracket = rightroundbracket;
        this.args = args;
    }

    public Z(Expr expr, Token leftsquarebacket, Token rightsquarebracket) {
        this.expr = expr;
        this.leftsquarebacket = leftsquarebacket;
        this.rightsquarebracket = rightsquarebracket;
    }

    public Z(Expr expr, Token assign) {
        this.expr = expr;
        this.assign = assign;
    }

    public Z(Expr expr, Expr expr1, Token leftsquarebacket, Token rightsquarebracket, Token assign) {
        this.expr = expr;
        this.expr1 = expr1;
        this.leftsquarebacket = leftsquarebacket;
        this.rightsquarebracket = rightsquarebracket;
        this.assign = assign;
    }

    public Z() {
    }



    @Override
    public void printNode() {
        if(expr1!=null){
            System.out.println(leftsquarebacket.getValue());
            expr.printNode();
            System.out.println(rightsquarebracket.getValue());
            System.out.println(assign.getValue());
            expr1.printNode();
        }
        else if(expr!=null && assign!=null && expr1==null){
            System.out.println(assign.getValue());
            expr.printNode();
        }
        else if(expr!=null && leftsquarebacket!=null && expr1==null){
            System.out.println(leftsquarebacket.getValue());
            expr.printNode();
            System.out.println(rightsquarebracket.getValue());
        }
        else if(args!=null){
            System.out.println(leftroundbracket.getValue());
            args.printNode();
            System.out.println(rightroundbracket.getValue());
        }
        else if(dot!=null){
            System.out.println(dot.getValue());
            System.out.println(size.getValue());
        }

    }
}
