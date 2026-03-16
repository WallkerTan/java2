package src.main.session1;

class User {
    private int age;

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am");
        }
        this.age = age;
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
public class s1_ex5 {

    public static void main(String[] args) {
        User u = new User();

        try {
            u.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chuong trinh tiep tuc");
    }
}