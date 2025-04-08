package quizsystem;

import java.util.List;

public class Question {
    String que;
    List<String> ops;
    String ans;

    public Question(String q, List<String> opts, String a) {
        this.que = q;
        this.ops = opts;
        this.ans = a;
    }

    public boolean checkAns(String a) {
        return this.ans.equals(a);
    }
}
