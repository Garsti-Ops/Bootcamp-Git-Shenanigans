public class Main {
    public static void main(String[] args) throws InsufficientBalanceException {

        //neue Bank Accounts
        BankAccount stevenStevenson = new BankAccount("9", "Steven Stevenson", 10);
        BankAccount mrWilliamWilliamson = new BankAccount("43782774728437", "Mr William Williamson", 200);

        // try catch für Steven
        try {
            //Steven geht hier zur Bank, lädt Geld aufs Konto & hebt zu viel ab
            System.out.println("Steven Kontostand: " + stevenStevenson.getBalance());
            System.out.println("+" + stevenStevenson.deposit(20));
            System.out.println("-" + stevenStevenson.withdraw(200));
        } catch (InsufficientBalanceException e) {
            //--> zu viel Geld abgehoben
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Kontostand: " + stevenStevenson.getBalance());
        }

        System.out.println();

        try {
            //Willim geht hier zur Bank, lädt Geld aufs Konto & hebt Geld viel ab
            System.out.println("William Kontostand: " + mrWilliamWilliamson.getBalance());
            System.out.println("+" + mrWilliamWilliamson.deposit(100000));
            System.out.println("-" + mrWilliamWilliamson.withdraw(100));
            System.out.println("William Kontostand: " + mrWilliamWilliamson.getBalance());
        } catch (InsufficientBalanceException e) {
            //--> zu viel Geld abgehoben
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Kontostand: " + mrWilliamWilliamson.getBalance());
        }


    }
}