package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey (autoGenerate = true)
    public int id;
    public String titile;
    public String description;

    public Note( String titile, String description) {
        this.titile = titile;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitile() {
        return titile;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
