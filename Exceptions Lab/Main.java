import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static double num = 0.0;
    public static void handleInput(){
        System.out.println("Please enter a number you wish to square root:");
        try {
            num = Double.parseDouble(sc.next());
        } catch (NumberFormatException e) { // checks for invalid number input
            System.out.println("Error: invalid input. Please enter a number");
            handleInput();
        }
    }
    public static void main(String[] args) {
        handleInput();
        double squareRoot = Math.sqrt(num);
        while (Double.isNaN(squareRoot)){ // if the number is negative,
            /////////////////////////////// run until the user enters a non-negative number
            System.out.println("Error: invalid input. Please enter a number");
            handleInput();
            squareRoot = Math.sqrt(num);
        }
        System.out.println("Result of square root of "+num+" is "+squareRoot);
    }
}