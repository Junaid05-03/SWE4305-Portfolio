public class Exercise9 {
    public static void main(String[] args) {
        final int FEET_PER_MILE = 5280;
        System.out.println("Feet to Miles Conversion Table");
        System.out.println("------------------------------");
        System.out.printf("%-15s %-15s%n", "Feet", "Miles");
        System.out.println("------------------------------");
        for (int feet = FEET_PER_MILE; feet <= FEET_PER_MILE * 10; feet += FEET_PER_MILE) {
            double miles = (double) feet / FEET_PER_MILE;
            System.out.printf("%-15d %-15.1f%n", feet, miles);
        }
    }
}
