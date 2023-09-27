/**
 * Exception die geworfen wird, sobald Konto überzogen wird (Kontostand < 0)
 */

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message){
        super(message);
    }

}
