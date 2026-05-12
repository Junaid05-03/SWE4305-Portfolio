// Grade.java
// Enum representing university grade classifications
// Using an enum ensures only valid grade values can be assigned
// This is more type-safe than using plain Strings or integers

public enum Grade {
    A("First Class", 70, 100),
    B("Upper Second Class (2:1)", 60, 69),
    C("Lower Second Class (2:2)", 50, 59),
    D("Third Class", 40, 49),
    F("Fail", 0, 39);

    private final String classification;
    private final int minMark;
    private final int maxMark;

    Grade(String classification, int minMark, int maxMark) {
        this.classification = classification;
        this.minMark = minMark;
        this.maxMark = maxMark;
    }

    public String getClassification() { return classification; }
    public int getMinMark() { return minMark; }
    public int getMaxMark() { return maxMark; }

    public static Grade fromMark(int mark) {
        if (mark >= 70) return A;
        else if (mark >= 60) return B;
        else if (mark >= 50) return C;
        else if (mark >= 40) return D;
        else return F;
    }

    public String toString() {
        return name() + " - " + classification;
    }
}
