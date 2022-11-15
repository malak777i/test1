package com.example.test1;

public class book
{
    private int year;
    private String title;
    private String description;
    private String author;



    public book() {
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }


    public book(String title, String description, String author, int year) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
    }
}
