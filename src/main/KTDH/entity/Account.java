package KTDH.entity;

public class Account {
    private String AccountId;
    private String FullName;
    private double Balance;

    public Account() {}

    public Account(String AccountId, String FullName, double Balance) {
        this.AccountId = AccountId;
        this.FullName = FullName;
        this.Balance = Balance;
    }

    public void setName(String name){
        this.FullName = name;
    }

    public String getAccountId() {
        return this.AccountId;
    }

    public void setBalance(double balance){
        this.Balance = balance;
    }

    public String getName(){
        return this.FullName;
    }

    public double getBalance(){
        return this.Balance;
    }

    public void setAccountId(String Accountid){
        this.AccountId = Accountid;
    }

    public String ToString() {
        return "id: " + AccountId + " name: " + FullName + " balance: " + Balance;
    }
}
