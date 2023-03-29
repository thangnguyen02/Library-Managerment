package model;

import java.util.*;
import java.sql.*;

public class AccountDAO extends MyDAO {

  public List<Account> getAccounts() {
    List<Account> t = new ArrayList<>();
    xSql = "select * from ACCOUNT";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String userN, pass, name, rollno, classN, subject;
      int role;
      Account x;
      while (rs.next()) {
        userN = rs.getString("userName");
        pass = rs.getString("pass");
        name = rs.getString("name");
        rollno = rs.getString("rollno");
        classN = rs.getString("className");
        subject = rs.getString("subject");
        role = rs.getInt("role");
        x = new Account(userN, pass, name, rollno, classN, subject, role);
        t.add(x);
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (t);
  }

  public List<Account> getAccounts(int role) {
    List<Account> t = new ArrayList<>();
    xSql = "select * from ACCOUNT where role =" + role;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String userN, pass, name, rollno, classN, subject;
      int xrole;
      Account x;
      while (rs.next()) {
        userN = rs.getString("userName");
        pass = rs.getString("pass");
        name = rs.getString("name");
        rollno = rs.getString("rollno");
        classN = rs.getString("className");
        subject = rs.getString("subject");
        xrole = rs.getInt("role");
        x = new Account(userN, pass, name, rollno, classN, subject, role);
        t.add(x);
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (t);
  }

  public Account getAccount(String username, String pass) {
    Account x = null;
    String userN, passw, name, rollno, classN, subject;
    int role;
    xSql = "select * from ACCOUNT where userName=? AND pass=?";
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, username);
      ps.setString(2, pass);
      rs = ps.executeQuery();
      if (rs.next()) {
        userN = rs.getString("userName");
        passw = rs.getString("pass");
        name = rs.getString("name");
        rollno = rs.getString("rollno");
        classN = rs.getString("className");
        subject = rs.getString("subject");
        role = rs.getInt("role");
        x = new Account(userN, passw, name, rollno, classN, subject, role);
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (x);
  }

  public void insert(Account x) {
    xSql = "insert into ACCOUNT (userName,pass,name,rollno,className,subject,role) values (?,?,?,?,?,?,?);";
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getUserN());
      ps.setString(2, x.getPass());
      ps.setString(3, x.getName());
      ps.setString(4, x.getRollno());
      ps.setString(5, x.getClassName());
      ps.setString(6, x.getSubject());
      ps.setInt(7, x.getRole());
      ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updatePass(String user, String newPass) {
    xSql = "update Student set pass=? where userName=?";
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, newPass);
      ps.setString(2, user);
      ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Account> search(String userName, String Name, String Rollno, String className, String subject) {
    List<Account> t = new ArrayList<>();
    xSql = "select * from ACCOUNT WHERE "
        + "userName like '%" + userName + "%' and "
        + "Name like N'%" + Name + "%' and "
        + "rollno like '%" + Rollno + "%' and "
        + "className like '%" + className + "%' and "
        + "subject like '%" + subject + "%' and role = 0";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xuserN, xpass, xname, xrollno, xclassN, xsubject;
      int xrole;
      Account x;
      while (rs.next()) {
        xuserN = rs.getString("userName");
        xpass = rs.getString("pass");
        xname = rs.getString("name");
        xrollno = rs.getString("rollno");
        xclassN = rs.getString("className");
        xsubject = rs.getString("subject");
        xrole = rs.getInt("role");
        x = new Account(xuserN, xpass, xname, xrollno, xclassN, xsubject, xrole);
        t.add(x);
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (t);
  }
  // public void updateInfnor(String user,Account x) {
  // xSql = "update Student set pass=? where userName=?";
  // try {
  // ps = con.prepareStatement(xSql);
  // ps.setString(1, newPass);
  // ps.setString(2, user);
  // ps.executeUpdate();
  // ps.close();
  // }
  // catch(Exception e) {
  // e.printStackTrace();
  // }
  // }
  // public String [] getColNames(String xTable) {
  // String [] a = new String[30];
  // int i = 0; int n;
  // xSql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME =
  // ?";
  // try {
  // ps = con.prepareStatement(xSql);
  // ps.setString(1, xTable);
  // rs = ps.executeQuery();
  // String xColName;
  // i=0;
  // while(rs.next()) {
  // xColName = rs.getString("COLUMN_NAME");
  // a[i++] = xColName;
  // }
  // rs.close();
  // ps.close();
  // }
  // catch(Exception e) {
  // e.printStackTrace();
  // }
  // n = i;
  // String [] b = new String[n];
  // for(i=0;i<n;i++) b[i] = a[i];
  // return(b);
  // }
  //
  // public List<Student> getStudents(String xSortColName, String xSortType) {
  // List<Student> t = new ArrayList<>();
  // xSql = "select * from Student order by " + xSortColName + " " + xSortType;
  // try {
  // ps = con.prepareStatement(xSql);
  // rs = ps.executeQuery();
  // String xRollno,xName; float xMark;
  // Student x;
  // while(rs.next()) {
  // xRollno = rs.getString("rollno");
  // xName = rs.getString("name");
  // xMark = rs.getFloat("mark");
  // x = new Student(xRollno,xName,xMark);
  // t.add(x);
  // }
  // rs.close();
  // ps.close();
  // }
  // catch(Exception e) {
  // e.printStackTrace();
  // }
  // return(t);
  // }

}
