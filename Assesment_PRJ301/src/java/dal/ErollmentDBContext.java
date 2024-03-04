/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Erollment;
import model.Student;

/**
 *
 * @author Admin
 */
public class ErollmentDBContext extends DBContext {
   
    public List<Student> getStudentByGid(String gid) {
        List<Student> listStu = new ArrayList();
        try {
            String sql = "SELECT [eid]\n"
                    + "      ,[gid]\n"
                    + "      ,[stuid]\n"
                    + "  FROM [Assignment_PRJ301].[dbo].[Erollment]\n"
                    + "  WHERE gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, gid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStuid(rs.getString("stuid"));
                listStu.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStu;
    }
}
