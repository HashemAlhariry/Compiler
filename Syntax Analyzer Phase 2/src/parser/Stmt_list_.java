package parser;
//stmt_list` → stmt stmt_list`| ε
public class Stmt_list_ implements Node{
   Stmt stmt;
   Stmt_list_ stmt_list_;

    public Stmt_list_() {
    }

    public Stmt_list_(Stmt stmt, Stmt_list_ stmt_list_) {
        this.stmt = stmt;
        this.stmt_list_ = stmt_list_;
    }

    @Override
    public void printNode() {
   if(stmt!=null)
   {
       stmt.printNode();
       stmt_list_.printNode();
   }
    }
}
