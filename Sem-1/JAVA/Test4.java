package jdbcSumit;

import java.sql.*;
import java.util.Scanner;

public class Test4 {

    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";  
        String password = "User@123";  
        
        return DriverManager.getConnection(url, username, password);
    }

    
    public static void createDatabaseAndTable() {
        String createDBQuery = "CREATE DATABASE IF NOT EXISTS University";
        String createTableQuery = """
            CREATE TABLE IF NOT EXISTS Students (
                student_id INT PRIMARY KEY,
                first_name VARCHAR(50),
                last_name VARCHAR(50),
                age INT,
                major VARCHAR(100)
            )
        """;
        String insertSampleDataQuery = """
            INSERT INTO Students (student_id, first_name, last_name, age, major)
            VALUES 
                (1, 'sumit', 'mahankale', 20, 'C1omputer Science'),
                (2, 'vedant', 'shinde', 22, 'Mathematics'),
                (3, 'pratik', 'choure', 21, 'Physics')
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
           
            stmt.executeUpdate(createDBQuery);
            stmt.executeUpdate("USE University");

           
            stmt.executeUpdate(createTableQuery);

                        stmt.executeUpdate(insertSampleDataQuery);

            System.out.println("Database and table created, sample data inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void createStoredProcedure() {
        String procedureQuery = """
            DELIMITER $$

            CREATE PROCEDURE getStudentById(IN studentId INT)
            BEGIN
                SELECT student_id, first_name, last_name, age, major
                FROM Students
                WHERE student_id = studentId;
            END $$

            DELIMITER ;
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(procedureQuery);
            System.out.println("Stored procedure 'getStudentById' created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void getStudentById(int studentId) {
        String sql = "{CALL getStudentById(?)}";

        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            
            stmt.setInt(1, studentId);

            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   
                    int id = rs.getInt("student_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    int age = rs.getInt("age");
                    String major = rs.getString("major");

                    System.out.println("Student ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Age: " + age);
                    System.out.println("Major: " + major);
                } else {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
       

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to retrieve details: ");
        int studentId = scanner.nextInt();
        
       
        getStudentById(studentId);
        
        scanner.close();
    }
}
