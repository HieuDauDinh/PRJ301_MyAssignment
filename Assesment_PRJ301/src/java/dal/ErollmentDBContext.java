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
import model.Semester;
import model.Student;

/**
 *
 * @author Admin
 */
public class ErollmentDBContext extends DBContext {
    public static void main(String[] args) {
        ErollmentDBContext d = new ErollmentDBContext();
        List<Semester> list = d.getAllSemester();
        for (Semester semester : list) {
            System.out.println(semester.getSemID());
        }
    }
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

    public List<Semester> getAllSemester() {
        List<Semester> listSemester = new ArrayList();
        try {
            String sql = "SELECT [SemesterID]\n"
                    + "      ,[SemesterName]\n"
                    + "  FROM [Assignment_PRJ301].[dbo].[Semester]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Semester semes = new Semester(rs.getString("SemesterID"), rs.getString("SemesterName"));
                listSemester.add(semes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ErollmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSemester;
    }
}
