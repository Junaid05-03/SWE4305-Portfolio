// MarkManager.java
// Manages marks and calculates statistics per module
// Includes mean, min, max and grade distribution (percentage per grade)

import java.util.ArrayList;
import java.util.HashMap;

public class MarkManager {
    private ArrayList<Mark> marks;

    public MarkManager() {
        marks = new ArrayList<>();
    }

    public boolean addMark(int studentId, String moduleCode, int value,
                           StudentManager studentManager, ModuleManager moduleManager) {
        if (!studentManager.studentExists(studentId)) {
            System.out.println("  Error: Student ID " + studentId + " not found.");
            return false;
        }
        if (!moduleManager.moduleExists(moduleCode)) {
            System.out.println("  Error: Module code " + moduleCode + " not found.");
            return false;
        }
        if (value < 0 || value > 100) {
            System.out.println("  Error: Mark must be between 0 and 100.");
            return false;
        }
        for (Mark mark : marks) {
            if (mark.getStudentId() == studentId && mark.getModuleCode().equals(moduleCode)) {
                mark.setValue(value);
                System.out.println("  Mark updated successfully.");
                return true;
            }
        }
        marks.add(new Mark(studentId, moduleCode, value));
        studentManager.getStudent(studentId).enrollModule(moduleCode);
        return true;
    }

    public ArrayList<Mark> getMarksForModule(String moduleCode) {
        ArrayList<Mark> result = new ArrayList<>();
        for (Mark mark : marks) {
            if (mark.getModuleCode().equals(moduleCode)) {
                result.add(mark);
            }
        }
        return result;
    }

    public ArrayList<Mark> getMarksForStudent(int studentId) {
        ArrayList<Mark> result = new ArrayList<>();
        for (Mark mark : marks) {
            if (mark.getStudentId() == studentId) {
                result.add(mark);
            }
        }
        return result;
    }

    public double getMeanMark(String moduleCode) {
        ArrayList<Mark> moduleMarks = getMarksForModule(moduleCode);
        if (moduleMarks.isEmpty()) return 0;
        int total = 0;
        for (Mark mark : moduleMarks) {
            total += mark.getValue();
        }
        return (double) total / moduleMarks.size();
    }

    public int getMinMark(String moduleCode) {
        ArrayList<Mark> moduleMarks = getMarksForModule(moduleCode);
        if (moduleMarks.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (Mark mark : moduleMarks) {
            if (mark.getValue() < min) min = mark.getValue();
        }
        return min;
    }

    public int getMaxMark(String moduleCode) {
        ArrayList<Mark> moduleMarks = getMarksForModule(moduleCode);
        if (moduleMarks.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        for (Mark mark : moduleMarks) {
            if (mark.getValue() > max) max = mark.getValue();
        }
        return max;
    }

    public HashMap<Grade, Double> getGradeDistribution(String moduleCode) {
        ArrayList<Mark> moduleMarks = getMarksForModule(moduleCode);
        HashMap<Grade, Integer> gradeCounts = new HashMap<>();
        for (Grade g : Grade.values()) {
            gradeCounts.put(g, 0);
        }
        for (Mark mark : moduleMarks) {
            Grade grade = mark.getGrade();
            gradeCounts.put(grade, gradeCounts.get(grade) + 1);
        }
        HashMap<Grade, Double> distribution = new HashMap<>();
        int total = moduleMarks.size();
        for (Grade g : Grade.values()) {
            double percentage = total > 0 ? (gradeCounts.get(g) * 100.0) / total : 0;
            distribution.put(g, percentage);
        }
        return distribution;
    }

    public ArrayList<Mark> getAllMarks() { return marks; }
}
