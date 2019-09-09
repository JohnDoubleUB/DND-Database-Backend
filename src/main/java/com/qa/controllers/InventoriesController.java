package com.qa.controllers;


import com.qa.models.Inventories;
import com.qa.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class InventoriesController {

    @Autowired
    private InventoryRepository repository;

    //Get all inventories
    @RequestMapping(value = "inventories", method = RequestMethod.GET)
    public List<Inventories> listAllInventories(){
        return repository.findAll();
    }

    //Add an inventory
    @RequestMapping(value = "inventories", method = RequestMethod.POST)
    public Inventories addInventory(@RequestBody Inventories inventory){
        return repository.saveAndFlush(inventory);
    }

    //Get a singular inventory
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.GET)
    public Inventories getInventory(@PathVariable Long id){
        return repository.findOne(id);
    }

    //Get an inventory by playerId
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.GET)
    public List<Inventories> getInventoryByPlayerID(@PathVariable Long playerId){
        List<Inventories> allInventories = repository.findAll();

        List<Inventories> existingInventories = new ArrayList<>();

        for(Inventories inv : allInventories){
            if(inv.getPlayerId() == playerId){
                existingInventories.add(inv);
            }
        }


        return existingInventories;
    }



    //Delete a singular inventory by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.DELETE)
    public Inventories deleteInventories(@PathVariable Long id){
        Inventories existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    //Delete an inventory by playerId
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.DELETE)
    public List<Inventories> deleteInventoryByPlayerID(@PathVariable Long playerId){

        List<Inventories> existingInventories = new ArrayList<>();

        //List<Inventories> existingInventories = allInventories.stream().filter(i -> i.getPlayerId() == playerId).collect(Collectors.toList());
        //existingInventories.stream().forEach(repository::delete);

        for(Inventories inv : repository.findAll()){
            if(inv.getPlayerId() == playerId){
                existingInventories.add(inv);
                repository.delete(inv);
            }
        }

        return existingInventories;
    }

    //Update Inventories by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.PUT)
    public Inventories updateInventory(@PathVariable Long id, @RequestBody Inventories inventory){
        Inventories existing = repository.findOne(id);

        existing.setCopperPiece(inventory.getCopperPiece());
        existing.setSilverPiece(inventory.getSilverPiece());
        existing.setGoldPiece(inventory.getGoldPiece());
        existing.setPlatinumPiece(inventory.getPlatinumPiece());
        existing.setEquipment(inventory.getEquipment());


        return repository.saveAndFlush(existing);
    }


    //Update Inventories by playerid
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.PUT)
    public List<Inventories> updateInventoryByPlayerId(@PathVariable Long playerId, @RequestBody Inventories inventory){
        List<Inventories> existingInventories = new ArrayList<>();
        //existing.updateAll(inventory);

        for(Inventories inv : repository.findAll()){
            if(inv.getPlayerId() == playerId){
                existingInventories.add(inv);

                inv.setCopperPiece(inventory.getCopperPiece());
                inv.setSilverPiece(inventory.getSilverPiece());
                inv.setGoldPiece(inventory.getGoldPiece());
                inv.setPlatinumPiece(inventory.getPlatinumPiece());
                inv.setEquipment(inventory.getEquipment());

                repository.saveAndFlush(inv);
            }
        }

        return existingInventories;
    }




}
