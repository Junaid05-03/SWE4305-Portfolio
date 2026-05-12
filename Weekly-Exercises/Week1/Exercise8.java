import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int FEET_PER_MILE = 5280;
        System.out.print("Enter the number of feet: ");
        double feet = scanner.nextDouble();
        double miles = feet / FEET_PER_MILE;
        System.out.println(feet + " feet is equal to " + miles + " miles.");
        scanner.close();
    }
}
