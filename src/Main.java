import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        TaskList tasklist1 = new TaskList();
        Todo todo1 = new Todo(tasklist1);
        while (true) {
            try {
                todo1.manageList();

            } catch (ParseException parseException) {
                System.err.println(parseException.getMessage());
            } catch (NumberFormatException numberFormatException){
                System.err.println(numberFormatException.getMessage() + " no number found!");
            }
        }

    }
}