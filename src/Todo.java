import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Todo {
    private TaskList taskList;
    private Scanner numberScanner;
    private Scanner letterScanner;

    /**
     * Gibt dem Benutzer verschiedene Möglichkeiten die Aufgabenliste einzusehen oder zu bearbeiten.
     */
    public void manageList() throws ParseException {
        // Zeigt dem Benutzer, welche Optionen er hat
        System.out.println("Was willst du machen?");
        System.out.println("1 - Aufgabe der Liste hinzufügen");
        System.out.println("2 - Aufgabe aus der Liste entfernen");
        System.out.println("3 - Bestehende Aufgabe editieren");
        System.out.println("4 - Liste sortieren");
        System.out.println("5 - List anzeigen");

        int userInput = numberScanner.nextInt();

        // Falls Benutzer 1 eingibt -> füge eine neue Aufgabe hinzu
        if(userInput == 1){
            this.taskList.addTask();
        }
        // Falls Benutzer 2 eingibt -> entferne bestehende Aufgabe
        else if(userInput == 2){
            System.out.println("Gebe die Id der zu entfernenden Aufgabe ein:");
            int deletionId = numberScanner.nextInt();
            this.taskList.removeTask(deletionId);
        }
        // Falls Benutzer 3 eingibt -> ändere bestehende Aufgabe
        else if(userInput == 3){
            System.out.println("Gebe die Id der zu Aufgabe ein, die du ändern willst:");
            int changeId = numberScanner.nextInt();
            this.taskList.editTask(changeId);
        }
        // Falls Benutzer 4 eingibt -> Frage wonach Aufgaben sortiert werden sollen und sortiere
        else if(userInput == 4){
            System.out.println("Nach was willst du sortieren:");
            System.out.println("Priorität\nDatum\nStatus");
            String sortType = letterScanner.nextLine();
            this.taskList.sortList(sortType);
        }
        // Falls Benutzer 5 eingibt -> Zeige alle Aufgaben in tabellarischer Form
        else if(userInput == 5){
            List<String> lines = taskList.showList();

            for(int cycle = 0; cycle < lines.size(); cycle++){
                System.out.println(lines.get(cycle));
            }
        }

    }
}
