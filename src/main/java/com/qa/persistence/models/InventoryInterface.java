package com.qa.persistence.models;

public interface InventoryInterface {

    Long getPlayerId();

    Long getId();

    int getCopperPiece();

    int getSilverPiece();

    int getGoldPiece();

    int getPlatinumPiece();

    String getEquipment();

}
