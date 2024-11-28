package com.example.noteeditor;
public class Note {
    private String text;
    private String author;
    private int likes;
    private int dislikes;

    // Constructor
    public Note(String text, String author) {
        this.text = text;
        this.author = author;
        this.likes = 0;
        this.dislikes = 0;
    }

    // Getters
    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    // Methods to increment likes and dislikes
    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }
}
