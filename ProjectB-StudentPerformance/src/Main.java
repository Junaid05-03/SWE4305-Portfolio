import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static StudentManager studentManager = new StudentManager();
    static ModuleManager moduleManager = new ModuleManager();
    static MarkManager markManager = new MarkManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcome();
        int choice = 0;
        do {
            printMainMenu();
            choice = getIntInput();
            switch (choice) {
                case 1: studentMenu(); break;
                case 2: moduleMenu(); break;
                case 3: marksMenu(); break;
                case 4: reportsMenu(); break;
                case 5:
                    System.out.println("\n  Thank you for using the Student Performance System. Goodbye!");
                    break;
                default:
                    System.out.println("  Invalid choice. Please enter 1 to 5.");
            }
        } while (choice != 5);
        scanner.close();
    }

    static void printWelcome() {
        System.out.println("\n  +==================================================+");
        System.out.println("  |       STUDENT PERFORMANCE SYSTEM                 |");
        System.out.println("  |       University of Bolton - BSc Computing       |");
        System.out.println("  |       SWE4305 - Junaid Qureshi                   |");
        System.out.println("  +==================================================+");
    }

    static void printMainMenu() {
        System.out.println("\n  +----------------------------------------+");
        System.out.println("  |              MAIN MENU                 |");
        System.out.println("  +----------------------------------------+");
        System.out.println("  |  1. Manage Students                    |");
        System.out.println("  |  2. Manage Modules                     |");
        System.out.println("  |  3. Enter / Update Marks               |");
        System.out.println("  |  4. View Reports                       |");
        System.out.println("  |  5. Exit                               |");
        System.out.println("  +----------------------------------------+");
        System.out.print("  Enter your choice: ");
    }

    static String centre(String text, int width) {
        if (text.length() >= width) return text;
        int padding = (width - text.length()) / 2;
        int extra = (width - text.length()) % 2;
        return " ".repeat(padding) + text + " ".repeat(padding + extra);
    }

    static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void studentMenu() {
        int choice = 0;
        do {
            System.out.println("\n  +----------------------------------------+");
            System.out.println("  |         STUDENT MANAGEMENT             |");
            System.out.println("  +----------------------------------------+");
            System.out.println("  |  1. Add Student                        |");
            System.out.println("  |  2. Edit Student                       |");
            System.out.println("  |  3. Delete Student                     |");
            System.out.println("  |  4. View All Students                  |");
            System.out.println("  |  5. Back to Main Menu                  |");
            System.out.println("  +----------------------------------------+");
            System.out.print("  Enter your choice: ");
            choice = getIntInput();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: editStudent(); break;
                case 3: deleteStudent(); break;
                case 4: viewAllStudents(); break;
                case 5: break;
                default: System.out.println("  Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.println("\n  --- Add New Student ---");
        System.out.print("  Enter student ID: ");
        int id = getIntInput();
        System.out.print("  Enter student name: ");
        String name = scanner.nextLine().trim();
        System.out.print("  Enter student email: ");
        String email = scanner.nextLine().trim();
        if (studentManager.addStudent(id, name, email)) {
            System.out.println("  [OK] Student added successfully: " + name);
        }
    }

    static void editStudent() {
        System.out.println("\n  --- Edit Student ---");
        System.out.print("  Enter student ID to edit: ");
        int id = getIntInput();
        if (!studentManager.studentExists(id)) {
            System.out.println("  Error: Student not found.");
            return;
        }
        Student student = studentManager.getStudent(id);
        System.out.println("  Current name: " + student.getName());
        System.out.print("  Enter new name (or press Enter to keep): ");
        String newName = scanner.nextLine().trim();
        System.out.println("  Current email: " + student.getEmail());
        System.out.print("  Enter new email (or press Enter to keep): ");
        String newEmail = scanner.nextLine().trim();
        if (studentManager.editStudent(id,
                newName.isEmpty() ? null : newName,
                newEmail.isEmpty() ? null : newEmail)) {
            System.out.println("  [OK] Student updated successfully.");
        }
    }

    static void deleteStudent() {
        System.out.println("\n  --- Delete Student ---");
        System.out.print("  Enter student ID to delete: ");
        int id = getIntInput();
        if (studentManager.deleteStudent(id)) {
            System.out.println("  [OK] Student deleted successfully.");
        }
    }

    static void viewAllStudents() {
        ArrayList<Student> students = studentManager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("  No students found.");
            return;
        }
        System.out.println("\n  +----------------------------------------------------------------------+");
        System.out.printf("  | %-12s %-25s %-30s |%n", "ID", "Name", "Email");
        System.out.println("  +----------------------------------------------------------------------+");
        for (Student s : students) {
            System.out.printf("  | %-12d %-25s %-30s |%n",
                    s.getId(), s.getName(), s.getEmail());
        }
        System.out.println("  +----------------------------------------------------------------------+");
        System.out.println("  Total students: " + students.size());
    }

    static void moduleMenu() {
        int choice = 0;
        do {
            System.out.println("\n  +----------------------------------------+");
            System.out.println("  |          MODULE MANAGEMENT             |");
            System.out.println("  +----------------------------------------+");
            System.out.println("  |  1. Add Module                         |");
            System.out.println("  |  2. Edit Module                        |");
            System.out.println("  |  3. Delete Module                      |");
            System.out.println("  |  4. View All Modules                   |");
            System.out.println("  |  5. Back to Main Menu                  |");
            System.out.println("  +----------------------------------------+");
            System.out.print("  Enter your choice: ");
            choice = getIntInput();
            switch (choice) {
                case 1: addModule(); break;
                case 2: editModule(); break;
                case 3: deleteModule(); break;
                case 4: viewAllModules(); break;
                case 5: break;
                default: System.out.println("  Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addModule() {
        System.out.println("\n  --- Add New Module ---");
        System.out.print("  Enter module code: ");
        String code = scanner.nextLine().trim().toUpperCase();
        System.out.print("  Enter module name: ");
        String name = scanner.nextLine().trim();
        System.out.print("  Enter credits: ");
        int credits = getIntInput();
        if (moduleManager.addModule(code, name, credits)) {
            System.out.println("  [OK] Module added successfully: " + name);
        }
    }

    static void editModule() {
        System.out.println("\n  --- Edit Module ---");
        System.out.print("  Enter module code to edit: ");
        String code = scanner.nextLine().trim().toUpperCase();
        if (!moduleManager.moduleExists(code)) {
            System.out.println("  Error: Module not found.");
            return;
        }
        Module module = moduleManager.getModule(code);
        System.out.println("  Current name: " + module.getName());
        System.out.print("  Enter new name (or press Enter to keep): ");
        String newName = scanner.nextLine().trim();
        System.out.println("  Current credits: " + module.getCredits());
        System.out.print("  Enter new credits (or 0 to keep): ");
        int newCredits = getIntInput();
        if (moduleManager.editModule(code,
                newName.isEmpty() ? null : newName, newCredits)) {
            System.out.println("  [OK] Module updated successfully.");
        }
    }

    static void deleteModule() {
        System.out.println("\n  --- Delete Module ---");
        System.out.print("  Enter module code to delete: ");
        String code = scanner.nextLine().trim().toUpperCase();
        if (moduleManager.deleteModule(code)) {
            System.out.println("  [OK] Module deleted successfully.");
        }
    }

    static void viewAllModules() {
        ArrayList<Module> modules = moduleManager.getAllModules();
        if (modules.isEmpty()) {
            System.out.println("  No modules found.");
            return;
        }
        System.out.println("\n  +------------------------------------------------------------+");
        System.out.printf("  | %-10s %-38s %-8s |%n", "Code", "Name", "Credits");
        System.out.println("  +------------------------------------------------------------+");
        for (Module m : modules) {
            System.out.printf("  | %-10s %-38s %-8d |%n",
                    m.getCode(), m.getName(), m.getCredits());
        }
        System.out.println("  +------------------------------------------------------------+");
    }

    static void marksMenu() {
        int choice = 0;
        do {
            System.out.println("\n  +----------------------------------------+");
            System.out.println("  |          MARKS MANAGEMENT              |");
            System.out.println("  +----------------------------------------+");
            System.out.println("  |  1. Enter / Update Mark                |");
            System.out.println("  |  2. View Marks for Student             |");
            System.out.println("  |  3. View Marks for Module              |");
            System.out.println("  |  4. Back to Main Menu                  |");
            System.out.println("  +----------------------------------------+");
            System.out.print("  Enter your choice: ");
            choice = getIntInput();
            switch (choice) {
                case 1: enterMark(); break;
                case 2: viewMarksForStudent(); break;
                case 3: viewMarksForModule(); break;
                case 4: break;
                default: System.out.println("  Invalid choice.");
            }
        } while (choice != 4);
    }

    static void enterMark() {
        System.out.println("\n  --- Enter / Update Mark ---");
        System.out.print("  Enter student ID: ");
        int studentId = getIntInput();
        System.out.print("  Enter module code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        System.out.print("  Enter mark (0-100): ");
        int value = getIntInput();
        if (markManager.addMark(studentId, moduleCode, value,
                studentManager, moduleManager)) {
            System.out.println("  [OK] Mark recorded successfully.");
        }
    }

    static void viewMarksForStudent() {
        System.out.print("  Enter student ID: ");
        int studentId = getIntInput();
        if (!studentManager.studentExists(studentId)) {
            System.out.println("  Error: Student not found.");
            return;
        }
        ArrayList<Mark> studentMarks = markManager.getMarksForStudent(studentId);
        Student student = studentManager.getStudent(studentId);
        System.out.println("\n  Results for: " + student.getName());
        System.out.println("  +-------------------------------------------------------+");
        System.out.printf("  | %-12s %-25s %-6s %-8s |%n",
                "Module", "Name", "Mark", "Grade");
        System.out.println("  +-------------------------------------------------------+");
        if (studentMarks.isEmpty()) {
            System.out.println("  |  No marks recorded for this student.               |");
        } else {
            for (Mark mark : studentMarks) {
                Module module = moduleManager.getModule(mark.getModuleCode());
                String moduleName = module != null ? module.getName() : "Unknown";
                System.out.printf("  | %-12s %-25s %-6d %-8s |%n",
                        mark.getModuleCode(), moduleName,
                        mark.getValue(), mark.getGrade().name());
            }
        }
        System.out.println("  +-------------------------------------------------------+");
    }

    static void viewMarksForModule() {
        System.out.print("  Enter module code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        if (!moduleManager.moduleExists(moduleCode)) {
            System.out.println("  Error: Module not found.");
            return;
        }
        ArrayList<Mark> moduleMarks = markManager.getMarksForModule(moduleCode);
        Module module = moduleManager.getModule(moduleCode);
        System.out.println("\n  Results for: " + module.getName());
        System.out.println("  +----------------------------------------------------+");
        System.out.printf("  | %-12s %-25s %-6s %-4s |%n",
                "Student ID", "Name", "Mark", "Grade");
        System.out.println("  +----------------------------------------------------+");
        if (moduleMarks.isEmpty()) {
            System.out.println("  |  No marks recorded for this module.            |");
        } else {
            for (Mark mark : moduleMarks) {
                Student student = studentManager.getStudent(mark.getStudentId());
                String studentName = student != null ? student.getName() : "Unknown";
                System.out.printf("  | %-12d %-25s %-6d %-4s |%n",
                        mark.getStudentId(), studentName,
                        mark.getValue(), mark.getGrade().name());
            }
        }
        System.out.println("  +----------------------------------------------------+");
    }

    static void reportsMenu() {
        int choice = 0;
        do {
            System.out.println("\n  +----------------------------------------+");
            System.out.println("  |              REPORTS                   |");
            System.out.println("  +----------------------------------------+");
            System.out.println("  |  1. Module Statistics                  |");
            System.out.println("  |  2. Grade Distribution                 |");
            System.out.println("  |  3. Full Student Report                |");
            System.out.println("  |  4. Back to Main Menu                  |");
            System.out.println("  +----------------------------------------+");
            System.out.print("  Enter your choice: ");
            choice = getIntInput();
            switch (choice) {
                case 1: moduleStatistics(); break;
                case 2: gradeDistribution(); break;
                case 3: fullStudentReport(); break;
                case 4: break;
                default: System.out.println("  Invalid choice.");
            }
        } while (choice != 4);
    }

    static void moduleStatistics() {
        System.out.print("  Enter module code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        if (!moduleManager.moduleExists(moduleCode)) {
            System.out.println("  Error: Module not found.");
            return;
        }
        ArrayList<Mark> moduleMarks = markManager.getMarksForModule(moduleCode);
        if (moduleMarks.isEmpty()) {
            System.out.println("  No marks recorded for this module.");
            return;
        }
        Module module = moduleManager.getModule(moduleCode);
        double mean = markManager.getMeanMark(moduleCode);
        int min = markManager.getMinMark(moduleCode);
        int max = markManager.getMaxMark(moduleCode);
        System.out.println("\n  +------------------------------------------+");
        System.out.println("  |          MODULE STATISTICS               |");
        System.out.println("  +------------------------------------------+");
        System.out.printf("  |  Module:   %-30s |%n", module.getName());
        System.out.printf("  |  Students: %-30d |%n", moduleMarks.size());
        System.out.printf("  |  Mean:     %-30.2f |%n", mean);
        System.out.printf("  |  Minimum:  %-30d |%n", min);
        System.out.printf("  |  Maximum:  %-30d |%n", max);
        System.out.println("  +------------------------------------------+");
    }

    static void gradeDistribution() {
        System.out.print("  Enter module code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        if (!moduleManager.moduleExists(moduleCode)) {
            System.out.println("  Error: Module not found.");
            return;
        }
        ArrayList<Mark> moduleMarks = markManager.getMarksForModule(moduleCode);
        if (moduleMarks.isEmpty()) {
            System.out.println("  No marks recorded for this module.");
            return;
        }
        HashMap<Grade, Double> distribution =
                markManager.getGradeDistribution(moduleCode);
        Module module = moduleManager.getModule(moduleCode);
        System.out.println("\n  +----------------------------------------------------+");
        System.out.println("  |              GRADE DISTRIBUTION                    |");
        System.out.printf("  |  %-48s |%n", module.getName());
        System.out.println("  +----------------------------------------------------+");
        System.out.printf("  | %-6s %-28s %-12s |%n",
                "Grade", "Classification", "Percentage");
        System.out.println("  +----------------------------------------------------+");
        for (Grade g : Grade.values()) {
            System.out.printf("  | %-6s %-28s %10.1f%% |%n",
                    g.name(), g.getClassification(), distribution.get(g));
        }
        System.out.println("  +----------------------------------------------------+");
    }

    static void fullStudentReport() {
        ArrayList<Student> students = studentManager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("  No students found.");
            return;
        }
        System.out.println("\n  +============================================================+");
        System.out.println("  |                FULL STUDENT REPORT                        |");
        System.out.println("  +============================================================+");
        for (Student student : students) {
            System.out.println("\n  Student: " + student.getName() +
                    " (ID: " + student.getId() + ")");
            System.out.println("  +-------------------------------------------------------+");
            System.out.printf("  | %-12s %-25s %-6s %-8s |%n",
                    "Module", "Name", "Mark", "Grade");
            System.out.println("  +-------------------------------------------------------+");
            ArrayList<Mark> studentMarks =
                    markManager.getMarksForStudent(student.getId());
            if (studentMarks.isEmpty()) {
                System.out.println("  |  No marks recorded.                                 |");
            } else {
                for (Mark mark : studentMarks) {
                    Module module = moduleManager.getModule(mark.getModuleCode());
                    String moduleName = module != null ? module.getName() : "Unknown";
                    System.out.printf("  | %-12s %-25s %-6d %-8s |%n",
                            mark.getModuleCode(), moduleName,
                            mark.getValue(), mark.getGrade().name());
                }
            }
            System.out.println("  +-------------------------------------------------------+");
        }
    }
}