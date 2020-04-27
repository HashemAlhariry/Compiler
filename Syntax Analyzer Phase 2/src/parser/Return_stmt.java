package parser;

//return_stmt → RETURN x
public class Return_stmt implements Node {
    Token return_;
    X x;

    public Return_stmt(Token return_, X x) {
        this.return_ = return_;
        this.x = x;
    }

    @Override
    public void printNode() {
        System.out.println(return_.getValue());
        x.printNode();
    }
}
