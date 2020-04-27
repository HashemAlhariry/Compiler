package parser;
//param_list`→ , param  param_list` | ε
public class Param_list_ implements Node{
    Token comma;
    Param param;
    Param_list_ param_list_;

    public Param_list_(Token comma, Param param, Param_list_ param_list_) {
        this.comma = comma;
        this.param = param;
        this.param_list_ = param_list_;
    }

    @Override
    public void printNode() {

        if(param !=null){
            System.out.println(comma.getValue());
            param.printNode();
            param_list_.printNode();

        }
    }
}
