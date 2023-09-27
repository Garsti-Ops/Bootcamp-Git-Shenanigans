import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<Task>();
    }

    private void sortByPrio() {

    }

    private void sortByIsDone() {

    }

    private void sortByDate() {

    }

    public void addTask() {

    }

    public void removeTask(int id) {

    }

    public void editTask(int id) {

    }

    public void sortList(String sortBy) {

    }

    /**
     * Speichert die einzelnen Aufgaben in eine String Liste und gibt diese aus.
     * @return String Liste welche alle gespeicherten Aufgaben beinhaltet
     */
    public List<String> showList(){
        List<String> list = new ArrayList<>();
        for(int cycle = 0; cycle < this.taskList.size(); cycle++){
            list.add(this.taskList.get(cycle).toString());
        }
        return list;
    }

}
