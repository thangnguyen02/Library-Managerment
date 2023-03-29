/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phanv
 */
public class Book {
    private String id;
    private String name;
    private String category;
    private String specialized;
    private String author;
    private int PublishingYear;

    public Book() {
    }

    public Book(String id, String name, String category, String specialized, String author, int PublishingYear) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.specialized = specialized;
        this.author = author;
        this.PublishingYear = PublishingYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return PublishingYear;
    }

    public void setPublishingYear(int PublishingYear) {
        this.PublishingYear = PublishingYear;
    }
    
    
}
