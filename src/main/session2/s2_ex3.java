package src.main.session2;

@FunctionalInterface
interface Authenticatable {

    String getPass();

    default boolean check(String password){
        return !password.trim().isEmpty();
    }

    static String encrypt(String rawPassword){
        return rawPassword.concat("dhfhsdh");
    }
}

public class s2_ex3 {
    public static void main(String[] args) {
        Authenticatable temp = ()->"123456789";
        System.out.println(temp.getPass());
        System.out.println(temp.check("123456789"));
        System.out.println(Authenticatable.encrypt("123456789"));
    }
}
