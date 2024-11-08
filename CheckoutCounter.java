import java.util.LinkedList;
import java.util.Queue;

public abstract class CheckoutCounter {
    private final Queue<Customer> customers;
    private int totalCustomers;
    private int totalWaitTime;

    public CheckoutCounter() {
        customers = new LinkedList<>();
        totalCustomers = 0;
        totalWaitTime = 0;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        totalCustomers++;
        totalWaitTime += customer.getNumItems(); 
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public double getAverageWaitTime() {
        return totalCustomers == 0 ? 0 : (double) totalWaitTime / totalCustomers;
    }

    public int getMaxLength() {
        return customers.size();
    }
}