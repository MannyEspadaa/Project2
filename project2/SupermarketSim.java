import java.util.Random;

public class SupermarketSim {
    public static void sim(int numSuper, int numExp, int numStandLines, double arrivalRate, int maxItems, int maxSimTime) {
        SuperExpressCounter superCounter = new SuperExpressCounter();
        ExpressCounter[] expressCounters = new ExpressCounter[2];
        
        for (int i = 0; i < expressCounters.length; i++) {
            expressCounters[i] = new ExpressCounter();
        }
        StandardCounter[] standardCounters = new StandardCounter[numStandLines];
        for (int i = 0; i < standardCounters.length; i++) {
            standardCounters[i] = new StandardCounter();
        }
        int totalTime = 0;
        Random random = new Random();
        while (totalTime < maxSimTime) {
            int arrivalTime = totalTime;
            int numItems = random.nextInt(maxItems) + 1; 
            Customer customer = new Customer(arrivalTime, numItems);
            if (numItems <= numSuper) {
                superCounter.addCustomer(customer);
            } else if (numItems <= numExp) {
                ExpressCounter expressCounter = expressCounters[0].getMaxLength() <= expressCounters[1].getMaxLength() ? expressCounters[0] : expressCounters[1];
                expressCounter.addCustomer(customer);
            } else {
                StandardCounter standardCounter = standardCounters[0];
                for (StandardCounter counter : standardCounters) {
                    if (counter.getMaxLength() < standardCounter.getMaxLength()) {
                        standardCounter = counter;
                    }
                }
                standardCounter.addCustomer(customer);
            }

            totalTime++;
        }
        System.out.println("Super Express Counter:");
        System.out.printf("Amount of Customers: %d\n", superCounter.getTotalCustomers());
        System.out.printf("Average Wait Time: %.2f seconds\n", superCounter.getAverageWaitTime());
        System.out.printf("Max Length of Queue: %d\n", superCounter.getMaxLength());
        System.out.println("Express Counters:");
        for (int i = 0 ; i < expressCounters.length; i++) {
            System.out.printf("Counter %d - Amount of Customers: %d\n", i + 1, expressCounters[i].getTotalCustomers());
            System.out.printf("Counter %d - Average Wait Time: %.2f seconds\n", i + 1, expressCounters[i].getAverageWaitTime());
            System.out.printf("Counter %d - Max Length of Queue: %d\n", i + 1, expressCounters[i].getMaxLength());
        }
        System.out.println("Standard Counters:");
        for (int i = 0; i < standardCounters.length; i++) {
            System.out.printf("Counter %d - Amount of Customers: %d\n", i + 1, standardCounters[i].getTotalCustomers());
            System.out.printf("Counter %d - Average Wait Time: %.2f seconds\n", i + 1, standardCounters[i].getAverageWaitTime());
            System.out.printf("Counter %d - Max Length of Queue: %d\n", i + 1, standardCounters[i].getMaxLength());
        }
    }
}