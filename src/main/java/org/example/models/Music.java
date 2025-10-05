package org.example.models;

public class Music implements IModel {
    private String title;
    private String autor;
    private int duration;
    public Music(String title, String autor, int duration) {
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
