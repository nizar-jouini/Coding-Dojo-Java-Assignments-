import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        if (ready) {
            return (this.name + ", Your order is ready.");
        }
        else {
            return (this.name + ", Thank you for waiting. Your order will be ready soon.");
        }
    }

    public double getOrderTotal() {
        double sumPrices = 0.0;
        for (Item item : this.items) {
            sumPrices += item.getPrice();
        }
        return sumPrices;
    }

    public void display() {
        System.out.println("Customer Name: " + this.name);
        for (Item item : this.items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
        System.out.println("------------------------------");
    }
    
    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsReady() {
        return this.ready;
    }

    public void setIsReady(boolean isReady) {
        this.ready = isReady;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

