package src.main.session3;

import java.util.HashSet;
import java.util.List;

import src.main.session3.user.User;

public class s3_ex4 {
    public static void main(String[] args) {
        List<User> l = user.createValidUsers();
        System.out.println(l.stream().map(User::name).distinct().toList());
        System.out.println(new HashSet<>(l));
    }
}
