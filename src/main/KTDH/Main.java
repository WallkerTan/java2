package KTDH;

import KTDH.entity.Account;
import KTDH.service.AccountService;
import KTDH.Utility.DbUtility;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    private static AccountService accountService = new AccountService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection conn = DbUtility.getConnection();
        if (conn == null) {
            System.out.println("Không thể kết nối database! Thoát chương trình.");
            return;
        }
        System.out.println("Kết nối thành công!\n");

        while (true) {
            showMenu();
            int choice = getIntInput("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    displayAllAccounts();
                    break;
                case 2:
                    addAccount();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    searchAccount();
                    break;
                case 6:
                    depositMoney();
                    break;
                case 7:
                    withdrawMoney();
                    break;
                case 8:
                    transferMoney();
                    break;
                case 0:
                    System.out.println("Cảm ơn đã sử dụng chương trình!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n========== MENU QUẢN LÝ TÀI KHOẢN ==========");
        System.out.println("1. Xem danh sách tài khoản");
        System.out.println("2. Thêm tài khoản mới");
        System.out.println("3. Cập nhật tài khoản");
        System.out.println("4. Xóa tài khoản");
        System.out.println("5. Tìm kiếm tài khoản theo ID");
        System.out.println("6. Nạp tiền");
        System.out.println("7. Rút tiền");
        System.out.println("8. Chuyển tiền");
        System.out.println("0. Thoát");
        System.out.println("============================================");
    }

    private static void displayAllAccounts() {
        accountService.displayAllAccounts();
    }

    private static void addAccount() {
        System.out.println("\n--- THÊM TÀI KHOẢN MỚI ---");
        System.out.print("Nhập AccountId: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nhập FullName: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nhập Balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        Account account = new Account(id, name, balance);
        if (accountService.addAccount(account)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Thêm tài khoản thất bại!");
        }
    }

    private static void updateAccount() {
        System.out.println("\n--- CẬP NHẬT TÀI KHOẢN ---");
        System.out.print("Nhập AccountId cần cập nhật: ");
        String id = scanner.nextLine().trim();

        Account existing = accountService.getAccountById(id);
        if (existing == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return;
        }

        System.out.print("Nhập tên mới (" + existing.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty())
            name = existing.getName();

        System.out.print("Nhập số dư mới (" + existing.getBalance() + "): ");
        String balanceStr = scanner.nextLine().trim();
        double balance =
                balanceStr.isEmpty() ? existing.getBalance() : Double.parseDouble(balanceStr);

        existing.setName(name);
        existing.setBalance(balance);

        if (accountService.updateAccount(existing)) {
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }

    private static void deleteAccount() {
        System.out.println("\n--- XÓA TÀI KHOẢN ---");
        System.out.print("Nhập AccountId cần xóa: ");
        String id = scanner.nextLine().trim();

        if (accountService.deleteAccount(id)) {
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Xóa tài khoản thất bại!");
        }
    }

    private static void searchAccount() {
        System.out.println("\n--- TÌM KIẾM TÀI KHOẢN ---");
        System.out.print("Nhập AccountId: ");
        String id = scanner.nextLine().trim();

        Account account = accountService.getAccountById(id);
        accountService.displayAccountInfo(account);
    }

    private static void depositMoney() {
        System.out.println("\n--- NẠP TIỀN ---");
        System.out.print("Nhập AccountId: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nhập số tiền: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (accountService.deposit(id, amount)) {
            System.out.println("Nạp tiền thành công!");
            Account updated = accountService.getAccountById(id);
            accountService.displayAccountInfo(updated);
        } else {
            System.out.println("Nạp tiền thất bại!");
        }
    }

    private static void withdrawMoney() {
        System.out.println("\n--- RÚT TIỀN ---");
        System.out.print("Nhập AccountId: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nhập số tiền: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (accountService.withdraw(id, amount)) {
            System.out.println("Rút tiền thành công!");
            Account updated = accountService.getAccountById(id);
            accountService.displayAccountInfo(updated);
        } else {
            System.out.println("Rút tiền thất bại!");
        }
    }

    private static void transferMoney() {
        System.out.println("\n--- CHUYỂN TIỀN ---");
        System.out.print("Nhập AccountId người gửi: ");
        String fromId = scanner.nextLine().trim();
        System.out.print("Nhập AccountId người nhận: ");
        String toId = scanner.nextLine().trim();
        System.out.print("Nhập số tiền: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (accountService.transfer(fromId, toId, amount)) {
            System.out.println("Chuyển tiền thành công!");
            Account fromAcc = accountService.getAccountById(fromId);
            Account toAcc = accountService.getAccountById(toId);
            System.out.println("Số dư mới - Người gửi: " + fromAcc.getBalance());
            System.out.println("Số dư mới - Người nhận: " + toAcc.getBalance());
        } else {
            System.out.println("Chuyển tiền thất bại!");
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
