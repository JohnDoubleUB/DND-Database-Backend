package com.qa.controllers;


import com.qa.persistence.models.Inventory;
import com.qa.persistence.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class InventoryController {

    @Autowired
    private InventoryRepository repository;

    //Get all inventories -- DONE
    @RequestMapping(value = "inventories", method = RequestMethod.GET)
    public List<Inventory> getInventories(){
        return repository.findAll();
    }

    //Add an inventory -- DONE
    @RequestMapping(value = "inventories", method = RequestMethod.POST)
    public Inventory addInventory(@RequestBody Inventory inventory){
        return repository.saveAndFlush(inventory);
    }

    //Get a singular inventory -- DONE
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.GET)
    public Inventory getInventory(@PathVariable Long id){
        return repository.findOne(id);
    }

    //Get an inventory by playerId -- DONE
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.GET)
    public List<Inventory> getInventoryByPlayerID(@PathVariable Long playerId){
        List<Inventory> allInventories = repository.findAll();

        List<Inventory> existingInventories = new ArrayList<>();

        for(Inventory inv : allInventories){
            if(inv.getPlayerId().equals(playerId)){
                existingInventories.add(inv);
            }
        }


        return existingInventories;
    }


    //Delete a singular inventory by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.DELETE)
    public Inventory deleteInventory(@PathVariable Long id){
        Inventory existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    //Delete an inventory by playerId -- DONE
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.DELETE)
    public List<Inventory> deleteInventoryByPlayerId(@PathVariable Long playerId){

        List<Inventory> existingInventories = new ArrayList<>();

        //List<Inventories> existingInventories = allInventories.stream().filter(i -> i.getPlayerId() == playerId).collect(Collectors.toList());
        //existingInventories.stream().forEach(repository::delete);

        for(Inventory inv : repository.findAll()){
            if(inv.getPlayerId().equals(playerId)){
                existingInventories.add(inv);
                repository.delete(inv);
            }
        }

        return existingInventories;
    }

    //Update Inventories by id
    @Transactional
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.PUT)
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory){
        Inventory existing = repository.findOne(id); //Returns inv2

        existing.setCopperPiece(inventory.getCopperPiece());
        existing.setSilverPiece(inventory.getSilverPiece());
        existing.setGoldPiece(inventory.getGoldPiece());
        existing.setPlatinumPiece(inventory.getPlatinumPiece());
        existing.setEquipment(inventory.getEquipment());

        return repository.saveAndFlush(existing);
    }


    //Update Inventories by playerid
    @Transactional
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.PUT)
    public List<Inventory> updateInventoryByPlayerId(@PathVariable Long playerId, @RequestBody Inventory inventory){
        List<Inventory> existingInventories = new ArrayList<>();
        //existing.updateAll(inventory);

        for(Inventory inv : repository.findAll()){
            if(inv.getPlayerId().equals(playerId)){

                inv.setCopperPiece(inventory.getCopperPiece());
                inv.setSilverPiece(inventory.getSilverPiece());
                inv.setGoldPiece(inventory.getGoldPiece());
                inv.setPlatinumPiece(inventory.getPlatinumPiece());
                inv.setEquipment(inventory.getEquipment());
                existingInventories.add(inv);

                repository.saveAndFlush(inv);
            }
        }

        return existingInventories;
    }




}
