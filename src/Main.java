import Bank.BankAccount;
import Bank.InsufficientBalanceException;

public class Main {
    public static void main(String[] args) throws InsufficientBalanceException {
        //Erstellt zwei neue Bankkonten
        BankAccount bankontoLucas = new BankAccount("123", "lucas");
        BankAccount bankkontoDummy = new BankAccount("0000", "dummy");

        //Prüfen der Funktionalität von Bankkonto Lucas

        bankontoLucas.deposit(100);
        System.out.println(bankontoLucas.getBalance());

        try{
            bankontoLucas.withdraw(1000);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Dein aktuelles Guthaben beträgt: " + bankontoLucas.getBalance());


        System.out.println();


        //Prüfen der Funktionalität Bankkonto Dummy

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
