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
public class EmployeeDAO extends MyDAO{
    public List<Employee> getEmployees() {
    List<Employee> t = new ArrayList<>();
    xSql = "select * from Employee";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String id,name,address,phone,vitri;
      Employee x;
      while(rs.next()) {
        id = rs.getString("ID");  
        name = rs.getString("Name");
        address = rs.getString("Address");
        phone = rs.getString("phone");
        vitri = rs.getString("Positions"); 
        x = new Employee(id, name, address, phone, vitri);
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
     public void insert(Employee x) {
     xSql = "insert into Employee (ID,Name,Address,phone,Positions) values (?,?,?,?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getId());
      ps.setString(2, x.getName());
      ps.setString(3, x.getAddress());
      ps.setString(4, x.getPhone());
      ps.setString(5, x.getPositions());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
      public void delete(String ID) {
     xSql = "delete from Employee where ID=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, ID);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
   
}
