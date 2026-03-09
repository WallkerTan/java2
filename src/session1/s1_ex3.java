package src.session1;

public class s1_ex3 {
    static class User {
        private int age;

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Tuoi khong the am");
            }
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        User u = new User();
        u.setAge(20);
        System.out.println("Age: " + u.getAge());
    }
}
