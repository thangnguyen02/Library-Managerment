/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;


/**
 *
 * @author acer
 */
public class BooksDAOTest {
    BooksDAO book;
    public BooksDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        book = new BooksDAO();
    }
    
    @After
    public void tearDown() {
        book = null;
    }

    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        List<Book> expResult = book.getBooks();
        List<Book> result = book.getBooks();

        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetBook() {
        System.out.println("getBook");
        String ID = "10";
        Book expResult = book.getBook(ID);
        Book result = book.getBook(ID);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Book x = null;
        BooksDAO instance = new BooksDAO();
        instance.insert(x);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        String ID = "1";
        book.delete(ID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        String ID = "";
        Book x = null;
        book.update(ID, x);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBooksSort() {
        System.out.println("getBooksSort");
        String xSortColName = "";
        String xSortType = "";
        BooksDAO instance = new BooksDAO();
        List<Book> expResult = null;
        List<Book> result = instance.getBooksSort(xSortColName, xSortType);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        String id = "";
        String name = "";
        String category = "";
        String specialized = "";
        String author = "";
        String PublishingYear = "";
        BooksDAO instance = new BooksDAO();
        List<Book> expResult = null;
        List<Book> result = instance.search(id, name, category, specialized, author, PublishingYear);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTopBorrow() {
        System.out.println("getTopBorrow");
        BooksDAO instance = new BooksDAO();
        HashMap<Book, Integer> expResult = null;
        HashMap<Book, Integer> result = instance.getTopBorrow();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BooksDAO.main(args);
        fail("The test case is a prototype.");
    }
    
}
