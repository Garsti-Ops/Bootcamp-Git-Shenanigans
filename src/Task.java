import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Task {

    private Scanner nummerScanner = new Scanner(System.in);
    private Prioritaet prioritaet;
    private String name;
    private String description;
    protected boolean isDone;
    private Date date;
    private static int idCounter = 0;
    private int id;

    public Task(String name, Prioritaet prioritaet) {
        this.name = name;
        this.prioritaet = prioritaet;
        this.id = ++idCounter;
    }

    public Prioritaet getPrioritaet() {
        return this.prioritaet;
    }

    public void setPrioritaet(Prioritaet prioritaet) {
        this.prioritaet = prioritaet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void reduceId() {

        this.id -= 1;
        idCounter--;

    }

    /**
     * Speichert alle Attribute einer Aufgabe in einen String.
     *
     * @return String in welchen die Eigenschaften der Aufgabe gespeichert sind.
     */
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("| " + this.id + " |");
        stringBuilder.append("| " + this.name + " |");
        stringBuilder.append("| " + this.prioritaet + " |");
        stringBuilder.append("| " + (this.description != null ? this.description : " ") + " |");
        stringBuilder.append("| " + (this.date != null ? this.date : " ") + " |");
        stringBuilder.append("| " + this.isDone + " |");

        return stringBuilder.toString();
    }

    public void buildDate() throws ParseException {
        String day = "";
        String month = "";
        String year = "";


       while(true) {
           System.out.println("Gebe den Tag ein:");
           day = nummerScanner.nextLine();
           System.out.println("Gebe den Monat ein:");
           month = nummerScanner.nextLine();
           System.out.println("Gebe das Jahr ein:");
           year = nummerScanner.nextLine();

           if(Integer.parseInt(day) < 0 || Integer.parseInt(month) < 0 || Integer.parseInt(year) < 0){
               System.err.println("Keine negativen Zahlen eingeben!");
               continue;
           }

           break;
       }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String fullDate = day + "." + month + "." + year;

        this.date = simpleDateFormat.parse(fullDate);
    }

    public String getName(){
        return this.name;
    }

}
