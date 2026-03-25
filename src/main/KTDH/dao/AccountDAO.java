// KTDH/dao/AccountDAO.java
package KTDH.dao;

import KTDH.entity.Account;
import KTDH.Utility.DbUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    // Lấy tất cả tài khoản
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";

        try (Connection conn = DbUtility.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Account acc = new Account();
                acc.setAccountId(rs.getString("AccountId"));
                acc.setName(rs.getString("FullName"));
                acc.setBalance(rs.getDouble("Balance"));
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Lấy tài khoản theo ID
    public Account getAccountById(String accountId) {
        String sql = "SELECT * FROM account WHERE AccountId = ?";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Account acc = new Account();
                acc.setAccountId(rs.getString("AccountId"));
                acc.setName(rs.getString("FullName"));
                acc.setBalance(rs.getDouble("Balance"));
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm tài khoản mới
    public boolean addAccount(Account account) {
        String sql = "INSERT INTO account (AccountId, FullName, Balance) VALUES (?, ?, ?)";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, account.getAccountId());
            pstmt.setString(2, account.getName());
            pstmt.setDouble(3, account.getBalance());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật tài khoản
    public boolean updateAccount(Account account) {
        String sql = "UPDATE account SET FullName = ?, Balance = ? WHERE AccountId = ?";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, account.getName());
            pstmt.setDouble(2, account.getBalance());
            pstmt.setString(3, account.getAccountId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa tài khoản
    public boolean deleteAccount(String accountId) {
        String sql = "DELETE FROM account WHERE AccountId = ?";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Nạp tiền
    public boolean deposit(String accountId, double amount) {
        if (amount <= 0)
            return false;

        String sql = "UPDATE account SET Balance = Balance + ? WHERE AccountId = ?";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, amount);
            pstmt.setString(2, accountId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Rút tiền
    public boolean withdraw(String accountId, double amount) {
        if (amount <= 0)
            return false;

        // Kiểm tra số dư
        Account acc = getAccountById(accountId);
        if (acc == null || acc.getBalance() < amount)
            return false;

        String sql = "UPDATE account SET Balance = Balance - ? WHERE AccountId = ?";

        try (Connection conn = DbUtility.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, amount);
            pstmt.setString(2, accountId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Chuyển tiền giữa 2 tài khoản
    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        if (amount <= 0)
            return false;

        try (Connection conn = DbUtility.getConnection()) {
            // Bắt đầu transaction
            conn.setAutoCommit(false);

            // Kiểm tra số dư tài khoản gửi
            Account fromAcc = getAccountById(fromAccountId);
            if (fromAcc == null || fromAcc.getBalance() < amount) {
                conn.rollback();
                return false;
            }

            // Trừ tiền tài khoản gửi
            String sqlWithdraw = "UPDATE account SET Balance = Balance - ? WHERE AccountId = ?";
            PreparedStatement pstmtWithdraw = conn.prepareStatement(sqlWithdraw);
            pstmtWithdraw.setDouble(1, amount);
            pstmtWithdraw.setString(2, fromAccountId);
            pstmtWithdraw.executeUpdate();

            // Cộng tiền tài khoản nhận
            String sqlDeposit = "UPDATE account SET Balance = Balance + ? WHERE AccountId = ?";
            PreparedStatement pstmtDeposit = conn.prepareStatement(sqlDeposit);
            pstmtDeposit.setDouble(1, amount);
            pstmtDeposit.setString(2, toAccountId);
            pstmtDeposit.executeUpdate();

            // Commit transaction
            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
