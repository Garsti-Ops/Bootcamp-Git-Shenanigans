
import java.util.List;
import java.util.Scanner;


public class TaskList {
    Scanner scInt = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);
    private List<Task> tasks;


    private void sortByPrio() {

    }

    private void sortByIsDone() {

    }

    private void sortByDate() {

    }

    /**
     * Erstellt und fügt der Liste eine neue Aufgabe hinzu
     */
    public void addTask() {
        Prioritaet neuePrioritaet = null;
        System.out.println("Gebe deinem Task einen Namen: ");
        String name = scStr.nextLine();
        System.out.println("Vergebe eine Priorität: \n 1. SEHR_WICHTIG \n 2. WICHTIG \n 3. NORMAL \n 4. UNWICHTIG");
        int optionPrio = scInt.nextInt();
        if (optionPrio == 1) {
            neuePrioritaet = Prioritaet.SEHR_WICHTIG;
        } else if (optionPrio == 2) {
            neuePrioritaet = Prioritaet.WICHTIG;
        } else if (optionPrio == 3) {
            neuePrioritaet = Prioritaet.NORMAL;
        } else if (optionPrio == 4) {
            neuePrioritaet = Prioritaet.UNWICHTIG;
        }
        this.tasks.add(new Task(name, neuePrioritaet));
    }

    /**
     * Löscht die ausgewählte Aufgabe aus der Liste "tasks"
     * @param id
     * ID der ausgewählten Aufgabe
     */
    public void removeTask(int id) {
        this.tasks.remove(id - 1);
    }

    /**
     * Diese Methode ruft mehrere Bearbeitungsoptionen für die ausgewählte Aufgabe aus.
     * Die Methode wiederholt sicht so oft, bis diese beendet wird.
     * @param id
     * ID der ausgewählten Aufgabe
     */
    public void editTask(int id) {
        boolean exitEditTask = false;
        while (!exitEditTask) {

            System.out.println("Was möchtest du bearbeiten?: \n 1. Name \n 2. Datum \n 3. Beschreibung \n 4. Priorität \n 5. Zustand \n 6. Exit");
            int n = scInt.nextInt();
            if (n == 1) {
                System.out.println("Erstelle einen namen: ");
                this.tasks.get(id - 1).setName(scStr.nextLine());
            } else if (n == 2) {
                System.out.println("Vergebe ein neues Fälligkeitsdatum: ");
                this.tasks.get(id - 1).setDate(scStr.nextLine());
            } else if (n == 3) {
                System.out.println("Bearbeite die Beschreibung: ");
                this.tasks.get(id - 1).setDescription(scStr.nextLine());
            } else if (n == 4) {
                Prioritaet neuePrioritaet = null;
                System.out.println("Vergebe eine neue Priorität: \n 1. SEHR_WICHTIG \n 2. WICHTIG \n 3. NORMAL \n 4. UNWICHTIG");
                int optionPrio = scInt.nextInt();
                if (optionPrio == 1) {
                    neuePrioritaet = Prioritaet.SEHR_WICHTIG;
                } else if (optionPrio == 2) {
                    neuePrioritaet = Prioritaet.WICHTIG;
                } else if (optionPrio == 3) {
                    neuePrioritaet = Prioritaet.NORMAL;
                } else if (optionPrio == 4) {
                    neuePrioritaet = Prioritaet.UNWICHTIG;
                }
                this.tasks.get(id - 1).setPrioritaet(neuePrioritaet);
            } else if (n == 5) {
                System.out.println("Vergebe der Aufgabe einen Status: \n 1. Erledigt \n 2. Nicht Erledigt ");
                int optionStatus = scInt.nextInt();
                boolean newStatus = false;
                if (optionStatus == 1) {
                    newStatus = true;
                }
                this.tasks.get(id - 1).setDone(newStatus);
            //Auswahl der letzten Option beendet Bearbeitungsmodus
            } else if (n == 6) {
                break;
            //Provisorische Fehlerausgabe bei nichtvalider Eingabe
            } else {
                System.out.println("Gib eine valide Option an!");
            }
        }
    }

    public void sortList(String sortBy) {

    }

}
