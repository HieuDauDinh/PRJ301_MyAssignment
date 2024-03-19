/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import model.Subject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Assessment;

public class SubjectDBContext extends DBContext {
    public static void main(String[] args) {
        SubjectDBContext sub = new SubjectDBContext();
        System.out.println(sub.getAssesmentBySubid("PRJ301").size());
    }
    public Subject getSubBySubid(String sid) {
        try {
            String sql = "SELECT [subid]\n"
                    + "      ,[subname]\n"
                    + "      ,[term]\n"
                    + "      ,[credit]\n"
                    + "      ,[Prerequisite]\n"
                    + "      ,[department]\n"
                    + "  FROM [dbo].[Subject]\n"
                    + "  Where subid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Subject sub = new Subject();
                sub.setSubid(rs.getString("subid"));
                sub.setSubname(rs.getString("subname"));
                sub.setTerm(rs.getInt("term"));
                sub.setCredit(rs.getInt("credit"));
                sub.setPrerequisite(rs.getString("Prerequisite"));
                sub.setDepartment(rs.getString("department"));

                return sub;
            }
        } catch (SQLException ex) {

        }
        return null;

    }

    public List<Assessment> getAssesmentBySubid(String subid) {
        List<Assessment> list = new ArrayList<>();
        
        try {
            String sql = "SELECT [aid]\n"
                    + "      ,[suid]\n"
                    + "      ,[weight]\n"
                    + "      ,[name]\n"
                    + "  FROM [Assignment_PRJ301].[dbo].[Assessment]\n"
                    + "  Where [suid] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assessment ass = new Assessment();
                ass.setAid(rs.getString("aid"));
                ass.setName(rs.getString("name"));
                ass.setSuid(getSubBySubid(rs.getString("suid")));
                ass.setWeight(rs.getDouble("weight"));
                list.add(ass);
            }
            
        } catch (SQLException ex) {

        }
        return list;

    }
}
