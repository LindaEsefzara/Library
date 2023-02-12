package com.linda.Library.Model;

import java.util.ArrayList;

public class Books {

        private String title;
        private String key;
        ArrayList < Object > authors = new ArrayList < Object > ();
        Type TypeObject;
        private String description;
        ArrayList < Object > covers = new ArrayList < Object > ();
        ArrayList < Object > subject_places = new ArrayList < Object > ();
        ArrayList < Object > subjects = new ArrayList < Object > ();
        ArrayList < Object > subject_people = new ArrayList < Object > ();
        ArrayList < Object > subject_times = new ArrayList < Object > ();
        private String location;
        private float latest_revision;
        private float revision;
        Created CreatedObject;
        Last_modified Last_modifiedObject;


        // Getter Methods

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

