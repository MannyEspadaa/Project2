class ExpressCounter extends CheckoutCounter {
    @Override
    public void addCustomer(Customer customer) {
        if (customer.getNumItems() <= 15) {
            super.addCustomer(customer);
        } else {
            System.out.println("Customer with " + customer.getNumItems() + " items cannot use Express Counter.");
        }
    }
}