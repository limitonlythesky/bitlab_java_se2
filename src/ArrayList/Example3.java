package ArrayList;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.*;

public class Example3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankApplication bank1 = new BankApplication("Kaspi");
        BankApplication bank2 = new BankApplication("Halyk");
        BankApplication bank3 = new BankApplication("RBK");
        for(int i = 0; i < 10; i++){
            bank1.addAccount(new Account(i + 101, "Name", "Surname", (i + 2) * 1000));
        }
        for(int i = 0; i < 10; i++){
            bank2.addAccount(new Account(i + 201, "Name", "Surname", (i + 3) * 1000));
        }
        for(int i = 0; i < 10; i++){
            bank3.addAccount(new Account(i + 301, "Name", "Surname", (i + 4) * 1000));
        }

        ArrayList <BankApplication> allBanks = new ArrayList<BankApplication>();

        allBanks.add(bank1);
        allBanks.add(bank2);
        allBanks.add(bank3);

        allBanks.sort(Comparator.comparingDouble(BankApplication::getAverageBalance));
        Collections.reverse(allBanks);

        for(BankApplication bank: allBanks){
            System.out.println(bank.getBankData());
        }
    }
}
