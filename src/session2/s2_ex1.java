package src.session2;

class user {

    String name;
    
    public user(String name){
        this.name = name;
    }

    boolean isAdmin(){
        return false;
    }

    @Override
    public String toString(){
        return name+".";
    }
}

class Admin extends user{
    public Admin(String name){
        super(name);
    }

    @Override
    public boolean isAdmin(){
        return true;
    }
}

public class s2_ex1 {
    public static void main(String[] args) {
        user u1 = new user("hung");
        user u2 = new Admin("Tan");

        System.out.println(u1+"."+u1.isAdmin());
        System.out.println(u2+"."+u2.isAdmin());
        
    }
}
