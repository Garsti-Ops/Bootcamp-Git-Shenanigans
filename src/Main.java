public class Main {
    public static void main(String[] args) throws InsufficientBalanceException {

        BankAccount stevenStevenson = new BankAccount("6382738283728", "Steven Stevenson", 10);

        BankAccount mrWilliamWilliamson = new BankAccount("43782774728437", "Mr William Williamson", 200);

        try {
            System.out.println("Steven Kontostand: " + stevenStevenson.getBalance());
            System.out.println("+" + stevenStevenson.deposit(20));
            System.out.println("-" + stevenStevenson.withdraw(200));
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Kontostand ohne abzüge: " + stevenStevenson.getBalance());
        }

        System.out.println();

        try {
            System.out.println("William Kontostand: " + mrWilliamWilliamson.getBalance());
            System.out.println("+" + mrWilliamWilliamson.deposit(100000));
            System.out.println("-" + mrWilliamWilliamson.withdraw(100));
            System.out.println("William Kontostand: " + mrWilliamWilliamson.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Kontostand ohne abzüge: " + mrWilliamWilliamson.getBalance());
        }


    }
}