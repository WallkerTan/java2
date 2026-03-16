package src.main.session3;

import java.util.ArrayList;
import java.util.List;

import src.main.session3.user.User;

public class s3_ex1 {
    public static void main(String[] args) {
        
        List<User> U = new ArrayList<>();

        user.User a = new User("tan", "a", true);
        user.User b = new User("tan2", "b", true);
        user.User c = new User("tan3", "c", true);

        U.add(a);
        U.add(b);
        U.add(c);
        U.forEach(System.out::println);
        //cách 2
        U.forEach(u -> {
            System.out.println(u.name() + " " + u.email() + " " + u.Status());
        });
    }
}
