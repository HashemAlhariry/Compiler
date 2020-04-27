package parser;
//expr → IDENT Z
//expr → expr`
// → ! expr | - expr | + expr
// → ( expr )
// → BOOL_LIT | INT_LIT | FLOAT_LIT | NEW type_spec [ expr ]

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Expr implements Node {
    Token ident;
    Expr expr;
    Z z;
    Expr_ expr_;
    Token exclimationMark;
    Token minus;
    Token plus;
    Token leftroundbracket;
    Token rightroundbracket;
    Token bool_lit;
    Token int_lit;
    Token float_lit;
    Token neww;
    Type_spec type_spec;
    Token leftsquarebracket;
    Token rightsquarebracket;

    public Expr(Expr expr, Token exclimationMark) {
        this.expr = expr;
        this.exclimationMark = exclimationMark;
    }

    public Expr(Expr expr, Token neww, Type_spec type_spec, Token leftsquarebracket, Token rightsquarebracket) {
        this.expr = expr;
        this.neww = neww;
        this.type_spec = type_spec;
        this.leftsquarebracket = leftsquarebracket;
        this.rightsquarebracket = rightsquarebracket;
    }

    public Expr(Token bool_lit) {
        this.bool_lit = bool_lit;
    }

    public Expr(Expr expr, Token leftroundbracket, Token rightroundbracket) {
        this.expr = expr;
        this.leftroundbracket = leftroundbracket;
        this.rightroundbracket = rightroundbracket;
    }

    public Expr(Expr_ expr_) {
        this.expr_ = expr_;
    }

    public Expr(Token ident, Z z) {
        this.ident = ident;
        this.z = z;
    }

    @Override
    public void printNode() {
        if(ident!=null){
            System.out.println(ident.getValue());
            z.printNode();
        }
        else if(expr_!=null){
            expr_.printNode();
        }
        else if(exclimationMark!=null && expr!=null){
            System.out.println(exclimationMark.getValue());
            expr.printNode();
        }
        else if(leftroundbracket!=null && rightroundbracket!=null){
            System.out.println(leftroundbracket.getValue());
            expr.printNode();
            System.out.println(rightroundbracket.getValue());
        }
        else if(bool_lit!=null)
            System.out.println(bool_lit.getValue());
        else if(neww!=null){
            System.out.println(neww.getValue());
            type_spec.printNode();
            System.out.println(leftsquarebracket.getValue());
            expr.printNode();
            System.out.println(rightsquarebracket.getValue());
        }
    }
}
