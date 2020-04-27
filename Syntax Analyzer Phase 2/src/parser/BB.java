package parser;
// BB→  [ ] | ε
public class BB implements Node {
    Token leftsquarebracket;
    Token rightsquarebracket;

    public BB(Token leftsquarebracket, Token rightsquarebracket) {
        this.leftsquarebracket = leftsquarebracket;
        this.rightsquarebracket = rightsquarebracket;
    }

    @Override
    public void printNode() {
        System.out.println(leftsquarebracket.getValue());
        System.out.println(rightsquarebracket.getValue());
    }
}
