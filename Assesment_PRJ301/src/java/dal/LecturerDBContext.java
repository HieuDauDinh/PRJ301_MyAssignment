/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Lecturer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LecturerDBContext extends DBContext {
 
    public Lecturer getLecByLid(String lid) {
        try {
            String sql = "SELECT [lid]\n"
                    + "      ,[lname]\n"
                    + "      ,[dob]\n"
                    + "      ,[PhoneNum]\n"
                    + "      ,[IDCard]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Major]\n"
                    + "      ,[gender]\n"
                    + "  FROM [dbo].[Lecturer]\n"
                    + "  Where lid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Lecturer l = new Lecturer();
                l.setLid(rs.getString("lid"));
                l.setLname(rs.getString("lname"));
                l.setDob(rs.getDate("dob"));
                l.setPhoneNumber(rs.getString("PhoneNum"));
                l.setIdCard(rs.getString("IDCard"));
                l.setAddress(rs.getString("Address"));
                l.setEmail(rs.getString("Email"));
                l.setMajor(rs.getString("Major"));
                l.setGender(rs.getBoolean("gender"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
