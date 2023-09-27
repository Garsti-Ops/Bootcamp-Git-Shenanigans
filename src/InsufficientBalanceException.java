/**
 * Exceptionklasse für den Fall, dass eine Exception in einer Methode in der Klasse BankAccount ausgelöst wird.
 */
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message){
        super(message);
    }
}
