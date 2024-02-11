import java.util.Scanner;
public class UseDinnerParty extends UseParty{
    public static void main(String[] args) {
        DinnerParty dp = new DinnerParty();
        Scanner sc = new Scanner(System.in);
        //party
        System.out.println("Enter the number of guests for the party:");
        dp.setGuests(sc.nextShort());
        System.out.println("The party has " +dp.getGuests() + " Guests");
        dp.displayInvitation();

        //dinner party
        System.out.println("Set the number of guests for the Dinner Party:");
        dp.setGuests(sc.nextShort());
        System.out.println("Enter the menu option: 1 for Chicken 2 for Veggies");
        dp.setDinnerChoice(sc.nextInt());
        System.out.println("The dinner party has " +dp.getGuests() + " guests");
        System.out.println("Menu option " + dp.getDinnerChoice() + " will be served");
        dp.displayInvitation();
    }
}
