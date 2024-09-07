import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:odbc:StudentDB", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (Name, Course) VALUES (?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getCourse());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
 Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("Course"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error getting students: " + e.getMessage());
        }
        return students;
    }
}



