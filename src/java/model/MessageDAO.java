/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class MessageDAO extends MyDAO{
    
     public List<Message> getMessAll() {
        List<Message> t = new ArrayList<>();
        xSql = "select * from Message order by dateE desc ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xmes, xdate;
            Message x;
            while (rs.next()) {
                xname = rs.getString("username");
                xmes = rs.getString("mes");
                xdate = rs.getString("dateE");

                x = new Message(xname, xmes, xdate);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
     
      public List<Message> getMess(String uname) {
        List<Message> t = new ArrayList<>();
        xSql = "select * from Message where username='"+uname+"' order by dateE desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname, xmes, xdate;
            Message x;
            while (rs.next()) {
                xname = rs.getString("username");
                xmes = rs.getString("mes");
                xdate = rs.getString("dateE");

                x = new Message(xname, xmes, xdate);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
     public void insert(String usn,String mess,String date) {
        xSql = "insert into Message (username,mes,dateE) values (?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, usn);
            ps.setString(2, mess);
            ps.setString(3, date);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
