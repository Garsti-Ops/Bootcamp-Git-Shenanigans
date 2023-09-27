package de.vemaeg.Bank;

/**
 * Die Klasse BankAccount beschreibt ein Bankkonto
 */
public class BankAccount {
    /**
     * Die Kontonummer des Bankkontos
     */
    private String accountNumber;
    /**
     * Der Besitzer des Bankkontos
     */
    private String accountHolder;
    /**
     * Die auf dem Bankkonto gespeicherte Geldmenge
     */
    private double balance;

    /**
     * Der Konstruktor für die Klasse BankAccount
     * @param accountHolder Besitzer des Bankkontos
     * @param accountNumber Kontonummer des Bankkontos
     * @param balance Auf dem Bankkonto gespeicherte Geldmenge
     */
    public BankAccount(String accountHolder, String accountNumber, double balance){

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    /**
     * Vergrößert die auf dem Bankkonto gespeicherte Geldmenge
     * @param amount Wie viel Geld auf das Konto eingezahlt wird
     * @return Die aktualisierte menge an Geld die auf dem Konto gespeichert wird
     */
    public double deposit(double amount){

        return this.balance += amount;

    }

    /**
     * Verkleinert die auf dem Bankkonto gespeicherte Geldmenge.
     * @param amount Wie viel Geld aus dem Konto genommen wird
     * @return Die aktualisierte menge an Geld die auf dem Konto gespeichert wird
     * @throws InsufficientBalanceException Falls mehr Geld abgezogen werden soll als auf dem Konto vorhanden ist
     */
    public double withdraw(double amount) throws InsufficientBalanceException {

        if(amount > this.balance){

            throw new InsufficientBalanceException("Not enough money on account to withdraw specified amount!");

        }

        return this.balance -= amount;

    }

    /**
     * Gibt aus wie viel Geld auf dem Konto gespeichert wird
     * @return Die aktuelle Menge and Geld die auf dem Konto vorhanden ist
     */
    public double getBalance(){

        return this.balance;

    }

}
