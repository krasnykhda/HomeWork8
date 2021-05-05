package model;
public class Account{
    private Client client;
    private String accountNumber;
    public Account(Client client,String accountNumber ){
        this.client=client;
        this.accountNumber=accountNumber;
    }
    public Client getClient(){
        return this.client;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }

}