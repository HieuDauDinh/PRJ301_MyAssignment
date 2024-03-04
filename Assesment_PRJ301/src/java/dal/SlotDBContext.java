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
import model.Slot;

/**
 *
 * @author Admin
 */
public class SlotDBContext extends DBContext {

    public static void main(String[] args) {
        SlotDBContext slot = new SlotDBContext();
        int s = slot.getAllSlot().size();
        System.out.println(s);
    }

    public List<Slot> getAllSlot() {
        List<Slot> list = new ArrayList();
        String sql = "SELECT [slotid]\n"
                + "      ,[Slot]\n"
                + "  FROM [Assignment_PRJ301].[dbo].[Slot]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Slot s = new Slot(rs.getInt("slotid"),
                        rs.getString("Slot"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Slot getSlotBySlotId(int slotid) {
        List<Slot> list = new ArrayList();
        try {
            String sql = "SELECT [slotid]\n"
                    + "      ,[Slot]\n"
                    + "  FROM [Assignment_PRJ301].[dbo].[Slot] Where slotid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, slotid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Slot s = new Slot(rs.getInt("slotid"), rs.getString("Slot"));
                return s;
            }
        } catch (SQLException ex) {

        }
        return null;

    }
}
