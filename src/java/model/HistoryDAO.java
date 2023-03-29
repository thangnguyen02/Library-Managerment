/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author acer
 */
public class HistoryDAO extends MyDAO {

    public List<History> getHis() {
        List<History> t = new ArrayList<>();
        xSql = "select * from History where note='Pending' and Status='Borrow'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
            History x;
            while (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public History getHisbyUnID(String us,String id) {
        xSql = "select * from History where username='"+us+"' and ID='"+id+"' and Status='Borrow'";
         History x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
           
            if (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    public List<History> getHistoryAll() {
        List<History> t = new ArrayList<>();
        xSql = "select * from History order by dateEvent desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
            History x;
            while (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<History> getLib(String username) {
        List<History> t = new ArrayList<>();
        xSql = "select BOOKS.ID,BOOKS.Name,History.dateEvent,History.status,History.note from History,Books where Books.ID = History.ID and History.username =  '" + username + "'  order by dateEvent desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
            History x;
            while (rs.next()) {
                xid = rs.getString("ID");
                xname = rs.getString("Name");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<History> search(String username, String id, String name, String dateB, String dateE, String status, String note) {
        List<History> t = new ArrayList<>();
        xSql = "select BOOKS.ID,BOOKS.Name,History.dateEvent,History.status,History.note "
                + "from History,Books "
                + "WHERE Books.ID = History.ID and History.username =  '" + username + "' and "
                + "BOOKS.ID like '%" + id + "%' and "
                + "BOOKS.Name like N'%" + name + "%' and "
                + "History.dateEvent BETWEEN  '" + dateB + "' and '" + dateE + "' and "
                + "History.status like N'%" + status + "%' and "
                + "History.note like N'%" + note + "%'";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xid, xname, xdate, xstatus, xnote;

            History x;
            while (rs.next()) {
                xid = rs.getString("ID");
                xname = rs.getString("Name");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");
                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    
    public List<History> searchAll(String username, String id, String date, String status, String note) {
        List<History> t = new ArrayList<>();
        xSql = "select * from History where username like '%"+username+"%' and"
                + " ID like '%"+id+"%' and"
                + " dateEvent like '%"+date+"%' and"
                + " status like '%"+status+"%' and"
                + " note like '%"+note+"%'";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xid, xname, xdate, xstatus, xnote;

            History x;
            while (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");
                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public void insert(String uN, String id, String date, String status, String note) {
        xSql = "insert into History (username,ID,dateEvent,status,note) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, uN);
            ps.setString(2, id);
            ps.setString(3, date);
            ps.setString(4, status);
            ps.setString(5, note);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String usn,String id,String collname,String value) {
     xSql = "update History set "+collname+"=? where username=? and ID=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, value);
        ps.setString(2, usn);
        ps.setString(3, id);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
    
    
    
    public void delete(String usn,String id) {
     xSql = "delete from History where username=? and ID=? and Status='Borrow' and note='Pending'";
     try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, usn);
        ps.setString(2, id);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
    
    public List<History> getBorrow() {
        List<History> t = new ArrayList<>();
        xSql = "select * from History where Status = 'Borrow' and note='Successful' order by dateEvent desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
            History x;
            while (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<History> getGiveback() {
        List<History> t = new ArrayList<>();
        xSql = "select * from History where Status = 'GiveBack' and note='Successful'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xid, xdate, xstatus, xnote;
            History x;
            while (rs.next()) {
                xid = rs.getString("username");
                xname = rs.getString("ID");
                xdate = rs.getString("dateEvent");
                xstatus = rs.getString("status");
                xnote = rs.getString("note");

                x = new History(xid, xname, xdate, xstatus, xnote);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
   
}
