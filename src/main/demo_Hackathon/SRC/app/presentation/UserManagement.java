package SRC.app.presentation;

import java.util.Scanner;
import SRC.app.business.UserBusiness;
import SRC.app.entity.User;

public class UserManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserBusiness business = new UserBusiness();

        while (true) {
            try {
                System.out.println("********************* QUẢN LÝ NGƯỜI DÙNG *********************");
                System.out.println("1. Hiển thị danh sách toàn bộ người dùng");
                System.out.println("2. Thêm mới người dùng");
                System.out.println("3. Cập nhật thông tin người dùng theo mã");
                System.out.println("4. Xóa người dùng theo mã");
                System.out.println("5. Tìm kiếm người dùng theo tên");
                System.out.println("6. Lọc danh sách người dùng ADMIN");
                System.out.println("7. Sắp xếp danh sách theo điểm đánh giá giảm dần");
                System.out.println("8. Thoát");
                System.out.print("Lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        business.getList();
                        break;

                    case 2:
                        while (true) {
                            try {
                                User user = new User();
                                business.addUser(user);

                                System.out.print("Tiếp tục thêm? (y/n): ");
                                String cont = sc.nextLine();
                                if (!cont.equalsIgnoreCase("y"))
                                    break;

                            } catch (Exception e) {
                                System.out.println("Lỗi nhập: " + e.getMessage());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Nhập ID cần cập nhật: ");
                        String updateId = sc.nextLine();
                        business.updateUser(updateId, sc);
                        break;

                    case 4:
                        System.out.print("Nhập ID cần xóa: ");
                        String deleteId = sc.nextLine();
                        business.deleteUser(deleteId);
                        break;

                    case 5:
                        System.out.print("Nhập tên cần tìm: ");
                        String name = sc.nextLine();
                        business.searchByName(name);
                        break;

                    case 6:
                        business.filterAdmin();
                        break;

                    case 7:
                        business.sortByScoreDesc();
                        break;

                    case 8:
                        System.out.println("Thoát chương trình");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }

            } catch (Exception e) {
                System.out.println("Lỗi chung: " + e.getMessage());
            }
        }
    }
}