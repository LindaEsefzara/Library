package com.linda.Library.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {

    private String title;
    private String key;
    Type TypeObject;
    private String description;

    private String location;
    private float latest_revision;
    private float revision;
    Created CreatedObject;
    Last_modified Last_modifiedObject;

    public String getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }

    public Type getType() {
        return TypeObject;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public float getLatest_revision() {
        return latest_revision;
    }

    public float getRevision() {
        return revision;
    }

    public Created getCreated() {
        return CreatedObject;
    }

    public Last_modified getLast_modified() {
        return Last_modifiedObject;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setType(Type typeObject) {
        this.TypeObject = typeObject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatest_revision(float latest_revision) {
        this.latest_revision = latest_revision;
    }

    public void setRevision(float revision) {
        this.revision = revision;
    }

    public void setCreated(Created createdObject) {
        this.CreatedObject = createdObject;
    }

    public void setLast_modified(Last_modified last_modifiedObject) {
        this.Last_modifiedObject = last_modifiedObject;
    }

}
