/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Slot;
import model.Student;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class SessionDBContext extends DBContext {

    public static void main(String[] args) {
        SessionDBContext slot = new SessionDBContext();
        Attendance a = slot.getPresentOnSeidAndSid(1, "S0002");
        System.out.println(a.isIsPresent());
    }
    
    public Attendance getPresentOnSeidAndSid(int seid, String sid){
        Attendance a = new Attendance();
        String sql = "Select isPresent From Attendance Where seid = ? and sid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, seid);
            st.setString(2, sid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a.setIsPresent(rs.getBoolean("isPresent"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }

    public Session getSessionBySid(int seid) {
        List<Session> list = new ArrayList();
        GroupDBContext group = new GroupDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        TimeSlotDBContext tslot = new TimeSlotDBContext();
        RoomDBContext room = new RoomDBContext();
        SlotDBContext slot = new SlotDBContext();
        SubjectDBContext subject = new SubjectDBContext();
        Session ses = null;
        String sql = "SELECT [seid]\n"
                + "      ,[gid]\n"
                + "      ,[lid]\n"
                + "      ,[roomid]\n"
                + "      ,[tid]\n"
                + "      ,[isTaken]\n"
                + "      ,[slotid]\n"
                + "      ,[subid]\n"
                + "      ,[date]\n"
                + "  FROM [dbo].[Session]"
                + "Where seid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, seid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
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
                ses = new Session(seid, gr, l, r, time, isTaken, s, sub, date);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ses;
    }

    public List<Session> getAllSession() {
        List<Session> list = new ArrayList();
        GroupDBContext group = new GroupDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        TimeSlotDBContext tslot = new TimeSlotDBContext();
        RoomDBContext room = new RoomDBContext();
        SlotDBContext slot = new SlotDBContext();
        SubjectDBContext subject = new SubjectDBContext();
        String sql = "SELECT [seid]\n"
                + "      ,[gid]\n"
                + "      ,[lid]\n"
                + "      ,[roomid]\n"
                + "      ,[tid]\n"
                + "      ,[isTaken]\n"
                + "      ,[slotid]\n"
                + "      ,[subid]\n"
                + "      ,[date]\n"
                + "  FROM [dbo].[Session]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
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

                Session ses = new Session(seid, gr, l, r, time, isTaken, s, sub, date);
                list.add(ses);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Session> getSessionByLid(String username) {
        List<Session> list = new ArrayList();
        GroupDBContext group = new GroupDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        TimeSlotDBContext tslot = new TimeSlotDBContext();
        RoomDBContext room = new RoomDBContext();
        SlotDBContext slot = new SlotDBContext();
        SubjectDBContext subject = new SubjectDBContext();
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
                + "  WHERE lid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
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

                Session ses = new Session(seid, gr, l, r, time, isTaken, s, sub, date);
                list.add(ses);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Session> getSessionBySid(String username) {
        List<Session> list = new ArrayList();
        GroupDBContext group = new GroupDBContext();
        LecturerDBContext lec = new LecturerDBContext();
        TimeSlotDBContext tslot = new TimeSlotDBContext();
        RoomDBContext room = new RoomDBContext();
        SlotDBContext slot = new SlotDBContext();
        SubjectDBContext subject = new SubjectDBContext();
        String sql = "SELECT se.seid, se.roomid, se.date, se.gid, se.isTaken, "
                + "se.lid, se.tid, se.subid, se.slotid from Session se INNER JOIN [Group] g ON se.gid = g.gid \n"
                + "	INNER JOIN Erollment e ON g.gid = e.gid  INNER JOIN Student s ON s.stuid = e.stuid\n"
                + "                    WHERE s.stuid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int seid = rs.getInt("seid");
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

                Session ses = new Session(seid, gr, l, r, time, isTaken, s, sub, date);
                list.add(ses);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Student> getStudentsByLession(int leid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.stuid,s.name FROM Student s "
                    + "INNER JOIN Erollment e ON s.stuid = e.stuid \n"
                    + "INNER JOIN [Group] g ON g.gid = e.gid "
                    + "INNER JOIN Session les ON les.gid = g.gid WHERE les.seid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStuid(rs.getString("stuid"));
                s.setName(rs.getString("name"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Attendance> getAttendencesByLession(int leid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "SELECT  s.stuid,s.name, a.aid,a.description,a.isPresent,a.DateTime FROM Student s \n"
                    + "INNER JOIN Erollment e ON s.stuid = e.stuid \n"
                    + "INNER JOIN [Group] g ON g.gid = e.gid \n"
                    + "INNER JOIN Session ses ON ses.gid = g.gid \n"
                    + "LEFT JOIN Attendance a ON a.seid = ses.seid AND a.sid = s.stuid WHERE ses.seid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                Student s = new Student();
                Session ses = new Session();
                s.setStuid(rs.getString("stuid"));
                s.setName(rs.getString("name"));
                a.setSid(s);

                ses.setSeid(leid);
                a.setSeid(ses);

                a.setAid(rs.getInt("aid"));
                if (a.getAid() != 0) {
                    a.setDescription(rs.getString("description"));
                    a.setIsPresent(rs.getBoolean("isPresent"));
                    a.setDate(rs.getTimestamp("DateTime"));
                }
                atts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public void takeAttendances(int leid, ArrayList<Attendance> atts) {
        try {
            connection.setAutoCommit(false);
            String sql_remove_atts = "DELETE FROM [dbo].[Attendance] WHERE seid = ?";
            PreparedStatement stm_remove_atts = connection.prepareStatement(sql_remove_atts);
            stm_remove_atts.setInt(1, leid);
            stm_remove_atts.executeUpdate();

            for (Attendance att : atts) {
                String sql_insert_att = "INSERT INTO [dbo].[Attendance]( [seid] ,[sid] ,[isPresent], [Description], [DateTime] ) VALUES (?, ?, ?, ?, GETDATE())";
                PreparedStatement stm_insert_att = connection.prepareStatement(sql_insert_att);
                stm_insert_att.setInt(1, leid);
                stm_insert_att.setString(2, att.getSid().getStuid());
                stm_insert_att.setBoolean(3, att.isIsPresent());
                stm_insert_att.setString(4, att.getDescription());
                stm_insert_att.executeUpdate();
            }

            String sql_update_lession = "UPDATE [dbo].[Session]\n"
                    + "   SET [isTaken] = 1\n"
                    + " WHERE seid = ?";
            PreparedStatement stm_update_lession = connection.prepareStatement(sql_update_lession);
            stm_update_lession.setInt(1, leid);
            stm_update_lession.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
