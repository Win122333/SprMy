package org.example.models;

public class Animal implements IModel {
    private String scienceName;
    private long population;
    private int avgLife;

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

    public Animal(String scienceName, long population, int avgLife) {
        this.scienceName = scienceName;
        this.population = population;
        this.avgLife = avgLife;
    }
}
