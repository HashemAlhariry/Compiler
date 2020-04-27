package synatx_analyzer;
import parser.Arg_list_;
import parser.Parser;
import parser.Token;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class main {
    static Vector<Token>allTokens =new Vector<Token>();
    static Vector<String> programChar ;
    public static void main(String[] args)throws IOException {


        File file = new File("test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st="";
        programChar=new Vector<>();
        while ((st = br.readLine()) != null)
        {
            programChar.add(st);
        }
        getTokens();
        for(int i=0;i<allTokens.size();i++)
        {
       //System.out.println(allTokens.get(i).getName()+" "+allTokens.get(i).getValue());
        }


         Parser parser = new Parser(allTokens);
         parser.programfun().printNode();






    }
   static void getTokens()
    {
        for(int i=0;i<programChar.size();i++)
        {
         String firstWord =programChar.get(i).substring(programChar.get(i).indexOf('<') + 1, programChar.get(i).indexOf('>'));
         String secondWord=programChar.get(i).substring(programChar.get(i).indexOf(':') + 1);
         Token obj = new Token(firstWord,secondWord);
         allTokens.add(obj);
        }
        
    }
}
