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
import model.Room;

/**
 *
 * @author Admin
 */
public class RoomDBContext extends DBContext {

    public Room getRoomByRid(String rid) {
        try {
            String sql = "SELECT [rid]\n"
                    + "      ,[rname]\n"
                    + "      ,[rbuilding]\n"
                    + "  FROM [dbo].[Room]\n"
                    + "  Where rid = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, rid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Room r = new Room(rs.getString("rid"), rs.getString("rname"), rs.getString("rbuilding"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

