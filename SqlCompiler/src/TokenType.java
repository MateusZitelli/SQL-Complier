/*Nome: TokenType.java
 *Descrição: ENUM que definem as expressões regulares que serão reconhecidas. 
 *Autores: João Flávio e...
 * 
 */

public enum TokenType {
    dataType(/*implementar*/),
    alphabet("^([a-zA-Z])$"),
    id("^([a-zA-Z]*)$"),//Aqui não seria alphabetalphabet*?
    date("{^(((\\d{4})(-)(0[13578]|10|12)(-)(0[1-9]|[12][0-9]|3[01]))|((\\d{4})(-)(0[469]|11)(-)([0][1-9]|[12][0-9]|30))|((\\d{4})(-)(02)(-)(0[1-9]|1[0-9]|2[0-8]))|(([02468][048]00)(-)(02)(-)(29))|(([13579][26]00)(-)(02)(-)(29))|(([0-9][0-9][0][48])(-)(02)(-)(29))|(([0-9][0-9][2468][048])(-)(02)(-)(29))|(([0-9][0-9][13579][26])(-)(02)(-)(29)))(\\s([0-1][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9]))?$}"),
    number("^(-?[0-9]+(?:[0-9]+)?)$"), 
    operator("^(=|<>|>|<|<=|>=)$"),
    logical("^(AND|OR)$"),
    blanckspace("^(\\s*)$");
    public String pattern;
    private TokenType (String pattern) {
    	this.pattern = pattern;
    }
}
