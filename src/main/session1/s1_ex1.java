package src.main.session1;

import java.util.Scanner;

public class s1_ex1 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Nhập năm sinh: ");
                String input = sc.nextLine();

                int birthYear = Integer.parseInt(input);
                int age = 2026 - birthYear;

                System.out.println("Tuổi: " + age);
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ! Nhập số.");
            } finally {
                sc.close();
                System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            }
        }
}