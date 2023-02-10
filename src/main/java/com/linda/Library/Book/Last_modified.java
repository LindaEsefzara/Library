package com.linda.Library.Book;

import jakarta.persistence.Entity;

@Entity
public class Last_modified {
    private String type;
    private String value;


    // Getter Methods

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
