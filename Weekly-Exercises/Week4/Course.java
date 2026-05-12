import java.util.ArrayList;

public class Course {
    private String code;
    private String name;
    private ArrayList<Module> modules;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        modules = new ArrayList<>();
        modules.add(new Module("SWE4305", "Object Oriented Programming"));
        modules.add(new Module("SWE4301", "Web Development Fundamentals"));
        modules.add(new Module("SWE4302", "Database Systems"));
        modules.add(new Module("SWE4303", "Computer Systems and Architecture"));
    }

    public void print() {
        System.out.println("--- Course Details ---");
        System.out.println("Course Code: " + code);
        System.out.println("Course Name: " + name);
        System.out.println("Modules:");
        for (Module module : modules) {
            module.print();
        }
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public ArrayList<Module> getModules() { return modules; }
}
