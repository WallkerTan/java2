package src.main.session4;

import java.util.ArrayList;
import java.util.List;

class User{
    private String name;
    private int age;
    private String email;
    private boolean Status;


    public User(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
        this.Status = true;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

    public void setActive(boolean z){
        this.Status = z;
    }


    @Override
    public String toString(){
        return name+"\n"+age+"\n"+email;
    }
}

class Admin extends User{
    // có thể xóa ng dùng , ng điều hành
    public Admin(String name, int age, String email){
        super(name, age, email);
    }

    public void deleteUser(List<User> L,User u){
        L.remove(u);
    }

}


class moderator extends User{

    public moderator(String name, int age, String email){
        super(name, age, email);
    }

    public void LookUser(User u){
        u.setActive(false);
    }

    public void UnLookUser(User u){
        u.setActive(true);
    }
}

class classicUsser extends User{
    
    public classicUsser(String name, int age, String email){
        super(name, age, email);
    }
}


public class s4_ex5 {
        public static void main(String[] args) {
            List<classicUsser> CsicU = new ArrayList<>();
            User mo = new moderator("moderator", 25, "moderator@gmail.com");
            User admin = new Admin("ad", 30, "admin@gmail.com");
            System.out.println(admin.toString());
            System.out.println(mo.toString());
        }   
}
