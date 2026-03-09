package src.session2;

@FunctionalInterface
interface PasswordValidator {
    boolean isValid(String password);
}

public class s2_ex2 {
    public static void main(String[] args) {

        //Anonymous Class thông thường
        PasswordValidator validator = new PasswordValidator() {
            @Override
            public boolean isValid(String s) {
                return s.length() > 8;
            }
        };

        //lambda 
        PasswordValidator lamba = s->s.length()>8;
        System.out.println(validator.isValid("null"));
        System.out.println(lamba.isValid("123456789"));
    }
}
