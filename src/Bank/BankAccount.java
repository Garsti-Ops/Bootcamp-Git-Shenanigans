package Bank;

/**
 * Diese Klasse ist der Grundbaustein für alle neu erstellten Bankkonten
 */
public class BankAccount {
    /**
     * Beinhaltet die erstellte Kontonummer
     */
    private String accountNumber;
    /**
     * Beinhaltet den erstellte Kontobesitzer
     */
    private String accountHolder;
    /**
     * Beinhaltet den aktuellen Kontostand
     */
    private double balance;

    public BankAccount(String accountNumber, String accountHolder){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    /**
     * Mit dieser Methode kann ein beliebiger Betrag auf das Konto eingezahlt werden.
     * Das eingezahlte Guthaben wird auf das vorhandene Guthaben addiert
     * @param amount
     * Eingabe des Geldbetrages
     * @return
     * Gibt den neuen aktuellen Kontostand zurück
     */
    public double deposit(double amount){
        this.balance += amount;
        return this.balance;
    }

    /**
     * Mit dieser Methode kann ein beliebiger Betrag vom Kontoguthaben abgehoben werden.
     * Es kann kein Betrag abgehoben werden, welcher das aktuelle Guthaben überschreitet.
     *
     * @param amount
     * Eingabe des gewünschten Geldbetrages
     * @return
     * Gibt bei erfolgreichen Abheben den neuen Guthabenstand zurück
     * @throws InsufficientBalanceException
     * Gibt einen Fehler zurück, wenn der gewünschte Geldbetrag größer als das vorhandene Guthaben ist
     */
    public double withdraw(double amount) throws InsufficientBalanceException{
        if(getBalance() < amount){
            throw new InsufficientBalanceException("Du kannst nicht mehr Abheben als deinen Aktuellen Kontostand");

        }else {
            this.balance -= amount;
            return this.balance;
        }
    }

    /**
     * Methode um den aktuellen Guthabenstand abzufragen
     * @return
     * Gibt den Guthabenstand als Betrag zurück
     */
    public double getBalance(){
        return this.balance;
    }
}
