package parser;
//stmt_list →  stmt_list`
public class Stmt_list implements Node{
    Stmt_list_ stmt_list_;

    public Stmt_list(Stmt_list_ stmt_list_) {
        this.stmt_list_ = stmt_list_;
    }

    @Override
    public void printNode() {
stmt_list_.printNode();
    }
}
