class Logger {
    private static Logger instance;
    int a;
    int b;

    private Logger() {
        System.out.println("Logger being initialized");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public int log() {
        return a + b;
    }
}

public class SingletonPatternExample {

    public static void main(String[] args) {

        Logger user1 = Logger.getInstance();
        Logger user2 = Logger.getInstance();

        user1.a = 5;
        user2.a = 6;

        user1.b = 7;
        user2.b = 8;

        System.out.println("user1 = " + user1.log());
        System.out.println("user2 = " + user2.log());

        System.out.println(user1 == user2);
    }
}