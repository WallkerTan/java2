package src.main.session3;

import java.util.ArrayList;
import java.util.List;

import src.main.session3.user.User;

public class s3_ex2 {
    public static void main(String[] args) {
        List<User> A = user.createValidUsers();

       List<User> z =  A.stream().filter(t->t.email().contains("@gmail.com")).toList();
    
       z.forEach(t->{
        System.out.println(t);
       });
    }
}
