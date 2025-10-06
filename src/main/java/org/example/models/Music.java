package org.example.models;

public class Music implements IModel {
    private int ID;
    private String title;
    private String autor;
    private int duration;
    public Music(int ID, String title, String autor, int duration) {
        this.ID = ID;
        this.title = title;
        this.autor = autor;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getID() {
        return ID;
    }

    public String getAutor() {
        return autor;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", duration=" + duration;
    }
}
