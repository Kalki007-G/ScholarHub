package in.student.dao;

import java.sql.*;
import java.util.*;
import in.student.model.Student;

public class StudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Gpk@2509"; // Your password

    private static final String INSERT = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM students";
    private static final String DELETE = "DELETE FROM students WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM students WHERE id=?";
    private static final String UPDATE = "UPDATE students SET name=?, email=?, course=? WHERE id=?";

    // ✅ Load MySQL driver once
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL JDBC driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertStudent(Student s) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
        }
    }

    public List<Student> selectAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course")));
            }
        }
        return students;
    }

    public Student selectStudent(int id) throws SQLException {
        Student student = null;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course"));
            }
        }
        return student;
    }

    public boolean updateStudent(Student s) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteStudent(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
