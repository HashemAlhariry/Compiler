package parser;
//local_decl → type_spec IDENT  BBB

public class Local_decl implements Node {
    Type_spec type_spec;
    Token ident;
    B b;
    @Override
    public void printNode() {
        type_spec.printNode();
        System.out.println(ident.getValue());
        b.printNode();
    }

    public Local_decl(Type_spec type_spec, Token ident, B b) {
        this.type_spec = type_spec;
        this.ident = ident;
        this.b = b;
    }
}
