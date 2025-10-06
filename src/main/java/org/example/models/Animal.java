package org.example.models;

public class Animal implements IModel {
    private int ID;
    private String scienceName;
    private long population;
    private int avgLife;

    public void setID(int ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setAvgLife(int avgLife) {
        this.avgLife = avgLife;
    }

    public String getScienceName() {
        return scienceName;
    }

    public long getPopulation() {
        return population;
    }

    public int getAvgLife() {
        return avgLife;
    }

    public Animal(int ID, String scienceName, long population, int avgLife) {
        this.ID = ID;
        this.scienceName = scienceName;
        this.population = population;
        this.avgLife = avgLife;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", scienceName='" + scienceName + '\'' +
                ", population=" + population +
                ", avgLife=" + avgLife +
                '}';
    }
}
