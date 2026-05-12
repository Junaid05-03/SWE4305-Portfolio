import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("BSC-COMP", "BSc(Hons) Computing");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(100167140, "Junaid Qureshi"));
        students.add(new Student(100167141, "Aisha Malik"));
        students.add(new Student(100167142, "Bilal Ahmed"));
        for (Student student : students) {
            student.enrol(course);
            student.generateRandomMarks();
        }
        System.out.println("=== Student Records ===");
        for (Student student : students) {
            student.print();
            System.out.println();
        }
    }
}
