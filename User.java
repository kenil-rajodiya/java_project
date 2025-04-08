package usermanagement;

import java.util.*;

public class User {
    String username;
    String password;
    List<Integer> scores = new ArrayList<>();
    private static Map<String, String> users = new HashMap<>();

    public User(String un, String pass) {
        this.username = un;
        this.password = pass;
    }

    public static boolean register(String un, String pass) throws UserAlreadyExistsException {
        if (users.containsKey(un)) {
            throw new UserAlreadyExistsException("Username Already exists");
        }
        users.put(un, pass);
        return true;
    }

    public static User login(String un, String pass) {
        String u = users.get(un);
        if (u != null && u.equals(pass)) {
            User a;
            a=new User(un,pass);
            return a;
        }
        return null;
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public void show() {
        System.out.println("Scores for " + this.username + ": " + scores);
    }
}
