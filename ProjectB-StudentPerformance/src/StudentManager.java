// StudentManager.java
// Manages the collection of students using a HashMap for fast lookup
// HashMap allows O(1) retrieval by student ID
// This is more efficient than iterating an ArrayList for every lookup

import java.util.HashMap;
import java.util.ArrayList;

public class StudentManager {
    // HashMap key is student ID for fast lookup - higher marks criteria
    private HashMap<Integer, Student> students;

    public StudentManager() {
        students = new HashMap<>();
    }

    public boolean addStudent(int id, String name, String email) {
        if (students.containsKey(id)) {
            System.out.println("  Error: Student ID " + id + " already exists.");
            return false;
        }
        if (name == null || name.trim().isEmpty()) {
            System.out.println("  Error: Student name cannot be empty.");
            return false;
        }
        if (email == null || email.trim().isEmpty()) {
            System.out.println("  Error: Email cannot be empty.");
            return false;
        }
        students.put(id, new Student(id, name, email));
        return true;
    }

    public boolean editStudent(int id, String newName, String newEmail) {
        if (!students.containsKey(id)) {
            System.out.println("  Error: Student ID " + id + " not found.");
            return false;
        }
        Student student = students.get(id);
        if (newName != null && !newName.trim().isEmpty()) {
            student.setName(newName);
        }
        if (newEmail != null && !newEmail.trim().isEmpty()) {
            student.setEmail(newEmail);
        }
        return true;
    }

    public boolean deleteStudent(int id) {
        if (!students.containsKey(id)) {
            System.out.println("  Error: Student ID " + id + " not found.");
            return false;
        }
        students.remove(id);
        return true;
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public boolean studentExists(int id) {
        return students.containsKey(id);
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public int getCount() {
        return students.size();
    }
}
