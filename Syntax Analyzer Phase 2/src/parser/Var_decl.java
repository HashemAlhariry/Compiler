package parser;
//var_decl → type_spec IDENT B
public class Var_decl implements Node {

    Type_spec type_spec;
    Token ident;
    B b;

    public Var_decl(Type_spec type_spec, Token ident, B b) {
        this.type_spec = type_spec;
        this.ident = ident;
        this.b = b;
    }

    @Override
    public void printNode() {
        type_spec.printNode();
        System.out.println(ident.getValue());
        b.printNode();
    }
}
