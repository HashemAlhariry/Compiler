package parser;
//param → type_spec IDENT BB
public class Param implements Node {
    Type_spec type_spec;
    Token ident;
    BB bb;

    public Param(Type_spec type_spec, Token ident, BB bb) {
        this.type_spec = type_spec;
        this.ident = ident;
        this.bb = bb;
    }

    @Override
    public void printNode() {
        type_spec.printNode();
        System.out.println(ident.getValue());
        bb.printNode();
    }
}
