package parser;
//B →  [ ] ; | ε ;
public class B  implements  Node{
    Token leftsquarebrac;
    Token rightsquarebrac;
    Token semicolon;

    @Override
    public void printNode() {
        if(leftsquarebrac != null) {
            System.out.println(leftsquarebrac.getValue());
            System.out.println(rightsquarebrac.getValue());
        }
        System.out.println(semicolon.getValue());
    }

    public B(Token leftsquarebrac, Token rightsquarebrac, Token semicolon) {

        this.leftsquarebrac = leftsquarebrac;
        this.rightsquarebrac = rightsquarebrac;
        this.semicolon = semicolon;

    }

    public B(Token semicolon) {
        this.semicolon = semicolon;
    }
}
