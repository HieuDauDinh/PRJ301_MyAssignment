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
import model.Assessment;
import model.Exam;
import model.Grade;
import model.Student;

/**
 *
 * @author Admin
 */
public class GradeDBContext extends DBContext {
    public static void main(String[] args) {
        GradeDBContext gr = new GradeDBContext();
        List<Grade> l = gr.getGradeByStuidAndSubid("S0001", "PRJ301");
        for (Grade grade : l) {
            System.out.println(grade.getEid().getAid().getWeight());
        }
        System.out.println(gr.getGradeByStuidAndSubid("S0001", "PRJ301").size());
    }
    public List<Grade> getGradeByStuidAndSubid(String sid, String subid) {
        List<Grade> list = new ArrayList<>();
        SubjectDBContext sub = new SubjectDBContext();
        StudentDBContext student = new StudentDBContext();
        try {
             String sql = "SELECT  a.aid, a.name, a.weight, a.suid, e.start, e.[end], g.stuid, g.score, g.comment"
                + " FROM Assessment a INNER JOIN Exam e ON a.aid = e.aid\n"
                + "							INNER JOIN Grade g ON g.eid = e.eid\n"
                + "							Where g.stuid = ? AND a.suid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid);
            stm.setString(2, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assessment ass = new Assessment();
                Exam ex = new Exam();
                Grade gd = new Grade();
                
                String subids = rs.getString("suid");
                String studentid = rs.getString("stuid");
                ass.setSuid(sub.getSubBySubid(subids));
                ass.setName(rs.getString("name"));
                ass.setAid(rs.getString("aid"));
                ass.setWeight(rs.getDouble("weight"));
                
                ex.setEnd(rs.getDate("start"));
                ex.setStart(rs.getDate("end"));
                ex.setAid(ass);
                gd.setEid(ex);
                gd.setComment(rs.getString("comment"));
                gd.setScore(rs.getDouble("score"));
                gd.setStuid(student.getStudentByIDd(studentid));

                list.add(gd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list.isEmpty()) return null;
        return list;
    }
}
