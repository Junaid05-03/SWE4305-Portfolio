import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();
        double average = (number1 + number2) / 2;
        System.out.println("The average of " + number1 + " and " + number2 + " is: " + average);
        scanner.close();
    }
}
