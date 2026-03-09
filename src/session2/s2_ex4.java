package src.session2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class User {

    private String username;

    // Constructor (dùng cho User::new)
    public User() {
        this.username = "default_user";
    }

    // Constructor có tham số
    public User(String username) {
        this.username = username;
    }

    // Getter (dùng cho User::getUsername)
    public String getUsername() {
        return username;
    }

    // Method in thông tin
    public void printInfo() {
        System.out.println("Username: " + username);
    }

}

public class s2_ex4 {
    public static void main(String[] args) {
        
        // 1. Constructor reference
        Supplier<User> createUser = User::new;

        User u = createUser.get();


        // 2. Instance method reference (class)
        Function<User,String> getName = User::getUsername;

        System.out.println(getName.apply(u));


        // 3. Instance method reference (object)
        Consumer<String> printer = System.out::println;

        printer.accept("Hello Java");
    }
}
