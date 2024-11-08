class SuperExpressCounter extends CheckoutCounter {
    @Override
    public void addCustomer(Customer customer) {
        if (customer.getNumItems() <= 10) {
            super.addCustomer(customer);
        } else {
            System.out.println("Customer with " + customer.getNumItems() + " items cannot use Super Express Counter.");
        }
    }
}