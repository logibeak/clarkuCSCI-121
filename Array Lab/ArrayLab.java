import java.util.ArrayList;
import java.util.Scanner;
public class ArrayLab {
    static ArrayList<Double> entries = new ArrayList<>(20);
    static Scanner sc = new Scanner(System.in);
    static double hold = 0.0;
    static int count = 1;
    public static void parseEntry(){
        System.out.println("Please enter value " + count + ": (Enter 99999 to quit)");
        try {hold=Double.parseDouble(sc.next());}
        catch (Exception e) {
            System.out.println("Invalid entry, please try again.");
            parseEntry(); // Recursion! :)
        }
    }

    public static void main(String[] args){
        //Gather input
        while (entries.size() < 20){ // Max size 20
            parseEntry();
            if (hold == (double) 99999) {
                break;
            } // if 99999 entered skip to output
            entries.add(hold);
            count++;
        }

        //Display output
        for (int i = 1; i <= 20; i++){
            if (entries.isEmpty()){System.out.println("No values entered");}
            try {
                System.out.println("Number " + i + ": " + entries.get(i - 1));
                //Indexes start at 0, but the loop/output starts at 1.^^^^^^
            } catch (IndexOutOfBoundsException e) {
                //IndexOutOfBoundsException means the end
                //of the ArrayList has been reached
                break; // exit loop
            }
        }
    }
}