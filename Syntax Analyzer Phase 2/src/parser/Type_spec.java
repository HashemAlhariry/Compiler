package parser;
//type_spec → VOID | BOOL | INT | FLOAT
public class Type_spec  implements Node{

    Token int_;
    Token void_;
    Token bool_;
    Token float_;

    @Override
    public void printNode() {
        System.out.println(int_.getValue());
    }

    public Type_spec(Token int_) {
        this.int_ = int_;
    }
}
