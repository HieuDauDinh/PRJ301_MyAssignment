/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentDBContext extends DBContext {

    public Student getStudentByIDd(String id) {
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
                    + "  FROM [Assignment_PRJ301].[dbo].[Student]\n"
                    + "  Where stuid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setStuid(rs.getString("stuid"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setPhoneNumber(rs.getString("PhoneNum"));
                s.setIdCard(rs.getString("IDCard"));
                s.setAddress(rs.getString("Address"));
                s.setEmail(rs.getString("Email"));
                s.setMajor(rs.getString("Major"));
                s.setSemester(rs.getInt("Semester"));
                s.setGender(rs.getBoolean("Gender"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
