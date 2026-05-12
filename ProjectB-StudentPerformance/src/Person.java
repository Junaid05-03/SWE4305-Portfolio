// Person.java
// Abstract base class demonstrating inheritance
// Student extends this class, inheriting id and name
// This demonstrates the OOP principle of inheritance

public abstract class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Abstract method - must be implemented by subclasses
    // This demonstrates polymorphism through method overriding
    public abstract void print();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}
