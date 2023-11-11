public class TestOrders {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        Order Cindhuri = new Order("Cindhuri");
        Order Jimmy = new Order("Jimmy");
        Order Sam = new Order("Sam");

        Item dripCoffee = new Item("drip coffee", 1.5);
        Item cappuccino = new Item("cappuccino", 2.7);
        Item latte = new Item("latte", 3.5);
        Item mocha = new Item("mocha", 4.2);

        /* ============ App Test Cases ============= */
    

        // Adding 2 items to each order
        order1.addItem(mocha);
        order1.addItem(latte);

        order2.addItem(dripCoffee);
        order2.addItem(cappuccino);

        Cindhuri.addItem(cappuccino);
        Cindhuri.addItem(mocha);

        Jimmy.addItem(latte);
        Jimmy.addItem(cappuccino);

        Sam.addItem(mocha);
        Sam.addItem(dripCoffee);

        // Display Orders
        System.out.println("\n----- Add Item Test -----");
        order1.display();
        order2.display();
        Cindhuri.display();
        Jimmy.display();
        Sam.display();

        System.out.println("\n----- Get status Message Test -----");
        // Set some Orders to ready
        order1.setIsReady(true);
        Jimmy.setIsReady(true);
        Cindhuri.setIsReady(true);

        // Test getStatusMessage functionality
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(Cindhuri   .getStatusMessage());
        System.out.println(Jimmy.getStatusMessage());
        System.out.println(Sam.getStatusMessage());

        System.out.println("\n----- Get Order Total Test -----");
        System.out.println(order1.getName() + " Orders Total: $" + order1.getOrderTotal());
        System.out.println(Cindhuri.getName() + " Orders Total: $" + Cindhuri.getOrderTotal());
        System.out.println(Sam.getName() + " Orders Total: $" + Sam.getOrderTotal());
    }
}
