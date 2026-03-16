package src.main.session4;

import java.util.Scanner;

public class s4_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s1_login(s);
    }
    public static boolean s1_login(String name){
        return name.contains(" ");
    }
}
