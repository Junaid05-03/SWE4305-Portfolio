import java.util.Scanner;
import java.util.Calendar;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        int birthYear = currentYear - age;
        System.out.println("You were born in approximately " + birthYear + ".");
        if (age >= 18) {
            System.out.println("You are 18 or older. You are an adult.");
        } else {
            System.out.println("You are under 18. You are not yet an adult.");
        }
        scanner.close();
    }
}
