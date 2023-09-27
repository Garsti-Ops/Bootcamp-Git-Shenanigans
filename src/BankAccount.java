public class BankAccount {

    /**
     * Die Kontonummer.
     */
    private String accountNumber;
    /**
     * Der Kontoinhaber.
     */
    private String accountHolder;
    /**
     * Das aktuelle Guthaben auf dem Konto.
     */
    private double balance;

    /**
     * Methode soll aktuellen Kontostand zurückgeben.
     *
     * @return Aktueller Kontostand
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Konstruktor der Klasse Balanace
     *
     * @param accountNumber Die Kontonummer
     * @param accountHolder Der Kontoinhaber.
     * @param balance       Das aktuelle Guthaben auf dem Konto.
     */
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    /**
     * Methode soll den Betrag amount auf das Konto einzahlen und das aktualisierte Guthaben zurückgeben
     *
     * @param amount Betrag, der auf das Konto eingezahlt wird
     * @return Aktualisiertes Guthaben
     */
    public double deposit(double amount) {
        return this.balance += amount;
    }

    /**
     * Methode soll den Betrag amount von Konto abheben.
     *
     * @param amount Betrag, der vom Konto abgehoben wird
     * @return Aktualisiertes Guthaben
     * @throws InsufficientBalanceException Wenn das abheben vom Betrag amount das Konto überziehen sollte
     */
    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Konto wird überzogen");
        }
        return this.balance -= amount;
    }


}
