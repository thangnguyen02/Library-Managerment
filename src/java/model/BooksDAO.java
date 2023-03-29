package model;
import java.util.*;
import java.sql.*;

public class BooksDAO extends MyDAO {

  public List<Book> getBooks() {
    List<Book> t = new ArrayList<>();
    xSql = "select top 10 * from BOOKS";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String id,name,category,specialized,author;
      int PublishingYear;
      Book x;
      while(rs.next()) {
        id = rs.getString("ID");  
        name = rs.getString("Name");
        category = rs.getString("Category");
        specialized = rs.getString("specialized");
        author = rs.getString("author");
        PublishingYear = rs.getInt("PublishingYear");
       
        x = new Book(id, name, category, specialized, author, PublishingYear);
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
  
  
  public Book getBook(String ID) {
     Book x = null;
     String id,name,category,specialized,author;
     int PublishingYear;
     xSql = "select * from BOOKS where ID=?"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, ID);
      rs = ps.executeQuery();
      if(rs.next()) {
        id = rs.getString("ID");  
        name = rs.getString("Name");
        category = rs.getString("Category");
        specialized = rs.getString("specialized");
        author = rs.getString("author");
        PublishingYear = rs.getInt("PublishingYear");
        x = new Book(id, name, category, specialized, author, PublishingYear);
      }
      rs.close();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
     return(x);
  }

  public void insert(Book x) {
     xSql = "insert into BOOKS (ID,Name,Category,specialized,author,PublishingYear) values (?,?,?,?,?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getId());
      ps.setString(2, x.getName());
      ps.setString(3, x.getCategory());
      ps.setString(4, x.getSpecialized());
      ps.setString(5, x.getAuthor());
      ps.setInt(6, x.getPublishingYear());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
    public void delete(String ID) {
     xSql = "delete from BOOKS where ID=?";
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
     public void update(String ID, Book x) {
     xSql = "update BOOKS set Name=N'"+ x.getName()+"',"
             + " Category=N'"+x.getCategory()+"',"
             + "specialized=N'"+x.getSpecialized()+"',"
             + "author=N'"+x.getAuthor()+"',"
             + "PublishingYear="+x.getPublishingYear()+" where ID=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, ID);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
     
     
    public List<Book> getBooksSort(String xSortColName, String xSortType) {
    List<Book> t = new ArrayList<>();
    xSql = "select * from BOOKS order by " + xSortColName + " " + xSortType;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String id,name,category,specialized,author;
        int PublishingYear;
      Book x;
      while(rs.next()) {
        id = rs.getString("ID");  
        name = rs.getString("Name");
        category = rs.getString("Category");
        specialized = rs.getString("specialized");
        author = rs.getString("author");
        PublishingYear = rs.getInt("PublishingYear");
        x = new Book(id, name, category, specialized, author, PublishingYear);
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
    
    public List<Book> search(String id,String name,String category,String specialized,String author,String PublishingYear) {
    List<Book> t = new ArrayList<>();
    xSql = "select * from BOOKS WHERE "
            + "ID like '%" + id + "%' and "
            + "Name like N'%" + name + "%' and "
            + "Category like N'%" + category + "%' and "
            + "specialized like N'%" + specialized + "%' and "
            + "author like N'%" + author + "%' and "
            + "PublishingYear like '%" + PublishingYear + "%'";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xid,xname,xcategory,xspecialized,xauthor;
     int xPublishingYear;
      Book x;
      while(rs.next()) {
        xid = rs.getString("ID");  
        xname = rs.getString("Name");
        xcategory = rs.getString("Category");
        xspecialized = rs.getString("specialized");
        xauthor = rs.getString("author");
        xPublishingYear = rs.getInt("PublishingYear");
        x = new Book(xid, xname, xcategory, xspecialized, xauthor, xPublishingYear);
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
     public HashMap<Book,Integer> getTopBorrow() {
        HashMap<Book,Integer> t = new LinkedHashMap<>();
        xSql = "select BOOKS.*,b1.num from " +
                "(select top 3 ID,COUNT(ID) as num from History where status = 'Borrow' group by ID order by num desc) as b1,Books where BOOKS.ID = b1.ID";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String id,name,category,specialized,author;
            int PublishingYear,num;
            Book x;
            while (rs.next()) {
                id = rs.getString("ID");  
                name = rs.getString("Name");
                category = rs.getString("Category");
                specialized = rs.getString("specialized");
                author = rs.getString("author");
                PublishingYear = rs.getInt("PublishingYear");
                num = rs.getInt("num");
                x = new Book(id, name, category, specialized, author, PublishingYear);
                t.put(x, num);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
     public static void main(String[] args) {
         BooksDAO bk = new BooksDAO();
         HashMap<Book,Integer> t = bk.getTopBorrow();
        for (Book b: t.keySet()) {
            System.out.println(b.getId()+","+b.getName()+","+t.get(b));
        }
    }
  //  public List<Student> getStudents(String xxName) {
//    List<Student> t = new ArrayList<>();
//    xSql = "select * from Student WHERE name like '%" + xxName + "%'";
//    try {
//      ps = con.prepareStatement(xSql);
//      rs = ps.executeQuery();
//      String xRollno,xName; float xMark;
//      Student x;
//      while(rs.next()) {
//        xRollno = rs.getString("rollno");  
//        xName = rs.getString("name");  
//        xMark = rs.getFloat("mark");
//        x = new Student(xRollno,xName,xMark);
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


//  public String [] getColNames(String xTable) {
//    String [] a = new String[30];
//    int i = 0; int n;
//    xSql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
//    try {
//      ps = con.prepareStatement(xSql);
//      ps.setString(1, xTable);
//      rs = ps.executeQuery();
//      String xColName;
//      i=0;
//      while(rs.next()) {
//        xColName = rs.getString("COLUMN_NAME");
//        a[i++] = xColName;
//      }
//      rs.close();
//      ps.close();
//     }
//     catch(Exception e) {
//        e.printStackTrace();
//     }
//    n = i;
//    String [] b = new String[n];
//    for(i=0;i<n;i++) b[i] = a[i];
//    return(b);
//  }
//


}
