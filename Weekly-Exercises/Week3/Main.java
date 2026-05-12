public class Main {
    public static void main(String[] args) {
        Student student = new Student(100167140, "Junaid Qureshi");
        System.out.println("=== Before Enrolment ===");
        student.print();
        Course course = new Course("BSC-COMP", "BSc(Hons) Computing");
        System.out.println("\n=== Enrolling Student ===");
        student.enrol(course);
        System.out.println("\n=== After Enrolment ===");
        student.print();
    }
}
