import java.util.Random;

public class Student {
    private int id;
    private String name;
    private Course course;
    private int[] marks;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        marks = new int[4];
    }

    public void enrol(Course course) {
        this.course = course;
    }

    public void generateRandomMarks() {
        Random random = new Random();
        for (int i = 0; i < marks.length; i++) {
            marks[i] = random.nextInt(101);
        }
    }

    public void print() {
        System.out.println("--- Student Details ---");
        System.out.println("Student ID:   " + id);
        System.out.println("Student Name: " + name);
        if (course != null) {
            System.out.println("Course: " + course.getName());
            System.out.println("Module Results:");
            for (int i = 0; i < course.getModules().size(); i++) {
                Module module = course.getModules().get(i);
                int mark = marks[i];
                Grade grade = module.convertToGrade(mark);
                System.out.println("  " + module.getCode() + " - " + module.getName() + " | Mark: " + mark + " | Grade: " + grade);
            }
        } else {
            System.out.println("Not enrolled on any course.");
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int[] getMarks() { return marks; }
}
