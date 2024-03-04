/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import model.Subject;
import java.sql.*;


public class SubjectDBContext extends DBContext{

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
}
