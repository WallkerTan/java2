package src.session1;

import java.io.IOException;
import java.time.LocalDate;

class User {
    private String name;
    private int age;

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
public class s1_ex6 {
    
    public static void logError(String msg) {
        System.out.println("[ERROR] " + LocalDate.now() + " " + msg);
    }

    public static void saveToFile() throws IOException {
        throw new IOException("Loi ghi file");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {
        User u = new User();

        try {
            u.setAge(-1);
        } catch (InvalidAgeException e) {
            logError(e.getMessage());
        }

        try {
            processUserData();
        } catch (IOException e) {
            logError("Khong luu duoc file");
        }

        if (u.getName() != null) {
            System.out.println(u.getName());
        }

        System.out.println("Chuong trinh tiep tuc");
    }

}
