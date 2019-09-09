package com.qa.controllers;


import com.qa.models.Inventories;
import com.qa.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "notes/{id}", method = RequestMethod.GET)
    public Inventories getInventory(@PathVariable Long id){
        return repository.findOne(id);
    }

    //Delete a singular inventory
    @RequestMapping(value = "notes/{id}", method = RequestMethod.DELETE)
    public Inventories deleteInventories(@PathVariable Long id){
        Inventories existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

}
