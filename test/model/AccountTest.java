/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

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
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }    /**
     * Test of getUserN method, of class Account.
     */
    @Test
    public void testGetUserN() {
        System.out.println("getUserN");
        Account instance = new Account();
        String expResult = "okok";
        String result = instance.getUserN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPass method, of class Account.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPass method, of class Account.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "123";
        Account instance = new Account();
        instance.setPass(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Account.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Account.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Account instance = new Account();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRollno method, of class Account.
     */
    @Test
    public void testGetRollno() {
        System.out.println("getRollno");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getRollno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRollno method, of class Account.
     */
    @Test
    public void testSetRollno() {
        System.out.println("setRollno");
        String rollno = "";
        Account instance = new Account();
        instance.setRollno(rollno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClassName method, of class Account.
     */
    @Test
    public void testGetClassName() {
        System.out.println("getClassName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getClassName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClassName method, of class Account.
     */
    @Test
    public void testSetClassName() {
        System.out.println("setClassName");
        String className = "";
        Account instance = new Account();
        instance.setClassName(className);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubject method, of class Account.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubject method, of class Account.
     */
    @Test
    public void testSetSubject() {
        System.out.println("setSubject");
        String subject = "";
        Account instance = new Account();
        instance.setSubject(subject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Account.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Account.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        int role = 0;
        Account instance = new Account();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Account instance = new Account();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
