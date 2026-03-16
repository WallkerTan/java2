package src.main.session1;

import java.util.Scanner;

public class s1_ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap tong so nguoi: ");
            int total = sc.nextInt();

            System.out.print("Nhap so nhom: ");
            int groups = sc.nextInt();

            int result = total / groups;
            System.out.println("Moi nhom: " + result + " nguoi");
        }
        catch (ArithmeticException e) {
            System.out.println("Khong the chia cho 0");
        }

        System.out.println("Chuong trinh tiep tuc");
        sc.close();
    }
}
