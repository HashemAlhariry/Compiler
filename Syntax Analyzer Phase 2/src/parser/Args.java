package parser;

//args → arg_list | ε
public class Args implements Node {
    Arg_list arg_list;

    public Args() {
    }

    @Override
    public void printNode() {
           arg_list.printNode();
    }

    public Args(Arg_list arg_list) {
        this.arg_list = arg_list;
    }
}
