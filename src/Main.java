public class Main {
    public static void main(String[] args) throws InsufficientBalanceException{
        BankAccount bankontoLucas = new BankAccount("123", "lucas");

        bankontoLucas.deposit(100);
        System.out.println(bankontoLucas.getBalance());
        try{
            bankontoLucas.withdraw(1000);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Dein aktuelles Guthaben beträgt: " + bankontoLucas.getBalance());
        System.out.println();
        BankAccount bankkontoDummy = new BankAccount("0000", "dummy");

        //Bankkonto Dummy
        bankkontoDummy.deposit(90.50);
        System.out.println("Dummys Kontostand beträgt: " + bankkontoDummy.getBalance());
        try{
            bankkontoDummy.withdraw(1);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Dummys Konstostand beträgt: " + bankkontoDummy.getBalance());
    }
}
