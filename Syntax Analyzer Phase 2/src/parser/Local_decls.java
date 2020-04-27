package parser;


//local_decls →   local_decls`
public class Local_decls implements Node {
    Local_decls_ local_decls_;
    @Override
    public void printNode() {
        local_decls_.printNode();
    }

    public Local_decls(Local_decls_ local_decls_) {
        this.local_decls_ = local_decls_;
    }
}
