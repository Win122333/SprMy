package org.example.models;

public class Animal implements IModel {
    private int ID;
    private int ID_owner;
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

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
    }

    public int getID_owner() {
        return ID_owner;
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

    public Animal(String scienceName, long population, int avgLife, int ID_owner) {
        this.scienceName = scienceName;
        this.population = population;
        this.avgLife = avgLife;
        this.ID_owner = ID_owner;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", scienceName='" + scienceName + '\'' +
                ", population=" + population +
                ", avgLife=" + avgLife +
                "', id_owner='" + ID_owner + "'}";
    }
}
