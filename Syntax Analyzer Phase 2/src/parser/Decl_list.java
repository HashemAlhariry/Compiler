package parser;
//decl_list →  decl decl_list`
public class Decl_list implements Node {

    Decl decl;
    Decl_list_ decl_list_;

    public Decl_list(Decl decl, Decl_list_ decl_list_) {
        this.decl = decl;
        this.decl_list_ = decl_list_;
    }

    @Override
    public void printNode() {
        if(decl!= null && decl_list_!=null)
        {
            decl.printNode();
            decl_list_.printNode();
        }

    }
}
