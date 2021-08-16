package ArrayList;

import Task2.Student;

import java.util.ArrayList;

public class BankApplication implements Comparable<BankApplication>{
    private String name;
    private ArrayList <Account> accounts = new ArrayList <Account>();

    public BankApplication(String name) {
        this.name = name;
    }

    public BankApplication(String name, ArrayList<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public void removeAccount(int ind){
        accounts.remove(ind);
    }

    public Account getMaxAccount(){
        double mx = 0;
        Account account = null;
        for(Account a: accounts){
            if(a.getBalance() > mx){
                mx = a.getBalance();
                account = a;
            }
        }
        return account;
    }

    public double getAverageBalance(){
        double sum = 0;
        for(int i = 0; i < accounts.size(); i++){
            sum += accounts.get(i).getBalance();
        }
        return sum / accounts.size();
    }

    public double getTotalBalance(){
        double sum = 0;
        for(Account a: accounts){
            sum += a.getBalance();
        }
        return sum;
    }

    public int totalAccounts(){
        return accounts.size();
    }

    public String getBankData() {
        return "BankApplication{" +
                "name='" + name + '\'' +
                "accounts amount='" + accounts.size() + '\'' +
                "total balance='" + getTotalBalance() + '\'' +
                "average balance='" + getAverageBalance() + '\'' +
                '}';
    }

    @Override
    public int compareTo(BankApplication o) {
        return name.compareTo(o.name);
    }
}
