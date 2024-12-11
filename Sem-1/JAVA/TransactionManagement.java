
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class  TransactionManagement{

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Spring";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Sunita@8208";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Establish connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Step 2: Disable auto-commit mode
            connection.setAutoCommit(false);

            // Step 3: Perform operations within a transaction
            // Transfer 100 units from account 1 to account 2
            withdraw(connection, 1, 100);
            deposit(connection, 2, 100);

            // Step 4: Commit the transaction
            connection.commit();
            System.out.println("Transaction committed successfully.");

        } catch (SQLException e) {
            // Step 5: Handle exceptions and roll back the transaction
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to an error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            // Step 6: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }

    private static void withdraw(Connection connection, int accountId, double amount) throws SQLException {
        String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(withdrawSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Withdrawal failed, account not found: " + accountId);
            }
        }
    }

    private static void deposit(Connection connection, int accountId, double amount) throws SQLException {
        String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(depositSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deposit failed, account not found: " + accountId);
            }
        }
    }
}