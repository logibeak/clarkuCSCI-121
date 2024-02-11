import java.util.Scanner;
public class UseParty {
    public static void main(String[] args) {
        Party p = new Party();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of guests for the party:");
        p.setGuests(sc.nextShort());
        System.out.println("The party has " +p.getGuests() + " Guests");
        p.displayInvitation();
    }
}