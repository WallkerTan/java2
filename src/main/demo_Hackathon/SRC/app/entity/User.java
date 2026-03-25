package SRC.app.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    private String userID;
    private String userName;
    private int age;
    private String role;
    private double score;
    private static int count = 1;
    private static Queue<Integer> tempID = new LinkedList<>();

    public String toString(){
        return "id: "+userID+" role: "+role+" name: "+userName+" age: "+age+" score: "+score;
    }

    public String getName() {
        return this.userName;
    }

    public void setName(String name){
        this.userName = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setScore(double score){
        this.score = score;
    }

    public String getID() {
        return this.userID;
    }

    public int getAge() {
        return this.age;
    }

    public double getScore() {
        return this.score;
    }

    public String getRole() {
        return this.role;
    }

    public void delete(int oldID) {
        tempID.add(oldID);
    }

    public User(String name, int age, int role) {
        int z = tempID.isEmpty() ? count : tempID.peek();
        if (tempID.isEmpty()) {
            count++;
        } else {
            tempID.poll();
        }

        this.userID = role == 1 ? "AD-" + z : "U-" + z;
        this.role = role == 1 ? "userBusiness" : "user";
        this.userName = name;
        this.age = age;
        this.score = 0;
    }

    public User() {
        int z = tempID.isEmpty() ? count : tempID.peek();
        if (tempID.isEmpty()) {
            count++;
        } else {
            tempID.poll();
        }


        this.userName = "accClone-" + z;
        this.userID = "U-" + z;
        this.role = "user";
        this.age = 18;
        this.score = 0;
    }

    protected void setID(int role) {
        if (role == 1) {
            this.userID = "AD-" + count;
            this.count++;
        } else {
            this.userID = "U-" + count;
            this.count++;
        }
    }

}
