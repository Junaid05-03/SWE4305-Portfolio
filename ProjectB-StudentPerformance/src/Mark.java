// Mark.java
// Represents a mark awarded to a student for a specific module
// Links a student ID and module code to a numerical mark
// Separation of marks from students and modules improves design flexibility

public class Mark {
    private int studentId;
    private String moduleCode;
    private int value;

    public Mark(int studentId, String moduleCode, int value) {
        this.studentId = studentId;
        this.moduleCode = moduleCode;
        this.value = value;
    }

    public int getStudentId() { return studentId; }
    public String getModuleCode() { return moduleCode; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public Grade getGrade() {
        return Grade.fromMark(value);
    }

    @Override
    public String toString() {
        return "Student: " + studentId + " | Module: " + moduleCode + " | Mark: " + value + " | Grade: " + getGrade().name();
    }
}
