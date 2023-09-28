public class Main {
    public static void main(String[] args) {
        TaskList tasklist1 = new TaskList();
        Todo todo1 = new Todo(tasklist1);
        while (true) {
            try {
                todo1.manageList();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}