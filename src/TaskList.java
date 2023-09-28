import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TaskList {
    Scanner scInt = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
    }

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

    }

    /**
     * Methode sortiert Liste; nicht erledigte Aufgaben stehen oben
     */
    private void sortByIsDone() { //yay
        for (int i = 0; i < taskList.size(); i++) {
            if (!taskList.get(i).getIsDone()) {
                System.out.println(taskList.get(i));
            }
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getIsDone()) {
                System.out.println(taskList.get(i));
            }
        }
    }

    /**
     * Methode sortiert Liste anhand des Fälligkeitsdatums
     *
     * @throws ParseException Wenn Datum falsch eingegeben wurde
     */
    private void sortByDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

        for (int i = taskList.size() - 1; i >= 0; i--) {
            Task t1 = taskList.get(i);

            for (int k = i - 1; k >= 0; k--) {
                Task t2 = taskList.get(k);

                if (t1.getDate().before(t2.getDate())) {
                    this.taskList.set(k, t1);
                    this.taskList.set(i, t2);
                }
            }
        }

        List<String> lines = this.showList();

        for (int cycle = 0; cycle < lines.size(); cycle++) {
            System.out.println(lines.get(cycle));
        }

    }

    public void sortByName(){

        for (int i = taskList.size() - 1; i >= 0; i--) {
            Task t1 = taskList.get(i);

            for (int k = i - 1; k >= 0; k--) {
                Task t2 = taskList.get(k);

                if (t1.getName().compareTo(t2.getName()) < 0) {
                    this.taskList.set(k, t1);
                    this.taskList.set(i, t2);
                }
            }
        }

        List<String> lines = this.showList();

        for (int cycle = 0; cycle < lines.size(); cycle++) {
            System.out.println(lines.get(cycle));
        }

    }
    /**
     * Erstellt und fügt der Liste eine neue Aufgabe hinzu
     */
    public void addTask() throws ParseException {
        Prioritaet neuePrioritaet = null;
        System.out.println("Gebe deinem Task einen Namen: ");
        String name = scStr.nextLine();
        while (true) {
            System.out.println("Vergebe eine Priorität: \n 1. SEHR_WICHTIG \n 2. WICHTIG \n 3. NORMAL \n 4. UNWICHTIG");
            String optionPrio = scStr.nextLine();

            if (Integer.parseInt(optionPrio) == 1) {
                neuePrioritaet = Prioritaet.SEHR_WICHTIG;
            } else if (Integer.parseInt(optionPrio) == 2) {
                neuePrioritaet = Prioritaet.WICHTIG;
            } else if (Integer.parseInt(optionPrio) == 3) {
                neuePrioritaet = Prioritaet.NORMAL;
            } else if (Integer.parseInt(optionPrio) == 4) {
                neuePrioritaet = Prioritaet.UNWICHTIG;
            } else {
                System.err.println("Du Keck gib keine negativen Zahlen ein :>");
                continue;
            }
            this.taskList.add(new Task(name, neuePrioritaet));
            break;

        }
        while(true){
            System.out.println("Was willst du optional noch hinzufügen: \n1. Beschreibung \n2. Datum\n3. Nichts");
            String extraAttributes = scStr.nextLine();
            if(Integer.parseInt(extraAttributes) == 1){
                System.out.println("Erstelle eine Beschreibung:");
                this.taskList.get(this.taskList.size() - 1).setDescription(scStr.nextLine());
            }else if (Integer.parseInt(extraAttributes) == 2){
                this.taskList.get(this.taskList.size()-1).buildDate();
            }else{
                break;
            }
        }

    }

    /**
     * Löscht die ausgewählte Aufgabe aus der Liste "tasks"
     *
     * @param id ID der ausgewählten Aufgabe
     */
    public void removeTask(int id) {
        this.taskList.remove(id - 1);
        for (int idToBeReduced = id - 1; idToBeReduced < this.taskList.size(); idToBeReduced++) {

            this.taskList.get(idToBeReduced).reduceId();

        }
    }

    /**
     * Diese Methode ruft mehrere Bearbeitungsoptionen für die ausgewählte Aufgabe aus.
     * Die Methode wiederholt sicht so oft, bis diese beendet wird.
     *
     * @param id ID der ausgewählten Aufgabe
     */
    public void editTask(int id) throws ParseException {
        boolean exitEditTask = false;
        while (!exitEditTask) {

            System.out.println("Was möchtest du bearbeiten?: \n 1. Name \n 2. Datum \n 3. Beschreibung \n 4. Priorität \n 5. Zustand \n 6. Exit");
            int n = scInt.nextInt();
            if (n == 1) {
                System.out.println("Erstelle einen namen: ");
                this.taskList.get(id - 1).setName(scStr.nextLine());
            } else if (n == 2) {
                System.out.println("Vergebe ein neues Fälligkeitsdatum: ");
                this.taskList.get(id - 1).buildDate();
            } else if (n == 3) {
                System.out.println("Bearbeite die Beschreibung: ");
                this.taskList.get(id - 1).setDescription(scStr.nextLine());
            } else if (n == 4) {
                while (true) {
                   try {
                       Prioritaet neuePrioritaet = null;
                       System.out.println("Vergebe eine neue Priorität: \n 1. SEHR_WICHTIG \n 2. WICHTIG \n 3. NORMAL \n 4. UNWICHTIG");
                       String optionPrio = scStr.nextLine();

                       if (Integer.parseInt(optionPrio) == 1) {
                           neuePrioritaet = Prioritaet.SEHR_WICHTIG;
                       } else if (Integer.parseInt(optionPrio) == 2) {
                           neuePrioritaet = Prioritaet.WICHTIG;
                       } else if (Integer.parseInt(optionPrio) == 3) {
                           neuePrioritaet = Prioritaet.NORMAL;
                       } else if (Integer.parseInt(optionPrio) == 4) {
                           neuePrioritaet = Prioritaet.UNWICHTIG;
                       } else {
                           System.err.println("Du Keck gib keine negativen Zahlen ein :>");
                           continue;
                       }
                       this.taskList.get(id - 1).setPrioritaet(neuePrioritaet);
                       break;
                   }catch (NumberFormatException numberFormatException){
                       System.err.println(numberFormatException.getMessage() + " no number found!");
                   }
                }
            } else if (n == 5) {
                System.out.println("Vergebe der Aufgabe einen Status: \n 1. Erledigt \n 2. Nicht Erledigt ");
                int optionStatus = scInt.nextInt();
                boolean newStatus = false;
                if (optionStatus == 1) {
                    newStatus = true;
                }
                this.taskList.get(id - 1).setDone(newStatus);
                //Auswahl der letzten Option beendet Bearbeitungsmodus
            } else if (n == 6) {
                break;
                //Provisorische Fehlerausgabe bei nichtvalider Eingabe
            } else {
                System.out.println("Gib eine valide Option an!");
            }
        }
    }

    public void sortList(String sortBy) throws ParseException {
        if (sortBy.equalsIgnoreCase("priorität")) {
            sortByPrio();
        } else if (sortBy.equalsIgnoreCase("datum")) {
            sortByDate();
        } else if (sortBy.equalsIgnoreCase("status")) {
            sortByIsDone();
        } else if(sortBy.equalsIgnoreCase("name")){
            sortByName();
        }
    }

    /**
     * Speichert die einzelnen Aufgaben in eine String Liste und gibt diese aus.
     *
     * @return String Liste welche alle gespeicherten Aufgaben beinhaltet
     */
    public List<String> showList() {
        List<String> list = new ArrayList<>();
        for (int cycle = 0; cycle < this.taskList.size(); cycle++) {
            list.add(this.taskList.get(cycle).toString());
        }
        return list;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

}

