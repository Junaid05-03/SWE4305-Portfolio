public class Module {
    private String name;
    private String code;

    public Module(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Grade convertToGrade(int mark) {
        if (mark >= 70) return Grade.A;
        else if (mark >= 60) return Grade.B;
        else if (mark >= 50) return Grade.C;
        else if (mark >= 40) return Grade.D;
        else return Grade.F;
    }

    public void print() {
        System.out.println("  Module: " + code + " - " + name);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
}
