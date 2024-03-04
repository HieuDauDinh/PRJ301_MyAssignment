/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

public class getAllStudent extends DBContext{
    public static void main(String[] args) {
        getAllStudent get = new getAllStudent();
        int size = get.list().size();
        System.out.println(size);
    }
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT [stuid]\n"
                    + "      ,[name]\n"
                    + "      ,[dob]\n"
                    + "      ,[Gender]\n"
                    + "      ,[Semester]\n"
                    + "      ,[PhoneNum]\n"
                    + "      ,[IDCard]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Major]\n"
                    + "  FROM Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStuid(rs.getString("stuid"));
                student.setName(rs.getString("name"));
                student.setDob(rs.getDate("dob"));
                student.setGender(rs.getBoolean("Gender"));            
                student.setSemester(rs.getInt("Semester"));
                student.setPhoneNumber(rs.getString("PhoneNum"));
                student.setIdCard(rs.getString("IDCard"));
                student.setAddress(rs.getString("Address"));
                student.setEmail(rs.getString("Email"));
                student.setMajor(rs.getString("Major"));
                student.setDob(rs.getDate("dob"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }
}
