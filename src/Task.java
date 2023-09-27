public class Task {

    private Prioritaet prioritaet;
    private String name;
    private String description;
    private boolean isDone;
    private String date;
    private static int idCounter = 0;
    private int id;

    public Task(String name, Prioritaet prioritaet) {
        this.name = name;
        this.prioritaet = prioritaet;
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

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
