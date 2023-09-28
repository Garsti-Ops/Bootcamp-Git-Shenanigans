import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskList {
    private List<Task> taskList;

    /**
     * Methode sortiert Liste anhand enum Priorität; Sehr Wichtige -> Wichtig -> Normal -> Unwichtig
     */
    private void sortByPrio() {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getPrioritaet() == Prioritaet.SEHR_WICHTIG) {
                System.out.println(taskList.get(i));
            }
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getPrioritaet() == Prioritaet.WICHTIG) {
                System.out.println(taskList.get(i));
            }
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getPrioritaet() == Prioritaet.NORMAL) {
                System.out.println(taskList.get(i));
            }
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getPrioritaet() == Prioritaet.UNWICHTIG) {
                System.out.println(taskList.get(i));
            }
        }

//        for (Prioritaet prioritaet : Prioritaet.values()){     //  IDK OB ES FUNKTIONIERT WENN JA 10/10
//            System.out.println(prioritaet);
//        }
    }

    /**
     * Methode sortiert Liste; nicht erledigte Aufgaben stehen oben
     */
    private void sortByIsDone() {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getIsDone()) {
                System.out.println(taskList.get(i));
            }
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (!taskList.get(i).getIsDone()) {
                System.out.println(taskList.get(i));
            }
        }
    }

    /**
     * Methode sortiert Liste anhand des Fälligkeitsdatums
     * @throws ParseException Wenn Datum falsch eingegeben wurde
     */
    private void sortByDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.GERMAN);
        for (int i = 0; i < taskList.size(); i++) {
            String dateInString = taskList.get(i).getDate();
            Date date = formatter.parse(dateInString);
            for (int d = 0; d < taskList.size(); d++) {
                taskList.sort((Comparator<? super Task>) date);
            }
        }
    }

    public void addTask() {

    }

    public void removeTask(int id) {

    }

    public void editTask(int id) {

    }

    public void sortList(String sortBy) {
//        if (sortBy.equalsIgnoreCase("priorität")) {
//            sortByPrio();
//        } else if (sortBy.equalsIgnoreCase("datum")) {
//            sortByDate();
//        } else if (sortBy.equalsIgnoreCase("erledigt")) {
//            sortByIsDone();
//        }
    }

}
