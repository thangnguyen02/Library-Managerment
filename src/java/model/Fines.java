/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Fines {
    private String userName;
    private String id;
    private int datePhat;
    private int money;
    private String stauts;
    private String date;

    public Fines() {
    }

    public Fines(String userName, String id, int datePhat, int money, String stauts, String date) {
        this.userName = userName;
        this.id = id;
        this.datePhat = datePhat;
        this.money = money;
        this.stauts = stauts;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDatePhat() {
        return datePhat;
    }

    public void setDatePhat(int datePhat) {
        this.datePhat = datePhat;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
