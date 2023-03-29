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
public class FinesDAO extends MyDAO{
    public List<Fines> getAllF() {
    List<Fines> t = new ArrayList<>();
    xSql = "select * from Fines order by datePri desc";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String username,id,dateE,status;
      int dateB,money;
      Fines x;
      while(rs.next()) {
        username = rs.getString("username");  
        id = rs.getString("ID");
        dateB = rs.getInt("numberdate");
        money = rs.getInt("money");
        status = rs.getString("Status");
       dateE = rs.getString("datePri");
        x = new Fines(username, id, dateB, money, status, dateE);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }
    
    public List<Fines> getFinesByID(String un) {
    List<Fines> t = new ArrayList<>();
    xSql = "select * from Fines where username='"+un+"' order by datePri DESC";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String username,id,dateE,status;
      int dateB,money;
      Fines x;
      while(rs.next()) {
        username = rs.getString("username");  
        id = rs.getString("ID");
        dateB = rs.getInt("numberdate");
        money = rs.getInt("money");
        status = rs.getString("Status");
       dateE = rs.getString("datePri");
        x = new Fines(username, id, dateB, money, status, dateE);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }
    public void insert(Fines x) {
     xSql = "insert into Fines (userName,ID,numberdate,money,Status,datePri) values (?,?,?,?,?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getUserName());
      ps.setString(2, x.getId());
      ps.setInt(3, x.getDatePhat());
      ps.setInt(4,x.getMoney());
      ps.setString(5, x.getStauts());
      ps.setString(6, x.getDate());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
     public void update(String Status, String datePri,String un,String id) {
     xSql = "update Fines set Status=?, datePri=? where userName=? and ID=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, Status);
        ps.setString(2, datePri);
        ps.setString(3, un);
        ps.setString(4, id);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
     
     
    public int getDay(String dateB,String dateE) {
    xSql = "select DATEDIFF(day,'"+dateB+"','"+dateE+"') as nu"; 
    int k = 0;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
     
      if(rs.next()) {
        k = rs.getInt("nu");
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(k);
  }
//      public List<Book> search(String id,String name,String category,String specialized,String author,String PublishingYear) {
//    List<Book> t = new ArrayList<>();
//    xSql = "select * from BOOKS WHERE "
//            + "ID like '%" + id + "%' and "
//            + "Name like N'%" + name + "%' and "
//            + "Category like N'%" + category + "%' and "
//            + "specialized like N'%" + specialized + "%' and "
//            + "author like N'%" + author + "%' and "
//            + "PublishingYear like '%" + PublishingYear + "%'";
//    try {
//      ps = con.prepareStatement(xSql);
//      rs = ps.executeQuery();
//      String xid,xname,xcategory,xspecialized,xauthor;
//     int xPublishingYear;
//      Book x;
//      while(rs.next()) {
//        xid = rs.getString("ID");  
//        xname = rs.getString("Name");
//        xcategory = rs.getString("Category");
//        xspecialized = rs.getString("specialized");
//        xauthor = rs.getString("author");
//        xPublishingYear = rs.getInt("PublishingYear");
//        x = new Book(xid, xname, xcategory, xspecialized, xauthor, xPublishingYear);
//        t.add(x);
//      }
//      rs.close();
//      ps.close();
//     }
//     catch(Exception e) {
//        e.printStackTrace();
//     }
//    return(t);
//  }
}
