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
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class TimeSlotDBContext extends DBContext {

    public TimeSlot getTimeSlotByTid(int tid) {
        try {
            String sql = "SELECT [Tid]\n"
                    + "      ,[TimeStart]\n"
                    + "      ,[TimeEnd]\n"
                    + "  FROM [dbo].[TimeSlot]\n"
                    + "  Where Tid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                TimeSlot r = new TimeSlot(rs.getInt("Tid"), rs.getTime("TimeStart"), rs.getTime("TimeEnd"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

