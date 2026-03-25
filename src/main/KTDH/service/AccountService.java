// KTDH/service/AccountService.java
package KTDH.service;

import KTDH.dao.AccountDAO;
import KTDH.entity.Account;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountDAO.getAccountById(accountId);
    }

    public boolean addAccount(Account account) {
        // Validate
        if (account.getAccountId() == null || account.getAccountId().trim().isEmpty()) {
            System.out.println("AccountId không được để trống!");
            return false;
        }

        if (account.getName() == null || account.getName().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            return false;
        }

        if (account.getBalance() < 0) {
            System.out.println("Số dư không được âm!");
            return false;
        }

        // Kiểm tra trùng ID
        Account existing = accountDAO.getAccountById(account.getAccountId());
        if (existing != null) {
            System.out.println("AccountId đã tồn tại!");
            return false;
        }

        return accountDAO.addAccount(account);
    }

    public boolean updateAccount(Account account) {
        if (account.getAccountId() == null || account.getAccountId().trim().isEmpty()) {
            System.out.println("AccountId không hợp lệ!");
            return false;
        }
        return accountDAO.updateAccount(account);
    }

    public boolean deleteAccount(String accountId) {
        Account acc = accountDAO.getAccountById(accountId);
        if (acc == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return false;
        }
        return accountDAO.deleteAccount(accountId);
    }

    public boolean deposit(String accountId, double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền nạp phải lớn hơn 0!");
            return false;
        }
        return accountDAO.deposit(accountId, amount);
    }

    public boolean withdraw(String accountId, double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0!");
            return false;
        }

        Account acc = accountDAO.getAccountById(accountId);
        if (acc == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return false;
        }

        if (acc.getBalance() < amount) {
            System.out.println("Số dư không đủ! Số dư hiện tại: " + acc.getBalance());
            return false;
        }

        return accountDAO.withdraw(accountId, amount);
    }

    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0!");
            return false;
        }

        if (fromAccountId.equals(toAccountId)) {
            System.out.println("Không thể chuyển tiền cho chính mình!");
            return false;
        }

        return accountDAO.transfer(fromAccountId, toAccountId, amount);
    }

    public void displayAccountInfo(Account account) {
        if (account == null) {
            System.out.println("Không tìm thấy thông tin tài khoản!");
        } else {
            System.out.println(account);
        }
    }

    public void displayAllAccounts() {
        List<Account> accounts = getAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Chưa có tài khoản nào!");
        } else {
            System.out.println("\n=== DANH SÁCH TÀI KHOẢN ===");
            for (Account acc : accounts) {
                System.out.println(acc);
            }
            System.out.println("============================\n");
        }
    }
}
