package jdbcSumit;

import java.sql.*;
import java.util.Scanner;

public class StudentDetailsJDBC {

    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";  
        String password = "User@123";  
        
        return DriverManager.getConnection(url, username, password);
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
