package src.main.session2;

class User1 {
    private String User1name;

    public User1(String User1name) {
        this.User1name = User1name;
    }

    public String getUser1name() {
        return User1name;
    }
}

@FunctionalInterface
interface User1Processor {
    String process(User1 u);
}

class User1Utils {

    public static String convertToUpperCase(User1 u) {
        return u.getUser1name().toUpperCase();
    }

}

public class s2_ex6 {
    public static void main(String[] args) {

        // cách binhg thường
        // User1Processor processor = new User1Processor() {
        // public String process(User1 u){
        // return User1Utils.convertToUpperCase(u);
        // }
        // };
        // Method Reference
        User1Processor processor = User1Utils::convertToUpperCase;
        User1 User1 = new User1("nguyen");

        String result = processor.process(User1);

        System.out.println(result);
    }
}
