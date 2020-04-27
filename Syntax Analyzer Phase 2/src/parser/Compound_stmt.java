package parser;
// compound_stmt → { local_decls stmt_list }

public class Compound_stmt implements Node {

    Token left_curly_b;
    Local_decls local_decls;
    Stmt_list stmt_list;
    Token right_curly_b;

    @Override
    public void printNode() {
      System.out.println(left_curly_b.getValue());
      local_decls.printNode();
      stmt_list.printNode();
      System.out.println(right_curly_b.getValue());
    }

    public Compound_stmt(Token left_curly_b, Local_decls local_decls, Stmt_list stmt_list, Token right_curly_b) {
        this.left_curly_b = left_curly_b;
        this.local_decls = local_decls;
        this.stmt_list = stmt_list;
        this.right_curly_b = right_curly_b;
    }
}
