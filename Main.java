public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Add a student
        Student student = new Student(1, "John Doe", "Computer Science");
        studentDAO.addStudent(student);

        // Get all students
        List<Student> students = studentDAO.getStudents();
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Course: " + s.getCourse());
        }
    }
}
