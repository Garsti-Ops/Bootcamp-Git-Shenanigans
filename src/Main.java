import de.vemaeg.Bank.*;

public class Main {

    public static void main(String[] args){

        // Erstelle zwei unterschiedliche Bankkonten
        BankAccount richAccount = new BankAccount("Herrmann","00E48FQ9J1", 2000000.03);
        BankAccount poorAccount = new BankAccount("Dieter", "OR224LUK3T", 120.70);

        try{

            // Gebe die derzeitige Menge an Geld aus, die auf den zwei Konten gespeichert ist
            System.out.println("The account balance of the poor account is: " + poorAccount.getBalance());
            System.out.println("The account balance of the rich account is: " + richAccount.getBalance());

            // Zahle auf beide Konten 200 Geld ein
            System.out.println("Both accounts will now receive 200 money:");
            System.out.println("Poor: " + poorAccount.deposit(200));
            System.out.println("Poor: " + richAccount.deposit(200));

            // Entnehme beiden Konten 100 Geld
            System.out.println("Both accounts will now pay 100 money:");
            System.out.println("Poor: " + poorAccount.withdraw(100));
            System.out.println("Poor: " + richAccount.withdraw(100));

            // Entnehme dem Konto mit mehr Geld 500 Geld und zahle diese auf das Konto mit weniger Geld ein
            System.out.println("The rich account will now pay the poor account 500 money:");
            System.out.println("Rich: " + richAccount.withdraw(500));
            System.out.println("Poor: " + poorAccount.deposit(500));

            // Entnehme dem Konto mit weniger Geld 1000 Geld und zahle diese auf das Konto mit mehr Geld ein
            System.out.println("The poor account must now pay back 1000 money:");
            System.out.println("Poor: " + poorAccount.withdraw(1000));
            System.out.println("Rich: " + richAccount.deposit(1000));

        }catch(InsufficientBalanceException exception){

            // Gibt die Fehlermeldung für InsufficientBalanceException aus
            System.out.println(exception.getMessage());

        }finally{

            // Gibt Text aus
            System.out.println("Such is life!");

        }

    }

}
