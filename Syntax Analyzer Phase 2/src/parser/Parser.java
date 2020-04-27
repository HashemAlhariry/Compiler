package parser;

import java.util.Vector;

public class Parser {
    Vector<Token> tokens;
    int counter;

    public Parser(Vector<Token> tokens) {
        this.tokens = tokens;
        counter = 0;
    }

    public Program parse() {
        return programfun();
    }

    public Program programfun() {
        Decl_list decl_list = decl_list_fun();
        return new Program(decl_list);
    }

    public Decl_list decl_list_fun() {
        Decl decl = decl_fun();
        Decl_list_ decl_list_ = decl_list__fun();
        return new Decl_list(decl, decl_list_);
    }

    public Decl decl_fun() {
        Var_decl var_decl = var_decl_fun();
        if (var_decl == null) {
            Func_decl func_decl = fun_decl_fun();
            return new Decl(func_decl);
        }
        return new Decl(var_decl);
    }

    public Decl_list_ decl_list__fun() {
        if (counter >= tokens.size())
            return null;

        Decl decl = decl_fun();
        Decl_list_ decl_list_ = decl_list__fun();
        if (decl == null && decl_list_ ==null) {

            return new Decl_list_();
        }

        return new Decl_list_(decl,decl_list_);
    }

    private Func_decl fun_decl_fun() {
        //fun_decl → type_spec IDENT ( params ) compound_stmt
        if (counter >= tokens.size())
            return null;
        Type_spec type_spec = type_spec_fun();
        Token ident = tokens.get(counter);
        if (!ident.getName().equals("ID")) {
            System.out.println("syntax error fun_decl_fun");
            return null;
        }
        counter++;
        if (counter >= tokens.size())
            return null;
        Token left_round_b = tokens.get(counter);
        if (!left_round_b.getValue().equals("(")) {
            System.out.println("syntax error fun_decl_fun");
            return null;
        }
        counter++;
        if (counter >= tokens.size())
            return null;
        Params params = params_fun();
        Token right_round_b = tokens.get(counter);
        if (!right_round_b.getValue().equals(")")) {
            System.out.println("syntax error fun_decl_fun");
            return null;
        }
        counter++;
        Compound_stmt compound_stmt = compound_stmt_fun();

        return new Func_decl(type_spec, ident, left_round_b, params, right_round_b, compound_stmt);
    }

    private Type_spec type_spec_fun() {
        if (counter >= tokens.size())
            return null;
        Token type = tokens.get(counter);
        if (!type.getName().equals("VOID") && !type.getName().equals("INT") && !type.getName().equals("FLOAT") && !type.getName().equals("BOOL")) {
            System.out.println("syntax error type_spec_fun");
            return null;
        }

        counter++;

        return new Type_spec(type);
    }

    private Var_decl var_decl_fun() {
        Type_spec type_spec = type_spec_fun();
        if (counter >= tokens.size())
            return null;
        Token ident = tokens.get(counter);
        if (!ident.getName().equals("ID")) {
            System.out.println("syntax error var_decl_fun");
            return null;
        }
        counter++;
        B b = b_fun();

        return new Var_decl(type_spec, ident, b);
    }

    private B b_fun() {
        if (counter >= tokens.size())
            return null;
        Token token = tokens.get(counter);
        if (token.getValue().equals("[")) {
            counter++;
            if (counter >= tokens.size())
                return null;
            Token token1 = tokens.get(counter);
            if (token1.getValue().equals("]")) {
                counter++;
                if (counter >= tokens.size())
                    return null;
                Token token2 = tokens.get(counter);
                if (token2.getValue().equals(";")) {
                    return new B(token, token1, token2);
                } else {
                    System.out.println("syntax error b_fun");
                    return null;
                }
            } else {
                System.out.println("syntax error b_fun");
                return null;
            }
        } else if (token.getName().equals("SEMICOLON")) {
            counter++;
            return new B(token);
        }
        System.out.println("syntax error b_fun " + token.getValue());

        return null;
    }

    private Compound_stmt compound_stmt_fun() {
        if (counter >= tokens.size())
            return null;
        Token left_curly_b = tokens.get(counter);
        if (left_curly_b.getValue().equals("{")) {
            counter++;
            if (counter >= tokens.size())
                return null;
            Local_decls local_decls = local_decls_fun();
            Stmt_list stmt_list = stmt_list_fun();

            Token right_curly_b = tokens.get(counter);
            if (right_curly_b.getValue().equals("}")) {
                counter++;

                return new Compound_stmt(left_curly_b, local_decls, stmt_list, right_curly_b);

            } else {
                System.out.println("syntax error compound_stmt_fun");

            }
        } else {
            System.out.println("Syntax error compound_stmt_fun");
        }
        return null;

    }

    private Params params_fun() {

        Param_list param_list = param_list_fun();
        if (param_list == null) {
            if (counter >= tokens.size())
                return null;
            Token void_ = tokens.get(counter);
            if (void_.getValue().equals("VOID")) {
                counter++;
                return new Params(void_);
            }

        } else {
            return new Params(param_list);
        }
        return null;

    }

    private Local_decls local_decls_fun() {
        Local_decls_ local_decls_ = local_decls__fun();
        return new Local_decls(local_decls_);
    }

    private Stmt_list stmt_list_fun() {
        Stmt_list_ stmt_list_ = stmt_list__fun();
        return new Stmt_list(stmt_list_);
    }

    private Param_list param_list_fun() {
        Param param = param_func();
        Param_list_ param_list_ = param_list__func();
        return new Param_list(param, param_list_);
    }

    private Local_decls_ local_decls__fun() {
        Local_decl local_decl = local_decl_fun();
        if (local_decl == null)
            return null;
        else {
            Local_decls_ local_decls_ = local_decls__fun();
            return new Local_decls_(local_decl, local_decls_);
        }

    }

    private Stmt_list_ stmt_list__fun() {

        Stmt stmt = stmt_fun();
        if (stmt == null)
            return null;
        else {
            Stmt_list_ stmt_list_ = stmt_list__fun();
            return new Stmt_list_(stmt, stmt_list_);
        }
    }

    private Param param_func() {
        Type_spec type_spec = type_spec_fun();
        if (counter >= tokens.size())
            return null;
        Token ident = tokens.get(counter);
        BB bb = bb_fun();
        if (ident.getName().equals("ID")) {
            counter++;
            return new Param(type_spec, ident, bb);

        } else {
            System.out.println("Syntax error 11");
            return null;
        }
    }

    private Param_list_ param_list__func() {
        if (counter >= tokens.size())
            return null;
        Token comma = tokens.get(counter);
        if (comma.getValue().equals(",")) {
            counter++;
            Param param = param_func();
            Param_list_ param_list_ = param_list__func();
            return new Param_list_(comma, param, param_list_);
        }
        return null;
    }

    private Local_decl local_decl_fun() {
        Type_spec type_spec = type_spec_fun();
        if (counter >= tokens.size())
            return null;
        Token ident = tokens.get(counter);
        B b = b_fun();
        if (ident.getName().equals("ID")) {
            return new Local_decl(type_spec, ident, b);
        }
        return null;
    }

    private Stmt stmt_fun() {

        Expr_stmt expr_stmt = expr_stmt_fun();
        if (expr_stmt != null) {
            return new Stmt(expr_stmt);
        }
        Compound_stmt compound_stmt = compound_stmt_fun();
        if (compound_stmt != null) {
            return new Stmt(compound_stmt);
        }
        If_stmt if_stmt = if_stmt_fun();
        if (if_stmt != null) {
            return new Stmt(if_stmt);
        }
        While_stmt while_stmt = while_stmt_fun();
        if (while_stmt != null) {
            return new Stmt(while_stmt);
        }
        Return_stmt return_stmt = return_stmt_fun();
        if (return_stmt != null) {
            return new Stmt(return_stmt);
        }
        if (counter >= tokens.size())
            return null;
        Token break_stmt = tokens.get(counter);
        if (break_stmt.getName().equals("break_stmt")) {
            counter++;
            return new Stmt(break_stmt);
        }
        return null;

    }

    private Return_stmt return_stmt_fun() {
        if (counter >= tokens.size())
            return null;
        Token return_ = tokens.get(counter);
        if (return_.getValue().equals("return")) {
            counter++;
            X x = x_fun();
            return new Return_stmt(return_, x);
        }
        return null;
    }

    private X x_fun() {
        if (counter >= tokens.size())
            return null;
        Token simicolon = tokens.get(counter);
        if (simicolon.getValue().equals(";")) {
            Expr expr = expr_fun();
            if (expr != null) {
                return new X(simicolon, expr);
            }

            return new X(simicolon);
        }

        return null;

    }

    private While_stmt while_stmt_fun() {
        if (counter >= tokens.size())
            return null;
        Token while_ = tokens.get(counter);
        if (while_.getName().equals("WHILE")) {
            counter++;
            if (counter >= tokens.size())
                return null;
            Token left_round_b = tokens.get(counter);
            if (left_round_b.getValue().equals("(")) {
                counter++;
                Expr expr = expr_fun();
                if (counter >= tokens.size())
                    return null;
                Token right_round_b = tokens.get(counter);
                if (left_round_b.getValue().equals(")")) {
                    counter++;
                    Stmt stmt = stmt_fun();
                    return new While_stmt(while_, left_round_b, expr, right_round_b, stmt);
                }
            }
        }

        return null;
    }

    private If_stmt if_stmt_fun() {
        if (counter >= tokens.size())
            return null;
        Token if_ = tokens.get(counter);
        if (if_.getName().equals("IF")) {
            counter++;
            if (counter >= tokens.size())
                return null;
            Token leftroundbracket = tokens.get(counter);
            if (leftroundbracket.getValue().equals("(")) {
                counter++;
                Expr expr = expr_fun();
                if (counter >= tokens.size())
                    return null;
                Token rightroundbracket = tokens.get(counter);
                if (leftroundbracket.getValue().equals(")")) {
                    counter++;
                    Stmt stmt = stmt_fun();
                    BBBB bbbb = bbbb_fun();
                    return new If_stmt(if_, leftroundbracket, expr, rightroundbracket, stmt, bbbb);
                }

            }

        }

        return null;

    }

    private BBBB bbbb_fun() {
        if (counter >= tokens.size())
            return null;
        Token else_ = tokens.get(counter);

        if (else_.getValue().equals("else")) {
            counter++;
            Stmt stmt = stmt_fun();
            return new BBBB(else_, stmt);
        } else
            return null;
    }

    private Expr_stmt expr_stmt_fun() {

        Expr expr = expr_fun();
        if (counter >= tokens.size())
            return null;
        Token semicolon = tokens.get(counter);
        if (semicolon.getValue().equals(";")) {
            if (expr != null) {
                return new Expr_stmt(expr, semicolon);
            }
            return new Expr_stmt(semicolon);
        }
        return null;
    }

    private Expr expr_fun() {
        if (counter >= tokens.size())
            return null;
        Token token = tokens.get(counter);

        if (token.getName().equals("ID")) {
            counter++;
            Z z = z_fun();
            return new Expr(token, z);
        } else if (token.getValue().equals("!") || token.getValue().equals("-") || token.getValue().equals("+")) {
            counter++;
            Expr expr = expr_fun();
            return new Expr(expr, token);
        } else if (token.getName().equals("INTEGRAL_LITERAL") || token.getName().equals("BOOL_LIT") || token.getName().equals("FLOAT_LIT")) {
            counter++;
            return new Expr(token);
        } else if (token.getValue().equals("(")) {
            counter++;
            Expr expr = expr_fun();
            if (counter >= tokens.size())
                return null;
            Token token1 = tokens.get(counter);
            if (token1.getValue().equals(")")) {
                counter++;
                return new Expr(expr, token, token1);
            } else {
                System.out.println("Syntax error no right bracket");
                return null;
            }
        } else if (token.getName().equals("NEW")) {
            counter++;
            Type_spec type_spec = type_spec_fun();
            if (counter >= tokens.size())
                return null;
            Token token1 = tokens.get(counter);
            if (token1.getValue().equals("[")) {
                counter++;
                if (counter >= tokens.size())
                    return null;
                Token token2 = tokens.get(counter);
                Expr expr = expr_fun();
                if (token2.getValue().equals("]")) {
                    counter++;
                    return new Expr(expr, token, type_spec, token1, token2);
                } else {
                    System.out.println("Syntax Error");
                    return null;
                }

            } else {
                System.out.println("Syntax Error");
                return null;
            }

        } else {
            Expr_ expr_ = expr__fun();
        }


        return null;
    }

    private Expr_ expr__fun() {
        T t = t_fun();
        if (t != null) {
            Expr_ expr_ = expr__fun();
            return new Expr_(t, expr_);
        }
        return null;
    }

    private T t_fun() {
        if (counter >= tokens.size())
            return null;
        Token token = tokens.get(counter);
        if (token.getValue().equals("||") || token.getValue().equals("==") || token.getValue().equals("!=") || token.getValue().equals("<=") || token.getValue().equals("<") || token.getValue().equals(">=") || token.getValue().equals(">") || token.getValue().equals("&&") || token.getValue().equals("+") || token.getValue().equals("-") || token.getValue().equals("*") || token.getValue().equals("/") || token.getValue().equals("%")) {
            Expr expr = expr_fun();
            return new T(token, expr);
        }
        System.out.println("syntax error t_fun");
        return null;
    }

    private Z z_fun() {
        if (counter >= tokens.size())
            return null;
        Token token = tokens.get(counter);
        if (token.getValue().equals(".")) {
            counter++;
            if (counter >= tokens.size())
                return null;
            Token size = tokens.get(counter);
            if (size.getValue().equals("size")) {
                counter++;
                return new Z(token, size);
            }
        } else if (token.getValue().equals("=")) {
            Expr expr = expr_fun();
            counter++;
            return new Z(expr, token);
        } else if (token.getValue().equals("[")) {
            Expr expr = expr_fun();
            if (counter >= tokens.size())
                return null;
            Token right_b = tokens.get(counter);
            if (right_b.getValue().equals("]")) {
                counter++;
                if (counter >= tokens.size())
                    return null;
                Token eq = tokens.get(counter);
                if (eq.getValue().equals("=")) {
                    Expr expr1 = expr_fun();
                    return new Z(expr, expr1, token, right_b, eq);
                } else {
                    return new Z(expr, token, right_b);
                }
            } else {
                System.out.println("syntax error z_fun");
                return null;
            }
        } else if (token.getValue().equals("(")) {
            counter++;
            Args args = args_fun();
            if (counter >= tokens.size())
                return null;
            Token t = tokens.get(counter);
            if (t.getValue().equals(")")) {
                return new Z(token, t, args);
            }
        }
        return null;
    }

    private Args args_fun() {
        Arg_list arg_list = args_list_fun();
        if (arg_list != null) {
            return new Args(arg_list);
        }
        return null;
    }

    private Arg_list args_list_fun() {
        Expr expr = expr_fun();
        Arg_list_ arg_list_ = args_list__fun();

        return new Arg_list(expr, arg_list_);
    }

    private Arg_list_ args_list__fun() {
        if (counter >= tokens.size())
            return null;

        Token comma = tokens.get(counter);
        if (comma.getValue().equals(",")) {
            counter++;
            Expr expr = expr_fun();
            Arg_list_ arg_list_ = args_list__fun();
            return new Arg_list_(comma, expr, arg_list_);
        }
        return null;
    }


    private BB bb_fun() {
        if (counter >= tokens.size())
            return null;
        Token leftsquarebracket = tokens.get(counter);
        if (leftsquarebracket.getValue().equals("[")) ;
        {
            counter++;
            if (counter >= tokens.size())
                return null;
            Token rightsquarebracket = tokens.get(counter);
            if (rightsquarebracket.getValue().equals("]")) {
                return new BB(leftsquarebracket, rightsquarebracket);
            }
        }
        return null;
    }


}
