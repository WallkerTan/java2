package src.main.session3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import src.main.session3.user.User;

public class s3_ex5 {

    public static void main(String[] args) {

        List<User> A = user.createValidUsers();

        // 1. Cách rất cũ (Java 6 trở xuống) - anonymous class
        Collections.sort(A, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.name().length() - u2.name().length();
            }
        });

        System.out.println("Old style comparator:");
        System.out.println(A.subList(0, 3));


        // 2. Cách Java 8 - Lambda + Collections.sort
        Collections.sort(A, (u1, u2) -> u1.name().length() - u2.name().length());

        System.out.println("Lambda + Collections.sort:");
        System.out.println(A.subList(0, 3));


        // 3. Cách hiện đại hơn - Comparator.comparing
        A.sort(Comparator.comparingInt(u -> u.name().length()));

        System.out.println("List.sort + Comparator:");
        System.out.println(A.subList(0, 3));


        // 4. Cách Functional style - Stream
        List<User> sorted = A.stream()
                .sorted(Comparator.comparingInt(u -> u.name().length())).limit(3)
                .toList();

        System.out.println("Stream sorted:");
        System.out.println(sorted);
    }
}