import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your letter grade (A, B, C, D, E or F): ");
        String input = scanner.nextLine().trim().toUpperCase();
        switch (input) {
            case "A": System.out.println("Grade A = First Class (1st)"); break;
            case "B": System.out.println("Grade B = Upper Second Class (2:1)"); break;
            case "C": System.out.println("Grade C = Lower Second Class (2:2)"); break;
            case "D": System.out.println("Grade D = Third Class (3rd)"); break;
            case "E": System.out.println("Grade E = Ordinary Degree"); break;
            case "F": System.out.println("Grade F = Fail"); break;
            default:  System.out.println("Invalid grade entered."); break;
        }
        scanner.close();
    }
}
