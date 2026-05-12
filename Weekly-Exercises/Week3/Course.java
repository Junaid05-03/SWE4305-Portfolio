public class Course {
    private String code;
    private String name;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void print() {
        System.out.println("--- Course Details ---");
        System.out.println("Course Code: " + code);
        System.out.println("Course Name: " + name);
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
