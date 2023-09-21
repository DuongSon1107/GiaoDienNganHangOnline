package controller;

public class BankException extends Exception{
    public String errMessage;
    public BankException(String errMessage){
        super();
        this.errMessage = errMessage;
    }
}
