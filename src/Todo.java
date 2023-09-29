import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Gibt dem Benutzer Möglichkeiten die Aufgabenliste einzusehen oder zu bearbeiten.
 */
public class Todo {
    /**
     * Objekt der TaskList Klasse in dem die Aufgaben gespeichert sind
     */
    private TaskList taskList;
    /**
     * Scanner zum Eingeben von Strings über die Konsole
     */
    private Scanner letterScanner = new Scanner(System.in);

    /**
     * Konstruktor für die Klasse Todo
     * @param taskList Liste in der die Aufgaben gespeichert werden
     */
    public Todo(TaskList taskList){
       this.taskList = taskList;
    }

    /**
     * Methode durch welche der Benutzer die Liste an Aufgaben einsehen kann, oder einzelne Aufgaben hinzufügen, verwerfen oder ändern kann
     * @throws ParseException falls beim Überprüfen der Eingabe des Benutzers keine Nummer gefunden wird
     */
    public void manageList() throws ParseException {
        // Zeigt dem Benutzer, welche Optionen er hat
        System.out.println("Was willst du machen?☝\uFE0F\uD83E\uDD13 ");
        System.out.println("1 - Aufgabe der Liste hinzufügen");
        System.out.println("2 - Status einer Aufgabe ändern");
        System.out.println("3 - Aufgabe aus der Liste entfernen");
        System.out.println("4 - Bestehende Aufgabe editieren");
        System.out.println("5 - Liste sortieren");
        System.out.println("6 - Liste anzeigen");

        String userInput = letterScanner.nextLine().trim();

        // Easter-Egg haha
        if(userInput.equalsIgnoreCase("e")){
            // wichtige und witzige emoji ausgaben
            for (int i = 0; i < 20; i++) {
                System.out.print("☝\uFE0F\uD83E\uDD13");
            }
            System.out.println();
        }
        // Falls Benutzer 1 eingibt -> füge eine neue Aufgabe hinzu
       else if(Integer.parseInt(userInput) == 1){
            this.taskList.addTask();
        }
       // Falls Benutzer 2 eingibt -> ändere den Status einer Aufgabe
       else if (Integer.parseInt(userInput) == 2) {
            System.out.println("Gebe die Id der Aufgabe an, bei der der Status geändert werden soll:");
            String statusChangeId = letterScanner.nextLine();
            this.taskList.changeStatus(Integer.parseInt(statusChangeId));
        }
        // Falls Benutzer 3 eingibt -> entferne bestehende Aufgabe
        else if(Integer.parseInt(userInput) == 3){
            System.out.println("Gebe die Id der zu entfernenden Aufgabe ein:");
            String deletionId = letterScanner.nextLine();
            this.taskList.removeTask(Integer.parseInt(deletionId));
        }
        // Falls Benutzer 4 eingibt -> ändere bestehende Aufgabe
        else if(Integer.parseInt(userInput) == 4){
            System.out.println("Gebe die Id der zu Aufgabe ein, die du ändern willst:");
            String changeId = letterScanner.nextLine();
            this.taskList.editTask(Integer.parseInt(changeId));
        }
        // Falls Benutzer 5 eingibt -> Frage wonach Aufgaben sortiert werden sollen und sortiere
        else if(Integer.parseInt(userInput) == 5){
            System.out.println("Nach was willst du sortieren:");
            System.out.println("1 - Priorität\n2 - Datum\n3 - Status\n4 - Name");
            String sortType = new Scanner(System.in).nextLine();
            this.taskList.sortList(sortType);
        }
        // Falls Benutzer 6 eingibt -> Zeige alle Aufgaben in tabellarischer Form
        else if(Integer.parseInt(userInput) == 6){
            List<String> lines = taskList.showList();

            System.out.println("| Id || Name || Priorität || Beschreibung || Fälligkeitsdatum || Ist fertig? |");

            for(int cycle = 0; cycle < lines.size(); cycle++){
                System.out.println(lines.get(cycle));
            }
        }

    }
}
