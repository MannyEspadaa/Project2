import java.util.LinkedList;

class Executive {
    private String name;
    private int seniority; 
    private Department department;

    public Executive(String name) {
        this.name = name;
        this.seniority = 0; 
        this.department = null; 
    }

    public String getName() {
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    public void incrementSeniority() {
        seniority++;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double calculateSalary() {
        if (department == null) {
            return 0; 
        }
        return 40000 + (5000 * department.getLessSeniorExecutivesCount(this));
    }

    @Override
    public String toString() {
        return "Executive Name: " + name + ", Seniority: " + seniority + ", Department: " + (department != null ? department.getName() : "Unemployed");
    }
}