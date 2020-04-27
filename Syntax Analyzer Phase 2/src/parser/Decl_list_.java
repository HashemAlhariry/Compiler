package parser;
//decl_list` → decl decl_list` | ε
public class Decl_list_ implements Node {

    Decl decl;
    Decl_list_ decl_list_;
    @Override
    public void printNode() {
            if(decl!=null)
            {
                decl.printNode();
            }
            if(decl_list_ != null)
                decl_list_.printNode();
    }

    public Decl_list_() {
    }

    public Decl_list_(Decl decl, Decl_list_ decl_list_) {
        this.decl = decl;
        this.decl_list_ = decl_list_;
    }
}
