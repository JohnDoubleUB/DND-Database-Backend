package com.qa.dto;

import com.qa.persistence.models.Inventory;

public class InventoryDto {

    private Long id;

    //Currency
    private Long playerId;
    private int copperPiece;
    private int silverPiece;
    private int goldPiece;
    private int platinumPiece;

    //Inventory
    private String equipment;

    public InventoryDto(){
        super();
    }

    public InventoryDto(Long id, Long playerId, int copperPiece, int silverPiece, int goldPiece, int platinumPiece, String equipment){
        super();
        this.id = id;
        this.playerId = playerId;
        this.copperPiece = copperPiece;
        this.silverPiece = silverPiece;
        this.goldPiece = goldPiece;
        this.platinumPiece = platinumPiece;
        this.equipment = equipment;
    }

    public InventoryDto(Inventory inventory){
        this.id = inventory.getId();
        this.playerId = inventory.getPlayerId();
        this.copperPiece = inventory.getCopperPiece();
        this.silverPiece = inventory.getSilverPiece();
        this.goldPiece = inventory.getGoldPiece();
        this.platinumPiece = inventory.getPlatinumPiece();
        this.equipment = inventory.getEquipment();
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    // Should be a factory pattern
    public static InventoryDto createInventories(){
        return new InventoryDto();
    }
}
