package com.qa.dto;


import com.qa.persistence.models.PlayerCharacter;

public class PlayerCharacterDto {

    private Long id;

    //Basic  stats
    private String name;
    private String race;
    private String playerClass;
    private String alignment;
    private String background;

    //Base number stats
    private int level;
    private int baseStr;
    private int baseInt;
    private int baseDex;
    private int baseCon;
    private int baseWis;
    private int baseCha;
    private int baseHP;
    private int baseProficiency;

    public PlayerCharacterDto(){
        super();
    }

    public PlayerCharacterDto(Long id, String name, String race, String playerClass, String alignment, String background, int level, int baseStr, int baseInt, int baseDex, int baseCon, int baseWis, int baseCha, int baseHP, int baseProficiency){
        super();
        this.id = id;
        this.name = name;
        this.race = race;
        this.playerClass = playerClass;
        this.alignment = alignment;
        this.background = background;
        this.level = level;
        this.baseStr = baseStr;
        this.baseInt = baseInt;
        this.baseDex = baseDex;
        this.baseCon = baseCon;
        this.baseWis = baseWis;
        this.baseCha = baseCha;
        this.baseHP = baseHP;
        this.baseProficiency = baseProficiency;
    }

    public PlayerCharacterDto(PlayerCharacter pC) {
        this.id = pC.getId();
        this.name = pC.getName();
        this.race = pC.getRace();
        this.playerClass = pC.getPlayerClass();
        this.alignment = pC.getAlignment();
        this.background = pC.getBackground();
        this.level = pC.getLevel();
        this.baseStr = pC.getBaseStr();
        this.baseInt = pC.getBaseInt();
        this.baseDex = pC.getBaseDex();
        this.baseCon = pC.getBaseCon();
        this.baseWis = pC.getBaseWis();
        this.baseCha = pC.getBaseCha();
        this.baseHP = pC.getBaseHP();
        this.baseProficiency = pC.getBaseProficiency();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseCon() {
        return baseCon;
    }

    public void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseWis() {
        return baseWis;
    }

    public void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseCha() {
        return baseCha;
    }

    public void setBaseCha(int baseCha) {
        this.baseCha = baseCha;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseProficiency() {
        return baseProficiency;
    }

    public void setBaseProficiency(int baseProficiency) {
        this.baseProficiency = baseProficiency;
    }

    // Should be a factory pattern
    public static PlayerCharacterDto createPlayerCharacter(){
        return new PlayerCharacterDto();
    }
}
