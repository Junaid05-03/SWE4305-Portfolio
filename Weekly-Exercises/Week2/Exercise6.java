import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;
        do {
            System.out.print("Enter a number to see its times table: ");
            int tableNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n--- " + tableNumber + " Times Table ---");
            for (int i = 1; i <= 12; i++) {
                System.out.println(i + " x " + tableNumber + " = " + (i * tableNumber));
            }
            System.out.print("\nWould you like to see another times table? (yes/no): ");
            continueChoice = scanner.nextLine().trim().toLowerCase();
        } while (continueChoice.equals("yes"));
        System.out.println("Thank you for using the times table program. Goodbye!");
        scanner.close();
    }
}
