import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth day (DD): ");
        int day = scanner.nextInt();
        System.out.print("Enter your birth month (MM): ");
        int month = scanner.nextInt();
        System.out.print("Enter your birth year (YYYY): ");
        int year = scanner.nextInt();
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        long daysOld = ChronoUnit.DAYS.between(dateOfBirth, today);
        System.out.println("You are " + daysOld + " days old.");
        scanner.close();
    }
}
