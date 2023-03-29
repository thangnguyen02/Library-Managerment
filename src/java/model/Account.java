/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phanv
 */
public class Account {
    private String userN;
    private String pass;
    private String name;
    private String rollno;
    private String className;
    private String subject;
    private int role;

    public Account() {
    }

    public Account(String userN, String pass, String name, String rollno, String className, String subject, int role) {
        this.userN = userN;
        this.pass = pass;
        this.name = name;
        this.rollno = rollno;
        this.className = className;
        this.subject = subject;
        this.role = role;
    }

    public String getUserN() {
        return userN;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account{" + "userN=" + userN + ", pass=" + pass + ", name=" + name + ", rollno=" + rollno
                + ", className=" + className + ", subject=" + subject + ", role=" + role + '}';
    }

}
