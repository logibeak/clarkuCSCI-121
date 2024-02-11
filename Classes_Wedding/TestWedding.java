import java.time.LocalDate;
import java.util.Scanner;
public class TestWedding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter in the first name of the Bride:");
        String bName = sc.next();
        System.out.println("Please enter in the last name of the Bride:");
        String bLName = sc.next();
        Person bride = new Person(bName, bLName);

        System.out.println("Please enter in the first name of the Groom:");
        String gName = sc.next();
        System.out.println("Please enter in the last name of the Groom:");
        String gLName = sc.next();
        Person groom = new Person(gName, gLName);

        Couple couple = new Couple(bride, groom);

        System.out.println("Please enter in the date of the wedding (YEAR-day-Month):");
        LocalDate date = LocalDate.parse(sc.next());

        System.out.println("Please enter in the location of the wedding:");
        String location = "";

        sc.nextLine(); // Fixes weird bug where the nextLine initially skips
        location+=sc.nextLine();

        sc.close();

        Wedding wedding = new Wedding(couple, date, location);

        System.out.println("Couple: " + wedding.getCouple());
        System.out.println("Date: " + wedding.getDate());
        System.out.println("Location: " + wedding.getLocation());
    }
}
