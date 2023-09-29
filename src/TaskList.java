import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Stellt eine Liste von Aufgaben dar
 */
public class TaskList {
    /**
     * Scanner zum Eingeben von Nummern
     */
    Scanner scStr = new Scanner(System.in);
    /**
     * Liste an erstellten Aufgaben
     */
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
    }

    /**
     * Methode sortiert Liste anhand enum Priorität; Sehr Wichtige -> Wichtig -> Normal -> Unwichtig
     */
    private void sortByPrio() {
        // Geht viermal durch die Aufgabenliste und gibt Aufgaben in abfallender Priorität an die Konsole aus
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
        // Geht durch die Liste und gibt Aufgaben an die Konsole aus, welche noch zu bearbeiten sind
        for (int i = 0; i < taskList.size(); i++) {
            if (!taskList.get(i).getIsDone()) {
                System.out.println(taskList.get(i));
            }
        }
        // Geht durch die Liste und gibt Aufgaben an die Konsole aus, welche erledigt sind
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

        // Erstellt zwei Listen, eine für Aufgaben mit Fälligkeitsdatum und eine für Aufgaben ohne
        List<Task> tasksWithDate = new ArrayList<>();
        List<Task> tasksWithoutDate = new ArrayList<>();

        // Geht durch Liste mit allen Aufgaben und speichert Aufgaben in eine der Zwei oben erstellten Listen
        for (int listPlace = 0; listPlace < this.taskList.size(); listPlace++) {

            Task inspectedTask = this.taskList.get(listPlace);

            if (inspectedTask.getDate() != null) {
                tasksWithDate.add(inspectedTask);
            } else {
                tasksWithoutDate.add(inspectedTask);
            }
        }

        // Geht durch Liste der Aufgaben mit Fälligkeitsdatum und sortiert diese von frühstem zum spätesten
        for (int i = tasksWithDate.size() - 1; i >= 0; i--) {
            Task k1 = tasksWithDate.get(i);

            for (int k = i - 1; k >= 0; k--) {

                Task k2 = tasksWithDate.get(k);

                if (k1.getDate().before(k2.getDate())) {
                    tasksWithDate.set(k, k1);
                    tasksWithDate.set(i, k2);
                }
            }
        }

        List<String> lines = new ArrayList<>();

        // Füllt String Liste zuerst mit sortierten Aufgaben, welche ein Datum haben und dann mit Aufgaben welche kein Datum haben
        for (int linePlace = 0; linePlace < tasksWithDate.size(); linePlace++) {
            lines.add(tasksWithDate.get(linePlace).toString());
        }
        for (int linePlace = 0; linePlace < tasksWithoutDate.size(); linePlace++) {
            lines.add(tasksWithoutDate.get(linePlace).toString());
        }

        // Gibt Aufgaben aus der String Liste auf die Konsole aus
        for (int cycle = 0; cycle < lines.size(); cycle++) {
            System.out.println(lines.get(cycle));
        }

    }

    /**
     * Methode sortiert die Aufgaben nach alphabetischer Reihenfolge der Aufgabennamen
     */
    public void sortByName() {
        //Erstellt Liste, in welcher die neu sortierte Reihenfolge gespeichert wird
        List<Task> tasksNames = new ArrayList<>();
        tasksNames.addAll(this.taskList);
        //Sortiert die Aufgabennamen nach "Bubblesort" Algorithmus in alphabetischer Reihenfolge
        for (int amountOfTries = 0; amountOfTries < tasksNames.size(); amountOfTries++) {
            for (int i = 0; i < tasksNames.size(); i++) {
                Task t1 = tasksNames.get(i);
                boolean hasSorted = false;

                for (int k = i + 1; k < tasksNames.size(); k++) {
                    Task t2 = tasksNames.get(k);

                    if (hasSorted) {
                        break;
                    }
                    if (t1.getName().compareToIgnoreCase(t2.getName()) > 0) {
                        tasksNames.set(k, t1);
                        tasksNames.set(i, t2);
                        hasSorted = true;
                    }
                }
            }
        }

        List<String> lines = new ArrayList<>();

        // Füllt String Liste mit den sortierten Aufgaben und gibt diese dann an die Konsole aus
        for (int linePlace = 0; linePlace < tasksNames.size(); linePlace++) {
            lines.add(tasksNames.get(linePlace).toString());
        }
        for (int cycle = 0; cycle < lines.size(); cycle++) {
            System.out.println(lines.get(cycle));
        }

    }

    /**
     * Erstellt und fügt der Liste eine neue Aufgabe hinzu
     *
     * @throws ParseException Falls keine Nummer in der Benutzereingabe erkannt wird
     */
    public void addTask() throws ParseException {
        Prioritaet neuePrioritaet = null;
        // Frägt Name der neuen Aufgabe ab
        System.out.println("Gebe deinem Task einen Namen: ");
        String name = scStr.nextLine();
        // Frägt Priorität der neuen Aufgabe so lange ab, bis valide Eingabe getätigt wird
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
                System.err.println("Gib eine valide Option ein!");
                continue;
            }
            //Erstellt neue Aufgabe mit nicht optionalen Eigenschaften
            this.taskList.add(new Task(name, neuePrioritaet));
            break;

        }
        // Lässt den Benutzer optionale Eigenschaften zuweisen
        while (true) {
            System.out.println("Was willst du optional noch hinzufügen: \n1. Beschreibung \n2. Datum\n3. Nichts");
            String extraAttributes = scStr.nextLine();
            if (Integer.parseInt(extraAttributes) == 1) {
                System.out.println("Erstelle eine Beschreibung:");
                this.taskList.get(this.taskList.size() - 1).setDescription(scStr.nextLine());
            } else if (Integer.parseInt(extraAttributes) == 2) {
                this.taskList.get(this.taskList.size() - 1).buildDate();
            } else {
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
        // Entfernt gewünschte Aufgabe
        this.taskList.remove(id - 1);
        // Dekrementiert die Id aller nachfolgenden Aufgaben
        for (int idToBeReduced = id - 1; idToBeReduced < this.taskList.size(); idToBeReduced++) {

            this.taskList.get(idToBeReduced).reduceId();

        }
    }

    /**
     * Diese Methode ruft mehrere Bearbeitungsoptionen für die ausgewählte Aufgabe aus.
     * Die Methode wiederholt sicht so oft, bis diese beendet wird.
     *
     * @param id ID der ausgewählten Aufgabe
     *
     * @throws ParseException Falls keine Nummer in der Benutzereingabe erkannt wird
     * @throws IndexOutOfBoundsException Falls Benutzer eine nichtexistierende Aufgabe bearbeiten will
     */
    public void editTask(int id) throws ParseException, IndexOutOfBoundsException {
        boolean exitEditTask = false;
        //Falls Benutzer valide ID eingibt, fahre mit Bearbeitung fort
        if (id <= taskList.size() && id > 0) {
            while (!exitEditTask) {
                //Auswahl einer Option über Eingabe von einer Zahl
                System.out.println("Was möchtest du bearbeiten?: \n 1. Name \n 2. Datum \n 3. Beschreibung \n 4. Priorität \n 5. Exit");
                String n = scStr.nextLine();
                //Erstellt einen neuen Namen für die ausgewählte ID
                if (Integer.parseInt(n) == 1) {
                    System.out.println("Erstelle einen namen: ");
                    this.taskList.get(id - 1).setName(scStr.nextLine());
                }
                //Erstellt ein neues Fälligkeitsdatum für die ausgewählte ID
                else if (Integer.parseInt(n) == 2) {
                    System.out.println("Vergebe ein neues Fälligkeitsdatum: ");
                    this.taskList.get(id - 1).buildDate();
                }
                //Erstellt eine neue Beschreibung für die ausgewählte ID
                else if (Integer.parseInt(n) == 3) {
                    System.out.println("Bearbeite die Beschreibung: ");
                    this.taskList.get(id - 1).setDescription(scStr.nextLine());
                }
                //Erstellt eine neue Priorität für die ausgewählte ID
                else if (Integer.parseInt(n) == 4) {
                    while (true) {
                        try {
                            //Gibt mögliche Prioritäten an
                            Prioritaet neuePrioritaet = null;
                            System.out.println("Vergebe eine neue Priorität: \n 1. SEHR_WICHTIG \n 2. WICHTIG \n 3. NORMAL \n 4. UNWICHTIG");
                            String optionPrio = scStr.nextLine();
                            //Auswahl und Änderung der Priorität
                            if (Integer.parseInt(optionPrio) == 1) {
                                neuePrioritaet = Prioritaet.SEHR_WICHTIG;
                            } else if (Integer.parseInt(optionPrio) == 2) {
                                neuePrioritaet = Prioritaet.WICHTIG;
                            } else if (Integer.parseInt(optionPrio) == 3) {
                                neuePrioritaet = Prioritaet.NORMAL;
                            } else if (Integer.parseInt(optionPrio) == 4) {
                                neuePrioritaet = Prioritaet.UNWICHTIG;
                            } else {
                                System.err.println("Du Keck, gib keine falsche Zahlen ein :>");
                                continue;
                            }
                            this.taskList.get(id - 1).setPrioritaet(neuePrioritaet);
                            break;
                        } catch (NumberFormatException numberFormatException) {
                            // Gibt Exception zurück, falls Benutzereingabe keine Nummer enthält
                            System.err.println(numberFormatException.getMessage() + " no number found!");
                        }
                    }
                }
                //Beendet den Bearbeitungsmodus
                else if (Integer.parseInt(n) == 5) {
                    break;
                }
                //Provisorische Fehlerausgabe bei nicht valider Eingabe
                else {
                    System.err.println("Gib eine valide Option an!");
                }
            }
        }
        // Falls Benutzer invalide Id eingibt, dann IndexOutOfBoundsException
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Ruft eine spezifische Methode auf entsprechend Benutzereingabe
     * @param sortBy Wonach sortiert werden soll
     * @throws ParseException Wenn keine Nummer in der Benutzereingabe gefunden wird
     */
    public void sortList(String sortBy) throws ParseException {
        if (Integer.parseInt(sortBy) == 1) {
            sortByPrio();
        } else if (Integer.parseInt(sortBy) == 2) {
            sortByDate();
        } else if (Integer.parseInt(sortBy) == 3) {
            sortByIsDone();
        } else if (Integer.parseInt(sortBy) == 4) {
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

    /**
     * Ändert den Status von "In Arbeit" zu "Erledigt" und andersherum
     * @param id Id der Aufgabe, wovon der Status geändert werden soll
     */
    public void changeStatus(int id) {

        this.taskList.get(id - 1).setDone(!this.taskList.get(id - 1).getIsDone());

    }

}