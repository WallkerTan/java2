package src.main.session3;

import java.util.ArrayList;
import java.util.List;

public class user {
    static record User(String name, String email, boolean Status) {
    };

    public static List<User> createValidUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User("tan1011111111", "tan10@gmail.com", true));
        users.add(new User("tan1", "tan1@gmail.com", true));
        users.add(new User("tan21", "tan2@gmail.com", true));
        users.add(new User("tan311", "tan3@gmail.com", true));
        users.add(new User("tan4111", "tan4@gmail.com", true));
        users.add(new User("tan51111", "tan5@gmail.com", true));
        users.add(new User("tan411111", "tan4@gmail.com", true));
        users.add(new User("tan3111111", "tan3@gmail.com", true));
        users.add(new User("tan21111111", "tan3@gmail.com", true));
        users.add(new User("tan111111111", "tan3@gmail.com", true));

        return users;
    }
}
