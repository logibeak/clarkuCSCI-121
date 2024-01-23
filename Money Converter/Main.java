import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("\n\nHow much money would you like to convert into coins?\n" +
                "Please enter the amount as follows: (ex: $5.31)\n" +
                "$");
        Scanner sc = new Scanner(System.in);
        try {
            double money = sc.nextDouble();
            int fxMoney = (int) (money * 100); // This is done to avoid floating point precision errors
            int quarters = fxMoney / 25; // Amount of quarters
            int dimes = (fxMoney - quarters * 25) / 10; // Amount of dimes
            int nickels = (fxMoney - quarters * 25 - dimes * 10) / 5; // Amount of nickels
            int pennies = (fxMoney - quarters * 25 - dimes * 10 - nickels * 5); // Amount of pennies
            System.out.println(quarters + " Quarters, " + dimes + " Dimes, " + // Output result
                    nickels + " Nickels, and " + pennies + " Pennies.");
        } catch(Exception e) {
            System.out.println(0 + " Quarters, " + 0 + " Dimes, " + // Output result if input is invalid
                    0 + " Nickels, and " + 0 + " Pennies.");
        }
    }
}