package parser;
//fun_decl → type_spec IDENT ( params ) compound_stmt
public class Func_decl implements Node {

    Type_spec type_spec;
    Token ident;
    Token right_round_b;
    Params params;
    Token left_round_b;
    Compound_stmt compound_stmt;

    public Func_decl(Type_spec type_spec, Token ident, Token right_round_b, Params params, Token left_round_b, Compound_stmt compound_stmt) {
        this.type_spec = type_spec;
        this.ident = ident;
        this.right_round_b = right_round_b;
        this.params = params;
        this.left_round_b = left_round_b;
        this.compound_stmt = compound_stmt;
    }

    @Override
    public void printNode() {
            type_spec.printNode();
            System.out.println(ident.getValue());
            System.out.println(left_round_b);
            params.printNode();
            System.out.println(right_round_b);
            compound_stmt.printNode();
    }
}
