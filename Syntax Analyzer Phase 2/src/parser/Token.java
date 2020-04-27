package parser;

public class Token {

    String name;
    String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Token(String name, String value) {
        this.name = name;
        this.value = value;
    }

}
