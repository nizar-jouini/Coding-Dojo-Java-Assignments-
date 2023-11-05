public class CafeJava {
    public static void main(String[] args){
        // APP VARIABLES
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String dispalyTotalMessage = "Your Total is $";

        // Menu Variables
        double mochaPrice = 3.5;
        double dripCoffePrice = 2.7;
        double lattePrice = 4.1;
        double cappucinoPrice = 3.3;

        // Customer name Variables
        String customer1 = "Nizar";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Orders
        String order1 = "Coffe";
        String order2 = "Cappucino";
        String order3 = "Latte";
        Integer qtyOrder3 = 2;
        String order4 = "Coffe";

        // Order Completion
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP Interaction Simulation
        // Nizar Order
        System.out.println(generalGreeting + customer1);
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }

        // Noah Order
        System.out.println(generalGreeting + customer4);
        if (isReadyOrder2) {
            System.out.println(customer4 + readyMessage);
            switch (order2) {
                case "Mocha":
                    System.out.println(dispalyTotalMessage + (mochaPrice));
                    break;
                case "Coffe":
                    System.out.println(dispalyTotalMessage + (dripCoffePrice));
                    break;
                case "Latte":
                    System.out.println(dispalyTotalMessage + (lattePrice));
                    break;
                case "Cappucino":
                    System.out.println(dispalyTotalMessage + (cappucinoPrice));
                    break;
                default:
                    break;
            }
        }
        else {
            System.out.println( customer4 + pendingMessage);
        }

        // Sam Order
        System.out.println(generalGreeting + customer2);
        switch (order3) {
                case "Mocha":
                    System.out.println(dispalyTotalMessage + (mochaPrice * qtyOrder3));
                    break;
                case "Coffe":
                    System.out.println(dispalyTotalMessage + (dripCoffePrice * qtyOrder3));
                    break;
                case "Latte":
                    System.out.println(dispalyTotalMessage + (lattePrice * qtyOrder3));
                    break;
                case "Cappucino":
                    System.out.println(dispalyTotalMessage + (cappucinoPrice * qtyOrder3));
                    break;
                default:
                    break;
            }
        if (isReadyOrder3) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println( customer2 + pendingMessage);
        }

        // Jimmy Order
        System.out.println(generalGreeting + customer3);
        if (isReadyOrder4) {
            System.out.println(customer3 + readyMessage);
            switch (order4) {
                case "Mocha":
                    System.out.println(dispalyTotalMessage + (mochaPrice));
                    break;
                case "Coffe":
                    System.out.println(dispalyTotalMessage + (dripCoffePrice));
                    break;
                case "Latte":
                    System.out.println(dispalyTotalMessage + (lattePrice));
                    break;
                case "Cappucino":
                    System.out.println(dispalyTotalMessage + (cappucinoPrice));
                    break;
                default:
                    break;
            }
        }
        else {
            System.out.println( customer3 + pendingMessage);
        }
        double difference = lattePrice - dripCoffePrice;
        if (difference > 0) {
            System.out.println("Your new Order is Latte, you have to add $" + difference );
        }
        else if (difference == 0) {
            System.out.println("Your new Order is Latte, two prices are equal");
        }
        else {
            System.out.println("Your new Order is Latte, we have to give you" + difference );
        }
    }
}