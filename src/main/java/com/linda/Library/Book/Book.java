package com.linda.Library.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;

public class Book {

private String Author;
private String Author2;
private String Created;
private String Description;
private String LastModified;
private String Root;

private String Type;

    public Book(String author, String author2, String created, String description, String lastModified, String root, String type) {
        Author = author;
        Author2 = author2;
        Created = created;
        Description = description;
        LastModified = lastModified;
        Root = root;
        Type = type;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getAuthor2() {
        return Author2;
    }

    public void setAuthor2(String author2) {
        Author2 = author2;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLastModified() {
        return LastModified;
    }

    public void setLastModified(String lastModified) {
        LastModified = lastModified;
    }

    public String getRoot() {
        return Root;
    }

    public void setRoot(String root) {
        Root = root;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Author='" + Author + '\'' +
                ", Author2='" + Author2 + '\'' +
                ", Created='" + Created + '\'' +
                ", Description='" + Description + '\'' +
                ", LastModified='" + LastModified + '\'' +
                ", Root='" + Root + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }

    public class Author{
        public Type type;
        public Author author;
    }

    public static class Author2{
        public String key;
    }

    public class Created{
        public String type;
        public Date value;
    }

    public class Description{
        public String type;
        public String value;
    }

    public class LastModified{
        public String type;
        public Date value;
    }

    public class Root{
        public Created created;
        public ArrayList<String> subjects;
        public int latest_revision;
        public Description description;
        public String key;
        public String title;
        public ArrayList<Author> authors;
        public Type type;
        public LastModified last_modified;
        public int revision;
    }

    public class Type{
        public String key;
    }

}
