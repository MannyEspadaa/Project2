import java.util.LinkedList;
import java.util.Queue;

class Department {
    private String name;
    private Queue<Executive> executives;

    public Department(String name) {
        this.name = name;
        this.executives = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addExecutive(Executive executive) {
        executives.add(executive);
        executive.setDepartment(this);
    }

    public void removeExecutive(Executive executive) {
        executives.remove(executive);
        executive.setDepartment(null);
    }

    public Queue<Executive> getExecutives() {
        return executives;
    }

    public int getLessSeniorExecutivesCount(Executive executive) {
        int count = 0;
        for (Executive e : executives) {
            if (e.getSeniority() < executive.getSeniority()) {
                count++;
            }
        }
        return count;
    }

    public String getPayroll() {
        StringBuilder payroll = new StringBuilder("Payroll for " + name + ":\n");
        executives.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSeniority(), e1.getSeniority())) 
                .forEach(e -> payroll.append(e.getName()).append(": $").append(e.calculateSalary()).append("\n"));
        return payroll.toString();
    }

    @Override
    public String toString() {
        return "Department Name: " + name;
    }
}