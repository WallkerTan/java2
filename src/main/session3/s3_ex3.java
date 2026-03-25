package src.main.session3;

import java.util.List;
import java.util.Optional;
import src.main.session3.user.User;

public class s3_ex3 {
    public static void main(String[] args) {
        List<User> temp = user.createValidUsers();
        
        Optional<User> result = temp.stream().filter(e->e.name().equals("tan1")).findFirst();
        result.ifPresent(System.out::println);

    }
}
