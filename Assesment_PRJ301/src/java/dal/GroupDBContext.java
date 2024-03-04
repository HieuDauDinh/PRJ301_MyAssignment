/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.Slot;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class GroupDBContext extends DBContext {
    public static void main(String[] args) {
        GroupDBContext db = new GroupDBContext();
        int s = db.getSessionByGid("1").size();
        System.out.println(s);
    }
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
    
    

    public List<Session> getSessionByGid(String grid) {
        List<Session> ses = new ArrayList<>();
        String sql = "SELECT [seid]\n"
                + "      ,[gid]\n"
                + "      ,[lid]\n"
                + "      ,[roomid]\n"
                + "      ,[tid]\n"
                + "      ,[isTaken]\n"
                + "      ,[slotid]\n"
                + "      ,[subid]\n"
                + "      ,[date]\n"
                + "  FROM [Assignment_PRJ301].[dbo].[Session]\n"
                + "  Where gid = ?";
        
        List<Session> list = new ArrayList();
        GroupDBContext group = new GroupDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        TimeSlotDBContext tslot = new TimeSlotDBContext();
        RoomDBContext room = new RoomDBContext();
        SlotDBContext slot = new SlotDBContext();
        SubjectDBContext subject = new SubjectDBContext();
      
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, grid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("seid");
                String gid = rs.getString("gid");
                String lid = rs.getString("lid");
                int tid = rs.getInt("tid");
                boolean isTaken = rs.getBoolean("isTaken");
                int slotid = rs.getInt("slotid");
                String roomid = rs.getString("roomid");
                String subid = rs.getString("subid");
                Date date = rs.getDate("date");

                Group gr = group.getGroupByGid(gid);
                Lecturer l = lec.getLecByLid(lid);
                Room r = room.getRoomByRid(roomid);
                TimeSlot time = tslot.getTimeSlotByTid(tid);
                Slot s = slot.getSlotBySlotId(slotid);
                Subject sub = subject.getSubBySubid(subid);
                Session sess = new Session(sid, gr, l, r, time, isTaken, s, sub, date);
                ses.add(sess);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ses;
    }
}
