package SRC.app.business;

import java.util.*;
import SRC.app.entity.User;

public class UserBusiness {
    private static List<User> users = new ArrayList<>();

    // 1. Hiển thị danh sách
    public void getList() {
        try {
            if (users.isEmpty()) {
                System.out.println("Danh sách rỗng");
                return;
            }

            users.forEach(User::toString);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 2. Thêm user
    public void addUser(User user) {
        try {
            boolean exists = users.stream()
                    .anyMatch(u -> u.getID().equals(user.getID()));

            if (exists) {
                System.out.println("Mã người dùng đã tồn tại");
                return;
            }

            users.add(user);
            System.out.println("Thêm thành công");

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 3. Tìm theo ID (dùng Optional)
    public Optional<User> findById(String id) {
        return users.stream()
                .filter(u -> u.getID().equals(id))
                .findFirst();
    }

    // 4. Cập nhật user
    public void updateUser(String id, Scanner sc) {
        try {
            Optional<User> opt = findById(id);

            if (opt.isEmpty()) {
                System.out.println("Mã người dùng không tồn tại trong hệ thống");
                return;
            }

            User u = opt.get();

            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa tuổi");
            System.out.println("4. Sửa score");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    u.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập tuổi mới: ");
                    int age = Integer.parseInt(sc.nextLine());
                    if (age < 18) {
                        System.out.println("Tuổi phải >= 18");
                        return;
                    }
                    u.setAge(age);
                    break;
                case 4:
                    System.out.print("Nhập score: ");
                    double score = Double.parseDouble(sc.nextLine());
                    if (score > 10) {
                        System.out.println("Score tối đa 10");
                        return;
                    }
                    u.setScore(score);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

            System.out.println("Cập nhật thành công");

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 5. Xóa user
    public void deleteUser(String id) {
        try {
            int sizeBefore = users.size();

            users.removeIf(u -> u.getID().equals(id));

            if (users.size() == sizeBefore) {
                System.out.println("Mã người dùng không tồn tại trong hệ thống");
            } else {
                System.out.println("Xóa thành công");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 6. Tìm theo tên
    public void searchByName(String name) {
        try {
            List<User> result = users.stream()
                    .filter(u -> u.getName().toLowerCase().contains(name.toLowerCase()))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Không tìm thấy");
                return;
            }

            
            result.forEach(User::toString);
            System.out.println("Tổng: " + result.size());

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 7. Lọc ADMIN
    public void filterAdmin() {
        try {
            List<User> result = users.stream()
                    .filter(u -> u.getRole().equalsIgnoreCase("ADMIN"))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Không có ADMIN");
                return;
            }

            result.forEach(User::toString);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // 8. Sắp xếp theo score giảm dần
    public void sortByScoreDesc() {
        try {
            users.stream()
                    .sorted((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()))
                    .forEach(User::toString);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}