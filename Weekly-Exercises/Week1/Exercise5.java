import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int number2 = scanner.nextInt();
        System.out.println("Original order: " + number1 + ", " + number2);
        int temp = number1;
        number1 = number2;
        number2 = temp;
        System.out.println("Reversed order: " + number1 + ", " + number2);
        scanner.close();
    }
}
