package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.excepitions.DomainExcepition;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("***ENTER ACCOUNT DATA***");

        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Holder: ");
        sc.next();
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);
        try {
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.println(account.getNumber() + ", New balance: " + String.format("%.2f", account.getBalance()));
        } catch (DomainExcepition e) {
            System.out.println("Withdraw erro: " + e.getMessage());
        }
        sc.close();

    }

}
