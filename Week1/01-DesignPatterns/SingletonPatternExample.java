class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger Started");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Customer received: " + message);
    }
}

class Foodcart {
    private String foodName;
    private int quantity;
    private int pricePerItem;

    public Foodcart(String foodName, int quantity, int pricePerItem) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public int getTotalAmount() {
        return quantity * pricePerItem;
    }
}

public class SingletonPatternExample {

    public static void main(String[] args) {

        Foodcart order1 = new Foodcart("Idly", 2, 20);
        Foodcart order2 = new Foodcart("Sambar", 1, 10);

        System.out.println("Food Item:" + order1.getFoodName());
        System.out.println("Quantity:" + order1.getQuantity());
        System.out.println("Total Amount:" + order1.getTotalAmount());

        Logger logger1 = Logger.getInstance();
        logger1.log(order1.getFoodName());

        System.out.println();

        System.out.println("Food Item:" + order2.getFoodName());
        System.out.println("Quantity:" + order2.getQuantity());
        System.out.println("Total Amount:" + order2.getTotalAmount());

        Logger logger2 = Logger.getInstance();
        logger2.log(order2.getFoodName());
    }
}