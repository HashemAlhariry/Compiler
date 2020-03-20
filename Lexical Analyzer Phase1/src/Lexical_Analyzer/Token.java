package Lexical_Analyzer;

public class Token
{
    String name="<ID>";
    String value;
    int number;

    public Token(String value, int number) {
        this.value = value;
        this.number = number;
    }

    public Token(String name, String value, int number) {
        this.name = name;
        this.value = value;
        this.number = number;
    }


}
