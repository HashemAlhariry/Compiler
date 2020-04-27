package parser;
//program → decl_list
public class Program implements Node {

    Decl_list decl_list;

    public Program(Decl_list decl_list) {
        this.decl_list = decl_list;
    }

    @Override
    public void printNode() {
        decl_list.printNode();
    }

}
