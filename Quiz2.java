package quizsystem;

import fileoperations.forFileHandling;
import java.util.*;
import java.io.*;

public class Quiz2 extends Quiz {
    List<Question> questions;
    int penalty;
    forFileHandling fileHandler = new forFileHandling();

    public Quiz2(String title, String des, int penalty) {
        super(title, des);
        this.penalty = penalty;
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
        System.out.println("No time limit for this quiz. But wrong answers will reduce your score by " + this.penalty + " points.");

        for (Question q : questions) {
            System.out.println(q.que);
            for (int i = 0; i < q.ops.size(); i++) {
                System.out.println((i + 1) + ". " + q.ops.get(i));
            }
            System.out.println("Enter index of your answer: ");
            int ansidx = sc.nextInt() - 1;

            if (ansidx >= 0 && ansidx < q.ops.size()) {
                String userans = q.ops.get(ansidx);
                if (q.checkAns(userans)) {
                    score++;
                } else {
                    score -= penalty;
                }
            } else {
                System.out.println("Invalid Answer.");
            }
        }

        System.out.println("Your final score: " + score);

        try {
            fileHandler.save("quiz_results.txt", "Quiz: " + title + ", Score: " + score);
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }
}
