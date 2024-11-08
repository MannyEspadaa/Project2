import java.util.HashMap;
import java.util.Map;

public class ExecManagement {
    private Department[] departments;
    private Map<String, Executive> executivesMap;
    private int departmentCount;

    public ExecManagement(int maxDepartments) {
        departments = new Department[maxDepartments];
        executivesMap = new HashMap<>();
        departmentCount = 0;
        departments[departmentCount++] = new Department("Unemployed");
    }

    public void addDepartment(String name) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = new Department(name);
            System.out.println("Department " + name + " created.");
        } else {
            System.out.println("Max department limit reached.");
        }
    }

    public void hireExecutive(String name) {
        Executive executive = new Executive(name);
        executivesMap.put(name, executive);
        departments[0].addExecutive(executive); 
        System.out.println("Executive " + name + " hired.");
    }

    public void joinExecutive(String name, String departmentName) {
        Executive executive = executivesMap.get(name);
        Department department = findDepartment(departmentName);

        if (executive != null && department != null) {
            departments[0].removeExecutive(executive); 
            department.addExecutive(executive);
            System.out.println(name + " joined " + departmentName + ".");
        } else {
            System.out.println("Error: Executive or Department not found.");
        }
    }

    public void quitExecutive(String name) {
        Executive executive = executivesMap.get(name);
        if (executive != null && executive.getDepartment() != null) {
            executive.getDepartment().removeExecutive(executive);
            departments[0].addExecutive(executive); 
            System.out.println(name + " has quit their department.");
        } else {
            System.out.println("Error: Executive not found or is already unemployed.");
        }
    }

    public void changeDepartment(String name, String newDepartmentName) {
        Executive executive = executivesMap.get(name);
        Department newDepartment = findDepartment(newDepartmentName);

        if (executive != null && newDepartment != null) {
            executive.getDepartment().removeExecutive(executive);
            newDepartment.addExecutive(executive);
            System.out.println(name + " has been moved to " + newDepartmentName + ".");
        } else {
            System.out.println("Error: Executive or new Department not found.");
        }
    }

    public void payroll() {
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department.getPayroll());
            }
        }
    }

    public void salary(String name) {
        Executive executive = executivesMap.get(name);
        if (executive != null) {
            System.out.println(name + "'s salary: $" + executive.calculateSalary());
        } else {
            System.out.println("Error: Executive not found.");
        }
    }

    private Department findDepartment(String name) {
        for (Department department : departments) {
            if (department != null && department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }

}