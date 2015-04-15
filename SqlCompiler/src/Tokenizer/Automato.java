

public class Automato {

	public static Token identifyToken(String stringToken) {
		// stringToken = "<>";
		//ArrayList<String> palavra = new ArrayList<>(stringToken.length());
		//String[] palavra = stringToken.split("");
		int state = 0;
		char[] palavra = stringToken.toLowerCase().toCharArray();
		

		//System.out.println("Palavra--:  " + String.valueOf(palavra));
		// " "+palavra.length );
		// automato

		for(char letra : palavra){ 
            switch (state) {
                case 0:
                    switch (letra) {
                        case '(':
                        	if(String.valueOf(palavra).equalsIgnoreCase("(")){
                                return new Token(TokenType.OPEN_PARENTHESIS , String.valueOf(palavra)); // retornar token para )
                            }
                            break;
                        case ')':
                            if(String.valueOf(palavra).equalsIgnoreCase(")")){
                                return new Token(TokenType.CLOSE_PARENTHESIS , String.valueOf(palavra)); // retornar token para (
                            }
                            break;
                        case '*':
                            if(String.valueOf(palavra).equalsIgnoreCase("*")){
                                return new Token(TokenType.STAR , String.valueOf(palavra)); // retornar token para *
                            }
                            break;
                        case ',':
                            if(String.valueOf(palavra).equalsIgnoreCase(",")){
                                return new Token(TokenType.COMMA , String.valueOf(palavra)); // retornar token para ,
                            }
                            break;
                        case ';':
                            if(String.valueOf(palavra).equalsIgnoreCase(";")){
                                return new Token(TokenType.END_STATEMENT , String.valueOf(palavra)); // retornar token para ;
                            }
                            break;
                        case '=':
                            if(String.valueOf(palavra).equalsIgnoreCase("=")){
                                return new Token(TokenType.OPERATOR , String.valueOf(palavra)); // retornar token para =
                            }
                            break;
                        case '<':
                            if(String.valueOf(palavra).equalsIgnoreCase("<")){
                                return new Token(TokenType.OPERATOR , String.valueOf(palavra)); // retornar token para <
                            }
                            state = 8;
                            break;
                        case '>':
                            if(String.valueOf(palavra).equalsIgnoreCase(">")){
                                return new Token(TokenType.OPERATOR, String.valueOf(palavra)); // retornar token para >
                            }
                            state = 9;
                            break;
                        case 'a':
                        	state = 1;
                            break;
                        case 'c':
                            state = 10;
                            break;
                        case 'd':
                            state = 2;
                            break;
                        case 'f':
                            state = 6;
                            break;
                        case 'i':
                            state = 4;
                            break;
                        case 'k':
                            if(String.valueOf(palavra).equalsIgnoreCase("key")){
                                return new Token(TokenType.KEY , String.valueOf(palavra)); // retornar token para key
                            }
                            break;
                        case 'm':
                            if(String.valueOf(palavra).equalsIgnoreCase("modify")){
                                return new Token(TokenType.MODIFY , String.valueOf(palavra)); // retornar token para modify
                            }
                            state = 20;
                            break;
                        case 'n':
                            state = 5;
                            break;
                        case 'p':
                            if(String.valueOf(palavra).equalsIgnoreCase("primary")){
                                return new Token(TokenType.PRIMARY , String.valueOf(palavra)); // retornar token para primary
                            }
                            break;
                        case 's':
                            if(String.valueOf(palavra).equalsIgnoreCase("select")){
                                return new Token(TokenType.SELECT , String.valueOf(palavra)); // retornar token para select
                            }
                            break;
                        case 'r':
                            state = 7;
                            break;
                        case 'u':
                            if(String.valueOf(palavra).equalsIgnoreCase("use")){
                                return new Token(TokenType.USE , String.valueOf(palavra)); // retornar token para use
                            }
                            break;
                        case 't':
                            state = 3;
                            break;
                        case 'w':
                            if(String.valueOf(palavra).equalsIgnoreCase("where")){
                                return new Token(TokenType.WHERE , String.valueOf(palavra)); // retornar token para where
                            }
                            break;
                        case 'v':
                            state = 11;
                            break;
                        default:
                        	//redireciona para o estado para verificar se � um ID
                            state = 20;
                            break;
                    }
                    break;
                case 1:
                    switch (letra) {
                        case 'u':
                        	if(String.valueOf(palavra).equalsIgnoreCase("auto_increment")){
                                return new Token(TokenType.AUTO_INCREMENT , String.valueOf(palavra)); // retornar token para auto_increment
                            }
                            break;
                        case 'd':
                        	if(String.valueOf(palavra).equalsIgnoreCase("add")){
                                return new Token(TokenType.ADD , String.valueOf(palavra)); // retornar token para add
                            }
                            break;
                        case 'l':
                            if(String.valueOf(palavra).equalsIgnoreCase("alter")){
                                return new Token(TokenType.ALTER , String.valueOf(palavra)); // retornar token para alter
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 2:
                    switch (letra) {
                        case 'a':
                            if(String.valueOf(palavra).equalsIgnoreCase("database")){
                                return new Token(TokenType.DATABASE , String.valueOf(palavra)); // retornar token para database
                            }
                            break;
                        case 'r':
                            if(String.valueOf(palavra).equalsIgnoreCase("drop")){
                                return new Token(TokenType.DROP , String.valueOf(palavra)); // retornar token para drop
                            }
                            break;
                        case 'e':
                            if(String.valueOf(palavra).equalsIgnoreCase("delete")){
                                return new Token(TokenType.DELETE , String.valueOf(palavra)); // retornar token para delete
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 3:
                    switch (letra) {
                        case 'a':
                            if(String.valueOf(palavra).equalsIgnoreCase("table")){
                                return new Token(TokenType.TABLE , String.valueOf(palavra)); // retornar token para table
                            }
                            break;
                        case 'r':
                            if(String.valueOf(palavra).equalsIgnoreCase("truncate")){
                                return new Token(TokenType.TRUNCATE , String.valueOf(palavra)); // retornar token para truncate
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 4:
                    switch (letra) {
                        case 'n':
                            state = 12;
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 5:
                    switch (letra) {
                        case 'u':
                            state = 13;
                            break;
                        case 'o':
                            if(String.valueOf(palavra).equalsIgnoreCase("not")){
                                return new Token(TokenType.NOT , String.valueOf(palavra)); // retornar token para not
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 6:
                    switch (letra) {
                        case 'r':
                            if(String.valueOf(palavra).equalsIgnoreCase("from")){
                                return new Token(TokenType.FROM , String.valueOf(palavra)); // retornar token para from
                            }
                            break;
                        case 'o':
                            if(String.valueOf(palavra).equalsIgnoreCase("foreign")){
                                return new Token(TokenType.FOREIGN , String.valueOf(palavra)); // retornar token para foreign
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 7:
                    switch (letra) {
                        case 'e':
                            state = 14;
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 8:
                    switch (letra) {
                        case '=':
                            if(String.valueOf(palavra).equalsIgnoreCase("<=")){
                                return new Token(TokenType.OPERATOR , String.valueOf(palavra)); // retornar token para <=
                            }
                            break;
                        case '>':
                            if(String.valueOf(palavra).equalsIgnoreCase("<>")){
                                return new Token(TokenType.OPERATOR, String.valueOf(palavra)); // retornar token para <>
                            }
                            break;
                        default:
                        	return new Token(TokenType.ERROR, String.valueOf(palavra)); // retornar token para <>
                            //break;
                    }
                    break;
                case 9:
                    switch (letra) {
                        case '=':
                            if(String.valueOf(palavra).equalsIgnoreCase(">=")){
                                return new Token(TokenType.OPERATOR, String.valueOf(palavra)); // retornar token para >=
                            }else
                            	return new Token(TokenType.ERROR, String.valueOf(palavra)); // retornar token para >=
                            //break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 10:
                    switch (letra) {
                        case 'h':
                            if(String.valueOf(palavra).equalsIgnoreCase("char")){
                                return new Token(TokenType.CHAR, String.valueOf(palavra)); // retornar token para char
                            }
                            break;
                        case 'r':
                            if(String.valueOf(palavra).equalsIgnoreCase("create")){
                                return new Token(TokenType.CREATE , String.valueOf(palavra)); // retornar token para create
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 11:
                    switch (letra) {
                        case 'a':
                            state = 15;
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 12:
                    switch (letra) {
                        case 's':
                            if(String.valueOf(palavra).equalsIgnoreCase("insert")){
                                return new Token(TokenType.INSERT , String.valueOf(palavra)); // retornar token para insert
                            }
                            break;
                        case 't':
                            if(String.valueOf(palavra).equalsIgnoreCase("into")){
                                return new Token(TokenType.INTO , String.valueOf(palavra)); // retornar token para into
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 13:
                    switch (letra) {
                        case 'm':
                            if(String.valueOf(palavra).equalsIgnoreCase("numeric")){
                                return new Token(TokenType.NUMERIC , String.valueOf(palavra)); // retornar token para numeric
                            }
                            break;
                        case 'l':
                            if(String.valueOf(palavra).equalsIgnoreCase("null")){
                                return new Token(TokenType.NULL , String.valueOf(palavra)); // retornar token para null
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 14:
                    switch (letra) {
                        case 'f':
                            if(String.valueOf(palavra).equalsIgnoreCase("references")){
                                return new Token(TokenType.REFERENCES , String.valueOf(palavra)); // retornar token para references
                            }
                            break;
                        case 'n':
                            if(String.valueOf(palavra).equalsIgnoreCase("rename")){
                                return new Token(TokenType.RENAME , String.valueOf(palavra)); // retornar token para rename
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 15:
                    switch (letra) {
                        case 'r':
                            if(String.valueOf(palavra).equalsIgnoreCase("varchar")){
                                return new Token(TokenType.VARCHAR , String.valueOf(palavra)); // retornar token para varchar
                            }
                            break;
                        case 'l':
                            if(String.valueOf(palavra).equalsIgnoreCase("values")){
                                return new Token(TokenType.VALUES , String.valueOf(palavra)); // retornar token para values
                            }
                            break;
                        default:
                            // Definir um erro
                            break;
                    }
                    break;
                case 20:
                	
                default:
                	return new Token(TokenType.ERROR,String.valueOf(palavra));
                    //break;
            }//end switch
		}//end for

	return null;
       
	}

}