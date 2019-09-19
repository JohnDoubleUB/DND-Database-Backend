package com.qa.dto;

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
