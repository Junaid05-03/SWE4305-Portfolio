// Student.java
// Extends Person class demonstrating inheritance
// Contains a list of modules the student is enrolled on
// Demonstrates encapsulation with private fields and getters/setters

import java.util.ArrayList;

public class Student extends Person {
    private String email;
    private ArrayList<String> enrolledModuleCodes;

    public Student(int id, String name, String email) {
        super(id, name);
        this.email = email;
        this.enrolledModuleCodes = new ArrayList<>();
    }

    public void enrollModule(String moduleCode) {
        if (!enrolledModuleCodes.contains(moduleCode)) {
            enrolledModuleCodes.add(moduleCode);
        }
    }

    public boolean isEnrolledIn(String moduleCode) {
        return enrolledModuleCodes.contains(moduleCode);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public ArrayList<String> getEnrolledModuleCodes() { return enrolledModuleCodes; }

    // Override print method from Person - demonstrates polymorphism
    @Override
    public void print() {
        System.out.println("  ID:    " + id);
        System.out.println("  Name:  " + name);
        System.out.println("  Email: " + email);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + email;
    }
}
