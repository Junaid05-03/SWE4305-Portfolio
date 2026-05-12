public class Student {
    private int id;
    private String name;
    private Course course;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void enrol(Course course) {
        this.course = course;
        System.out.println(name + " has been enrolled on: " + course.getName());
    }

    public void print() {
        System.out.println("--- Student Details ---");
        System.out.println("Student ID:   " + id);
        System.out.println("Student Name: " + name);
        if (course != null) {
            course.print();
        } else {
            System.out.println("Not enrolled on any course.");
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Course getCourse() { return course; }
}
