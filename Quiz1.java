package quizsystem;

import fileoperations.forFileHandling;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class Quiz1 extends Quiz {
    List<Question> questions;
    int timelimit;
    forFileHandling fileHandler = new forFileHandling();

    public Quiz1(String title, String des, int timelim) {
        super(title, des);
        this.timelimit = timelim;
        this.questions = new ArrayList<>();
    }

    public void addQue(Question question) {
        questions.add(question);
    }

    public void addQue(List<Question> qList) {
        questions.addAll(qList);
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        System.out.println("Starting Quiz: " + this.title);
        System.out.println(description);
        System.out.println("You have " + this.timelimit + " seconds to complete the Quiz.");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        final boolean[] timeoutOccurred = {false};

        executor.schedule(() -> {
            timeoutOccurred[0] = true;
            System.out.println("\nTime's up! The quiz has ended.");
        }, this.timelimit, TimeUnit.SECONDS);

        for (Question q : questions) {
            if (timeoutOccurred[0]) {
                break;
            }

            System.out.println(q.que);
            for (int i = 0; i < q.ops.size(); i++) {
                System.out.println((i + 1) + ". " + q.ops.get(i));
            }
            System.out.println("Enter index of your answer : ");
            int ansidx = sc.nextInt() - 1;

            if (ansidx >= 0 && ansidx < q.ops.size()) {
                String userans = q.ops.get(ansidx);
                if (q.checkAns(userans)) {
                    score++;
                }
            } else {
                System.out.println("Invalid Answer.");
            }
        }

        executor.shutdown();
        System.out.println("Your score: " + score + "/" + questions.size());

        try {
            fileHandler.save("quiz_results.txt", "Quiz: " + title + ", Score: " + score);
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }
}
