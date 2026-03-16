package src.main.session4;

public class s4_ex4 {
    public static void main(String[] args) {
        
    }
    public static boolean checkpass(String pass){
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[.*@#$&!?/~`])[A-Za-z0-9.*@#$&!?/`]{8,}$";
        return pass.matches(regex);
    }
    
}
