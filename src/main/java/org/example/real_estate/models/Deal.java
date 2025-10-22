package org.example.real_estate.models;

import org.example.models.IModel;

import java.util.Date;

public class Deal implements IModel {
    private int ID;
    private int IDRealtor;

    private int IDUser;
    private String dealType;
    private int dealCost;
    private Date dateStart;
    private Date dateEnd;
    private String stage;

    public Deal(int IDRealtor, int IDUser, String dealType, int dealCost, Date dateStart, Date dateEnd, String stage) {
        this.IDRealtor = IDRealtor;
        this.IDUser = IDUser;
        this.dealType = dealType;
        this.dealCost = dealCost;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "ID=" + ID +
                ", IDRealtor=" + IDRealtor +
                ", IDUser=" + IDUser +
                ", dealType='" + dealType + '\'' +
                ", dealCost=" + dealCost +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", stage='" + stage + '\'' +
                '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDRealtor(int IDRealtor) {
        this.IDRealtor = IDRealtor;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public void setDealCost(int dealCost) {
        this.dealCost = dealCost;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getID() {
        return ID;
    }

    public int getIDRealtor() {
        return IDRealtor;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getDealType() {
        return dealType;
    }

    public int getDealCost() {
        return dealCost;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getStage() {
        return stage;
    }
}
