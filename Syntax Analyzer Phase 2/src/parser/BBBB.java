package parser;
//BBBB → ε | ELSE stmt
public class BBBB implements Node {
    Token else_;
    Stmt stmt;

    public BBBB(Token else_, Stmt stmt) {
        this.else_ = else_;
        this.stmt = stmt;
    }

    @Override
    public void printNode() {
        if (else_ != null) {
            System.out.println(else_.getValue());
            stmt.printNode();
        }
    }

    public BBBB() {
    }
}
