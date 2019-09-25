package com.qa.service;

import com.qa.dto.InventoryDto;
import com.qa.persistence.models.Inventory;
import com.qa.persistence.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService implements InventoryServiceInterface {

    @Autowired
    private InventoryRepository repository;

    public List<InventoryDto> getInventories(){
        List<Inventory> inventories = repository.findAll();
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();

        //For each inventory found, add to InventoriesDto
        inventories.forEach(inventory -> inventoriesDto.add(new InventoryDto(inventory)));

        return inventoriesDto;
    }

    public InventoryDto addInventory(InventoryDto inventoryDto){
        inventoryDto.setId(null);
        Inventory inventory = Inventory.createInventory();

        //Set all inventory record values to those provided (Excluding id which auto increments)
        inventory.setCopperPiece(inventoryDto.getCopperPiece());
        inventory.setSilverPiece(inventoryDto.getSilverPiece());
        inventory.setGoldPiece(inventoryDto.getGoldPiece());
        inventory.setPlatinumPiece(inventoryDto.getPlatinumPiece());
        inventory.setEquipment(inventoryDto.getEquipment());
        inventory.setPlayerId(inventoryDto.getPlayerId());

        return new InventoryDto(repository.saveAndFlush(inventory));
    }

    public InventoryDto getInventory(Long id){
        Inventory inventory = repository.getOne(id);
        return new InventoryDto(inventory);
    }

    public List<InventoryDto> getInventoryByPlayerId(Long playerId){
        List<Inventory> inventories = repository.findAll();
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();

        //For each inventory that matches the playerId add this to inventoriesDto
        inventories.stream().filter(inventory -> inventory.getPlayerId() == playerId).forEach(inventory -> inventoriesDto.add(new InventoryDto(inventory)));

        return inventoriesDto;
    }

    public InventoryDto deleteInventory(Long id){
        Inventory inventory = repository.getOne(id);
        InventoryDto inventoryDto = new InventoryDto(inventory);

        repository.deleteById(id);

        return inventoryDto;
    }

    public List<InventoryDto> deleteInventoryByPlayerId(Long playerId){
        List<Inventory> inventories = repository.findAll();
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();

        //Where the playerId given matches a record, add this to inventoriesDto then delete it
        inventories.stream().filter(inventory -> inventory.getPlayerId() == playerId).forEach(inventory -> {
            inventoriesDto.add(new InventoryDto(inventory));
            repository.deleteById(inventory.getId());
        });

        return inventoriesDto;
    }

    public InventoryDto updateInventory(Long id, InventoryDto inventoryDto){
        Inventory inventory = repository.getOne(id);

        //Update all values except id and playerId with the new values given
        inventory.setCopperPiece(inventoryDto.getCopperPiece());
        inventory.setSilverPiece(inventoryDto.getSilverPiece());
        inventory.setGoldPiece(inventoryDto.getGoldPiece());
        inventory.setPlatinumPiece(inventoryDto.getPlatinumPiece());
        inventory.setEquipment(inventoryDto.getEquipment());

        repository.flush();

        return new InventoryDto(inventory);
    }

    public List<InventoryDto> updateInventoryByPlayerId(Long playerId, InventoryDto inventoryDto){
        List<Inventory> inventories = repository.findAll();
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();

        //Where inventories match the given player id , update all information with the info given (Excluding id and playerId)
        inventories.stream().filter(inventory -> inventory.getPlayerId() == playerId).forEach(inventory -> {
            inventory.setCopperPiece(inventoryDto.getCopperPiece());
            inventory.setSilverPiece(inventoryDto.getSilverPiece());
            inventory.setGoldPiece(inventoryDto.getGoldPiece());
            inventory.setPlatinumPiece(inventoryDto.getPlatinumPiece());
            inventory.setEquipment(inventoryDto.getEquipment());

            inventoriesDto.add(new InventoryDto(inventory));

            repository.flush();
        });

        return inventoriesDto;
    }

}
