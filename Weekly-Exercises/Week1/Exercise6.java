import java.util.Scanner;
import java.util.Calendar;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        int birthYear = currentYear - age;
        System.out.println("You were born in approximately " + birthYear + ".");
        scanner.close();
    }
}
