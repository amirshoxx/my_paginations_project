package com.example.jdbs;

import com.example.jdbs.dto.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db{
    static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> getStudents() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from my_table");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String firstName = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Student student = new Student(id,firstName, age);
            students.add(student);
        }
        return students;
    }


    public static Student getOneStudent(Long userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from my_table where id='" + userId + "'");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String firstName = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Student student = new Student(id,firstName, age);
            students.add(student);
        }
        return students.get(0);
    }

    public static String deleteStudent(Long userId) throws SQLException{
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("DELETE FROM my_table WHERE id=" + userId);
        if (rowsAffected > 0) {
            return "Deleted";
        } else {
            return "Student not found";
        }
    }


    public static void saveStudent(StudentDto student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into my_table (name, age) values (?, ?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.executeUpdate();
    }

    public static void updateStudent(Long id,StudentDto student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update my_table set name = ?, age = ? where id = "+id);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.executeUpdate();
    }
    public static List<Student> searchStudents(String name) throws SQLException {
        String query = "SELECT * FROM my_table WHERE (name LIKE ? OR ? IS NULL)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Student> students = new ArrayList<>();
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String firstName = resultSet.getString("name");
                    int studentAge = resultSet.getInt("age");
                    Student student = new Student(id, firstName, studentAge);
                    students.add(student);
                }
                return students;
            }
        }
    }
    public static void updateAgePlus(Long id,Integer age) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update my_table set age = age+1 where id = "+id);
        preparedStatement.setInt(1, age );
        preparedStatement.executeUpdate();
    }
    public static void updateAgeMinus(Long id,Integer age) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update my_table set age = age-1 where id = "+id);
        preparedStatement.setInt(1, age );
        preparedStatement.executeUpdate();
    }



}
