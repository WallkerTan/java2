package src.session2;

class User {
    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}

@FunctionalInterface
interface UserProcessor {
    String process(User u);
}

class UserUtils {

    public static String convertToUpperCase(User u){
        return u.getUsername().toUpperCase();
    }

}



public class s2_ex6 {
    public static void main(String[] args) {
         // Method Reference
        UserProcessor processor = UserUtils::convertToUpperCase;

        User user = new User("nguyen");

        String result = processor.process(user);

        System.out.println(result);
    }
}
