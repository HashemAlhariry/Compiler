package parser;
//params → param_list | VOID
public class Params implements  Node{

    Param_list param_list;
    Token void_;
    @Override
    public void printNode() {
        if(param_list!=null)
        {
            param_list.printNode();
        }
        else
            System.out.println(void_.getValue());
    }

    public Params(Token void_) {
        this.void_ = void_;
    }

    public Params(Param_list param_list) {
        this.param_list = param_list;
    }
}
