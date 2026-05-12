// Module.java
// Represents a university module
// Demonstrates encapsulation with private fields and public getters/setters

public class Module {
    private String code;
    private String name;
    private int credits;

    public Module(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { this.credits = credits; }

    public void print() {
        System.out.println("  Code:    " + code);
        System.out.println("  Name:    " + name);
        System.out.println("  Credits: " + credits);
    }

    @Override
    public String toString() {
        return code + " | " + name + " | " + credits + " credits";
    }
}
