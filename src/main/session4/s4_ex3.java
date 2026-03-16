package src.main.session4;

public class s4_ex3 {
    public static void main(String[] args) {
        
    }
    public static boolean checkemail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,5}$";
        return email.matches(regex);
    }
}
