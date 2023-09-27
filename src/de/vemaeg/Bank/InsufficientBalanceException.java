package de.vemaeg.Bank;

/**
 * Hier soll ein Fehler ausgegeben werden, wenn mehr Geld von einem Bankkonto abgehoben werden soll, als es auf dem Konto zurzeit gibt
 */
public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message){

        super(message);

    }

}
