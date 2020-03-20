package Lexical_Analyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        File file = new File("file.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st="";
        Vector<String>programChar =new Vector<>();
        while ((st = br.readLine()) != null)
        {
            programChar.add(st);
        }

       String TOKENS[]={"<SINGLE_COMMENT>","<FLOAT>","<DOUBLE>","<INT>","<SHORT>","<CHAR>","<WHILE>","<ASSIGN_OPERATOR>","<FLOAT_LITERAL>",
               "<INTEGRAL_LITERAL>","<STRING_LITERAL>","<CHAR_LITERAL>","<SEMICOLON>"
               ,"<COMMA>","<AUTO>","<NEW>","<EOF>","<TRUE>", "<FALSE>"
        ,"<BREAK>","<BOOL>","<CASE>","<CONST>","<CONTINUE>","<DEFAULT>","<DO>","<ELSE>","<ENUM>","<EXTERN>","<FOR>","<GOTO>"
        ,"<IF>","<REGISTER>","<RETURN>","<SIGNED>","<SIZEOF>","<STATIC>","<STRUCT>","<SWITCH>","<TYPEDEF>","<UNION>","<UNSIGNED>",
               "<VOID>","<VOLATILE>","<LEFT_CURLY_B>","<RIGHT_CURLY_B>","<LEFT_SQUARE_B>","<RIGHT_SQUARE_B>","<LEFT_ROUND_B>"
        ,"<RIGHT_ROUND_B>","<DOT>","<NOT>","<PREPROCESSOR>","<BACKWARD_SLASH>","<MINUS>","<PLUS>","<ASTERICK>","<DIVIDE>","<MOD>"
        ,"<LESSTHAN>","<GREATERTHAN>","<LESS_EQ>","<GREAT_EQ>","<EQUAL>","<NOT_EQUAL>","<AND>","<OR>","<BITWISE_AND>","<BITWISE_OR>"
               ,"<BITWISE_XOR>","<LEFT_SHIFT>","<RIGHT_SHIFT>","<BITWISE_NOT>","<ID>"};  // here we take from it same index as arrExpress to put in the object to write it on file later
       String arrExpression[]={"\\/\\/(\\s*\\w)+","\\bfloat\\b","\\bdouble\\b","\\bint\\b","\\bshort\\b","\\bchar\\b","\\bwhile\\b"
               ,"=", "[+-]?([0-9]*[.])?[0-9]+","[0-9]+","\\\"(\\w*\\s*)*\\\"","\\'[a-zA-z]\\'"
               ,";",",","\\bauto\\b","\\bnew\\b","\\b0\\b","\\btrue\\b","\\bfalse\\b"
       ,"\\bbreak\\b","\\bbool\\b","\\bcase\\b","\\bconst\\b","\\bcontinue\\b",
               "\\bdefault\\b","\\bdo\\b","\\belse\\b","\\benum\\b"
       ,"\\bextern\\b","\\bfor\\b","\\bgoto\\b","\\bif\\b","\\bregister\\b","\\breturn\\b","\\bsigned\\b","\\bsizeof\\b",
               "\\bstatic\\b","\\bstruct\\b","\\bswitch\\b","\\btypedef\\b","\\bunion\\b",
               "\\bunsigned\\b","\\bvoid\\b","\\bvolatile\\b","}","\\{","]","\\[","\\)","\\(","\\.","!","#","\\\\","-","\\+","\\*"
               ,"\\/","%","<",">","<=",">=","==","!=","&&","\\|\\|","&","\\|","\\^","\\>>","\\<<","\\~","\\b[a-zA-z]\\w*\\b"};

       Vector<Token>allTokens=new Vector<>();

       Vector<Token>stringToken=new Vector<>();

       boolean firstMult=false;  //this boolean to check the first of multiple line comment
       boolean secondMult=false;  //this boolean to check the end of multiple line comment
       boolean last=false;
       String multiComment="";

        for(int i =0;i<programChar.size();i++)    /***program is a vector of string each string containing one line from the program ***/
        {
            String firstlineexpr="\\/\\*(\\s*\\w*)*";
            String lastlineexpr="(\\s*\\w*)*\\*\\/";
            String multicommentexpr="\\/\\*(\\s*\\w*)*\\*\\/";

            Pattern patt;
            Matcher mat;
            String line=programChar.get(i);
            Pattern pattern1 = Pattern.compile(multicommentexpr);
            Matcher matcher1 = pattern1.matcher(line);
            while (matcher1.find())
            {
                Token token = new Token("<MULTICOMMENT>",matcher1.group(),matcher1.start());
                stringToken.add(token);
                String before=line.substring(0,matcher1.start());
                String after=line.substring(matcher1.end());
                String space="";
                for(int ind=0;ind<matcher1.end()-matcher1.start();ind++)  //to add space same length as the matched ,to avoid changing index in line
                {
                    space+=" ";
                }
                line=before+space+after;
            }

            if(!firstMult) {
                patt = Pattern.compile(firstlineexpr);
                mat = patt.matcher(line);
                if(mat.find())
                {
                    firstMult=true;
                    multiComment+=line.substring(mat.start(),mat.end());
                    String before=line.substring(0,mat.start());
                    String after=line.substring(mat.end());
                    String space="";
                    for(int ind=0;ind<mat.end()-mat.start();ind++)  //to add space same length as the matched ,to avoid changing index in line
                    {
                        space+=" ";
                    }
                    //System.out.println(line);
                    line=before+space+after;
                }
            }
            else if(firstMult)
            {
                patt = Pattern.compile(lastlineexpr);
                mat = patt.matcher(line);
                if(mat.find())
                {
                    multiComment+=line.substring(mat.start(),mat.end());
                    last=true;
                    String before=line.substring(0,mat.start());
                    String after=line.substring(mat.end());
                    String space="";
                    for(int ind=0;ind<mat.end()-mat.start();ind++)  //to add space same length as the matched ,to avoid changing index in line
                    {
                        space+=" ";
                    }
                    line=before+space+after;

                }
                else if(!mat.find()){
                    multiComment+=line;
                    continue;
                }

            }
            if(last)
            {
                Token token = new Token("<MULTI_COMMENT>",multiComment,0);
                allTokens.add(token);
                last=false;
                firstMult=false;
            }

           for (int j = 0; j < arrExpression.length; j++)
           {
               Pattern pattern = Pattern.compile(arrExpression[j]);
               Matcher matcher = pattern.matcher(line);
               System.out.println(arrExpression[j]);
               while (matcher.find())
               {

                   System.out.println(matcher.group());

                   Token token = new Token(TOKENS[j],matcher.group(),matcher.start());
                   stringToken.add(token);

                   String before=line.substring(0,matcher.start());
                   String after=line.substring(matcher.end());
                   String space="";
                   for(int ind=0;ind<matcher.end()-matcher.start();ind++)  //to add space same length as the matched ,to avoid changing index in line
                   {
                       space+=" ";
                   }
                   //System.out.println(line);
                   line=before+space+after;
                   matcher=pattern.matcher(line);

               }
           }
           for(int ind =0;ind<stringToken.size()-1;ind++)
           {
               for (int j=ind+1;j<stringToken.size();j++)
               {
                   if(stringToken.get(ind).number >stringToken.get(j).number)
                   {
                       Token temp =stringToken.get(ind);
                       stringToken.set(ind,stringToken.get(j));
                       stringToken.set(j,temp);
                   }

               }
           }
           for (int ind=0;ind<stringToken.size();ind++ )
           {
                allTokens.add(stringToken.get(ind));
           }
           for(int j =0;j<stringToken.size();j++)
           {
             //System.out.print(stringToken.get(j).name+" ");
             //System.out.print(stringToken.get(j).value+" ");
             //System.out.println(stringToken.get(j).number+" ");
           }
           stringToken.clear();

       }
        for(int j =0;j<allTokens.size();j++)
        {
            System.out.print(allTokens.get(j).name+" ");
            System.out.println(allTokens.get(j).value+" ");
        }
    }
}
