public class Task {

    private Prioritaet prioritaet;
    private String name;
    private String description;
    protected boolean isDone;
    private String date;
    private static int idCounter = 0;
    private int id;

    public Task(String name, Prioritaet prioritaet) {
        this.name = name;
        this.prioritaet = prioritaet;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Speichert alle Attribute einer Aufgabe in einen String.
     * @return String in welchen die Eigenschaften der Aufgabe gespeichert sind.
     */
    @Override
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("| " + this.id + " |");
        stringBuilder.append("| " + this.name + " |");
        stringBuilder.append("| " + this.prioritaet + " |");
        stringBuilder.append("| " + (this.description != null ? this.description : " ") + " |");
        stringBuilder.append("| " + (this.date != null ? this.date : " ") + " |");
        stringBuilder.append("| " + this.isDone + " |");

        return stringBuilder.toString();

    }

}
