package Syntaxer;

import java.util.*;

import Tokenizer.*;
import GrammaticalElement.*;
import Action.*;
import Synthesized.*;

class SetPrimaryKey implements ActionInterface{
    public void act(Stack<GrammaticalInterface> stack, Map<String, String> attrs){
    System.out.println("############## Action #################");
    System.out.println("Primary key, analogo ao this");
    stack.get(stack.size() - 1).setAttr("this.", "id");
    System.out.println("############################################");
    }
}

class PassData2Up implements ActionInterface {
    public void act(Stack<GrammaticalInterface> stack, Map<String, String> attrs){
        stack.get(stack.size() - 2).setAttr("package", attrs.get("data"));
    }
}

class SynthesizedElements {
    public static Synthesized UDatabaseUse = new Synthesized(new PassData2Up());
}

class ActionElements {
    public static Action PrimaryKey =  new Action(new SetPrimaryKey());
}

public enum Production {
    StartCommandPrime(Grammatic.CommandPrime),
    CommandPrimeEps(),
    CommandPrimeCommand(Grammatic.Command, Grammatic.CommandPrime),
    CommandCreate(Grammatic.Create),
    CommandUse(Grammatic.UDatabase),
    CommandAlter(Grammatic.ATable),
    CommandDrop(Grammatic.DTable),
    CommandTruncate(Grammatic.DTable),
    CommandInsert(Grammatic.CmdInsert),
    CommandDelete(Grammatic.CmdDelete),
    CommandSelect(Grammatic.CmdSelect),    
    CreateCreate(TokenType.CREATE, Grammatic.CreatePrime),
    UDatabaseUse(TokenType.USE, TokenType.id, SynthesizedElements.UDatabaseUse, TokenType.END_STATEMENT),
    ATableAlter(TokenType.ALTER, TokenType.TABLE, TokenType.id, Grammatic.Stmt),
    DTableDrop(TokenType.DROP, TokenType.TABLE, TokenType.id, TokenType.END_STATEMENT),
    DTableTruncate(TokenType.TRUNCATE, TokenType.TABLE, TokenType.id, TokenType.END_STATEMENT),
    CmdInsertInsert(TokenType.INSERT, TokenType.INTO, TokenType.id, TokenType.OPEN_PARENTHESIS, Grammatic.Columns, TokenType.CLOSE_PARENTHESIS, TokenType.VALUES, TokenType.OPEN_PARENTHESIS, Grammatic.ColumnValue, TokenType.CLOSE_PARENTHESIS, TokenType.END_STATEMENT),
    CmdDeleteDelete(TokenType.DELETE, TokenType.FROM, TokenType.id, Grammatic.CmdWhere, TokenType.END_STATEMENT),
    CmdSelectSelect(TokenType.SELECT, Grammatic.Columns, TokenType.FROM, Grammatic.Tables, Grammatic.CmdWhere, TokenType.END_STATEMENT),
    CreatePrimeDatabase(Grammatic.CDatabase),
    CreatePrimeTable(Grammatic.CTable),
    CreatePrimeId(Grammatic.CTable),
    CDatabaseDatabase(TokenType.DATABASE, TokenType.id, TokenType.END_STATEMENT),
    CTableTable(TokenType.TABLE, TokenType.id, Grammatic.ConteudoTabela),
    ConteudoTabelaOPEN_PARENTHESIS(TokenType.OPEN_PARENTHESIS, Grammatic.Elemento, TokenType.CLOSE_PARENTHESIS),
    ElementoId(Grammatic.Coluna, Grammatic.ElementoPrime),
    ColunaId(TokenType.id, Grammatic.DataType, Grammatic.Condition),
    ElementoPrimeCLOSE_PARENTHESIS(),
    ElementoPrimeComma(TokenType.COMMA, Grammatic.Elemento),
    DataTypeInt(TokenType.integer),
    DataTypeNumeric(TokenType.NUMERIC, TokenType.OPEN_PARENTHESIS, TokenType.integer, TokenType.CLOSE_PARENTHESIS),
    DataTypeChar(TokenType.CHAR, TokenType.OPEN_PARENTHESIS, TokenType.integer, TokenType.CLOSE_PARENTHESIS),
    DataTypeVarchar(TokenType.VARCHAR, TokenType.OPEN_PARENTHESIS, TokenType.integer, TokenType.CLOSE_PARENTHESIS),
    DataTypeDate(TokenType.date),
    ConditionCLOSE_PARENTHESIS(),
    ConditionComma(),
    ConditionNot(TokenType.NOT, TokenType.NULL, Grammatic.Condition),
    ConditionPrimary(TokenType.PRIMARY, TokenType.KEY, ActionElements.PrimaryKey, Grammatic.Condition),
    ConditionAuto_increment(TokenType.AUTO_INCREMENT, Grammatic.Condition),
    ConditionForeign(TokenType.FOREIGN, TokenType.KEY, TokenType.OPEN_PARENTHESIS, TokenType.id, TokenType.CLOSE_PARENTHESIS, TokenType.REFERENCES, TokenType.id, TokenType.OPEN_PARENTHESIS, TokenType.id, TokenType.CLOSE_PARENTHESIS, Grammatic.Condition),    
    StmtAdd(TokenType.ADD, Grammatic.ConteudoTabela),
    StmtDrop(TokenType.DROP, Grammatic.ConteudoTabela),
    StmtRename(TokenType.RENAME, Grammatic.ConteudoTabela),
    StmtModify(TokenType.MODIFY, Grammatic.ConteudoTabela),
    ColumnsId(Grammatic.ColumnsPrime),
    ColumnsSTAR(TokenType.STAR),
    ColumnValueQUOTE(TokenType.QUOTE, TokenType.id, TokenType.QUOTE, Grammatic.ColumnValuePrime),
    ColumnValueNumber(TokenType.number, Grammatic.ColumnValuePrimePrime),
    ColumnValueInteger(TokenType.integer, Grammatic.ColumnValuePrimePrime),
    ColumnsPrimeId(TokenType.id, Grammatic.ColumnsPrimePrime),
    ColumnsPrimePrimeCLOSE_PARENTHESIS(),
    ColumnsPrimePrimeComma(TokenType.COMMA, Grammatic.ColumnsPrime),
    ColumnsPrimePrimeFROM(),
    ColumnValuePrimeCLOSE_PARENTHESIS(),
    ColumnValuePrimeComma(TokenType.COMMA, Grammatic.ColumnValue),
    ColumnValuePrimePrimeCLOSE_PARENTHESIS(),
    ColumnValuePrimePrimeComma(TokenType.COMMA, Grammatic.ColumnValue),
    CmdWhereEND_STATEMENT(),
    CmdWhereWhere(TokenType.WHERE, Grammatic.Whereclausule),
    WhereclausuleId(TokenType.id, Grammatic.Operator, TokenType.id, Grammatic.WhereclausulePrime),
    Operator(TokenType.OPERATOR),
    WhereclausulePrimeEND_STATEMENT(),
    WhereclausulePrime(Grammatic.Logical, Grammatic.Whereclausule),
    Logical(TokenType.LOGICAL),
    TablesId(TokenType.id, Grammatic.TablesPrime),
    TablesPrimeEND_STATEMENT(),
    TablesPrimeComma(TokenType.COMMA, Grammatic.Tables),
    TablesPrimeWhere();
    
    GrammaticalInterface[] productions;

    private Production(GrammaticalInterface... productions) {
        this.productions = productions;
    }
}
