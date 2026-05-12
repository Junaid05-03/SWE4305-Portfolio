import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double INTEREST_RATE = 0.01;
        System.out.print("Enter your deposit amount: ");
        double deposit = scanner.nextDouble();
        double interest = deposit * INTEREST_RATE;
        double totalBalance = deposit + interest;
        System.out.println("Deposit amount:       " + deposit);
        System.out.println("Interest earned:      " + interest);
        System.out.println("Balance after 1 year: " + totalBalance);
        scanner.close();
    }
}
