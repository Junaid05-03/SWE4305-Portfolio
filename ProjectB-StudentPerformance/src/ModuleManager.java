// ModuleManager.java
// Manages the collection of modules using a HashMap for fast lookup
// Mirrors the StudentManager design for consistency

import java.util.HashMap;
import java.util.ArrayList;

public class ModuleManager {
    private HashMap<String, Module> modules;

    public ModuleManager() {
        modules = new HashMap<>();
        loadDefaultModules();
    }

    private void loadDefaultModules() {
        modules.put("SWE4305", new Module("SWE4305", "Object Oriented Programming", 20));
        modules.put("SWE4301", new Module("SWE4301", "Web Development Fundamentals", 20));
        modules.put("SWE4302", new Module("SWE4302", "Database Systems", 20));
        modules.put("SWE4303", new Module("SWE4303", "Computer Systems and Architecture", 20));
    }

    public boolean addModule(String code, String name, int credits) {
        if (modules.containsKey(code)) {
            System.out.println("  Error: Module code " + code + " already exists.");
            return false;
        }
        if (name == null || name.trim().isEmpty()) {
            System.out.println("  Error: Module name cannot be empty.");
            return false;
        }
        if (credits <= 0) {
            System.out.println("  Error: Credits must be greater than zero.");
            return false;
        }
        modules.put(code, new Module(code, name, credits));
        return true;
    }

    public boolean editModule(String code, String newName, int newCredits) {
        if (!modules.containsKey(code)) {
            System.out.println("  Error: Module code " + code + " not found.");
            return false;
        }
        Module module = modules.get(code);
        if (newName != null && !newName.trim().isEmpty()) {
            module.setName(newName);
        }
        if (newCredits > 0) {
            module.setCredits(newCredits);
        }
        return true;
    }

    public boolean deleteModule(String code) {
        if (!modules.containsKey(code)) {
            System.out.println("  Error: Module code " + code + " not found.");
            return false;
        }
        modules.remove(code);
        return true;
    }

    public Module getModule(String code) {
        return modules.get(code);
    }

    public boolean moduleExists(String code) {
        return modules.containsKey(code);
    }

    public ArrayList<Module> getAllModules() {
        return new ArrayList<>(modules.values());
    }

    public int getCount() {
        return modules.size();
    }
}
