package quizsystem;

public abstract class Quiz {
    String title;
    String description;

    Quiz(String t, String d) {
        this.title = t;
        this.description = d;
    }

    public abstract void startQuiz();
}
