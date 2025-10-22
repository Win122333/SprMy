package org.example.models;

public class Music implements IModel {
    private int ID;
    private int ID_owner;
    private String title;
    private String autor;
    private int duration;
    public Music(String title, String autor, int duration, int ID_owner) {
        this.ID_owner = ID_owner;
        this.title = title;
        this.autor = autor;
        this.duration = duration;
    }

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
    }

    public int getID_owner() {
        return ID_owner;
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
        return "Music{" +
                "ID=" + ID +
                ", ID_owner=" + ID_owner +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", duration=" + duration +
                '}';
    }
}
