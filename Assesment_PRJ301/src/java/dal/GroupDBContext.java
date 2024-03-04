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
import model.Group;

/**
 *
 * @author Admin
 */
public class GroupDBContext extends DBContext {

    public Group getGroupByGid(String gid) {
        SubjectDBContext sub = new SubjectDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        try {
            String sql = "SELECT [gid]\n"
                    + "      ,[gname]\n"
                    + "      ,[Subid]\n"
                    + "      ,[PIC]\n"
                    + "  FROM [dbo].[Group] Where gid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, gid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getString("gid"));
                g.setGname(rs.getString("gname"));
                String subid = rs.getString("Subid");
                g.setSubid(sub.getSubBySubid(subid));
                String lecid = rs.getString("PIC");
                g.setLid(lec.getLecByLid(lecid));               
                return g;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
