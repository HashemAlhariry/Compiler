package parser;
//decl → var_decl | fun_decl
public class Decl implements Node{
        Var_decl var_decl;
        Func_decl func_decl;
    @Override
    public void printNode() {
     if(var_decl!=null)
     {
         var_decl.printNode();
     }
     else
         func_decl.printNode();

    }

    public Decl(Func_decl func_decl) {
        this.func_decl = func_decl;
    }

    public Decl(Var_decl var_decl) {
        this.var_decl = var_decl;
    }
}
