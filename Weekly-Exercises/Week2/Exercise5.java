import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to see its times table: ");
        int tableNumber = scanner.nextInt();
        System.out.println("\n--- " + tableNumber + " Times Table ---");
        for (int i = 1; i <= 12; i++) {
            int result = i * tableNumber;
            System.out.println(i + " x " + tableNumber + " = " + result);
        }
        scanner.close();
    }
}
