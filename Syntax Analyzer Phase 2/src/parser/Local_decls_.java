
package parser;

//local_decls` →   local_decl local_decls` | ε
public class Local_decls_ implements Node {
    Local_decl local_decl;
    Local_decls_ local_decls_;

    public Local_decls_() {
    }

    public Local_decls_(Local_decl local_decl, Local_decls_ local_decls_) {
        this.local_decl = local_decl;
        this.local_decls_ = local_decls_;
    }

    @Override
    public void printNode() {
        if (local_decls_ != null) {
            local_decl.printNode();
            local_decls_.printNode();
        }
    }
}
