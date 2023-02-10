package com.linda.Library.Book;

import java.util.ArrayList;

public class BookArrays {
    public ArrayList<String> authors;
    public ArrayList<String> covers;
    public ArrayList<String> subject_places;
    public ArrayList<String> subjects;
    public ArrayList<String> subject_people;
    public ArrayList<String> subject_times;

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCovers() {
        return covers;
    }

    public void setCovers(ArrayList<String> covers) {
        this.covers = covers;
    }

    public ArrayList<String> getSubject_places() {
        return subject_places;
    }

    public void setSubject_places(ArrayList<String> subject_places) {
        this.subject_places = subject_places;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getSubject_people() {
        return subject_people;
    }

    public void setSubject_people(ArrayList<String> subject_people) {
        this.subject_people = subject_people;
    }

    public ArrayList<String> getSubject_times() {
        return subject_times;
    }

    public void setSubject_times(ArrayList<String> subject_times) {
        this.subject_times = subject_times;
    }

    @Override
    public String toString() {
        return "BookArrays{" +
                "authors="+
                "covers=" + covers +
                ", subject_places=" + subject_places +
                ", subjects=" + subjects +
                ", subject_people=" + subject_people +
                ", subject_times=" + subject_times +
                '}';
    }
}
