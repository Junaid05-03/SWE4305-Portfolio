import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your exam mark (0-100): ");
        int mark = scanner.nextInt();
        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
        } else if (mark >= 70) {
            System.out.println("Mark: " + mark + " | Grade: A | First Class");
        } else if (mark >= 60) {
            System.out.println("Mark: " + mark + " | Grade: B | Upper Second Class (2:1)");
        } else if (mark >= 50) {
            System.out.println("Mark: " + mark + " | Grade: C | Lower Second Class (2:2)");
        } else if (mark >= 40) {
            System.out.println("Mark: " + mark + " | Grade: D | Third Class");
        } else {
            System.out.println("Mark: " + mark + " | Grade: F | Fail");
        }
        scanner.close();
    }
}
