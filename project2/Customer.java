class Customer {
    private final int arrivalTime;
    private final int numItems;

    public Customer(int arrivalTime, int numItems) {
        this.arrivalTime = arrivalTime;
        this.numItems = numItems;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumItems() {
        return numItems;
    }
}