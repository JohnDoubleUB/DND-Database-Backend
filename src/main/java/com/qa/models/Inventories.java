package com.qa.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Currency
    private int playerId;
    private int copperPiece;
    private int silverPiece;
    private int goldPiece;
    private int platinumPiece;

    //Inventory
    private String equipment;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCopperPiece() {
        return copperPiece;
    }

    public void setCopperPiece(int copperPiece) {
        this.copperPiece = copperPiece;
    }

    public int getSilverPiece() {
        return silverPiece;
    }

    public void setSilverPiece(int silverPiece) {
        this.silverPiece = silverPiece;
    }

    public int getGoldPiece() {
        return goldPiece;
    }

    public void setGoldPiece(int goldPiece) {
        this.goldPiece = goldPiece;
    }

    public int getPlatinumPiece() {
        return platinumPiece;
    }

    public void setPlatinumPiece(int platinumPiece) {
        this.platinumPiece = platinumPiece;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
