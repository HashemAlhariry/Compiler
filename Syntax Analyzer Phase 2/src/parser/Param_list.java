package parser;
//param_list → param  param_list`
public class Param_list implements  Node{
    Param param;
    Param_list_ param_list_;

    public Param_list(Param param, Param_list_ param_list_) {
        this.param = param;
        this.param_list_ = param_list_;
    }

    @Override
    public void printNode() {
        param.printNode();
        param_list_.printNode();
    }
}
