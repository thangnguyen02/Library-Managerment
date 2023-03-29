/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author acer
 */
public class EmployeeDAOTest {
    private EmployeeDAO my;
    public EmployeeDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        my = new EmployeeDAO();
    }
    
    @AfterEach
    public void tearDown() {
        my = null;
    }

    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        EmployeeDAO instance = new EmployeeDAO();
        List<Employee> expResult = my.getEmployees();
        List<Employee> result = instance.getEmployees();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Employee x = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.insert(x);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        String ID = "";
        EmployeeDAO instance = new EmployeeDAO();
        instance.delete(ID);
        fail("The test case is a prototype.");
    }
    
}
