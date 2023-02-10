package com.linda.Library.Book;

import jakarta.persistence.Entity;

@Entity
public class Type {
    private String key;

    public String getKey() {
        return key;
    }

    // Setter Methods

    public void setKey(String key) {
        this.key = key;
    }
}


