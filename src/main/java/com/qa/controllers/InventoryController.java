package com.qa.controllers;


import com.qa.dto.InventoryDto;
import com.qa.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class InventoryController {

    @Autowired
    private InventoryService service;

    //Get all inventories
    @RequestMapping(value = "inventories", method = RequestMethod.GET)
    public ResponseEntity<List<InventoryDto>> getInventories(){
        return new ResponseEntity<List<InventoryDto>>(service.getInventories(), HttpStatus.OK);
    }

    //Add an inventory
    @RequestMapping(value = "inventories", method = RequestMethod.POST)
    public ResponseEntity<InventoryDto> addInventory(@RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<InventoryDto>(service.addInventory(inventoryDto), HttpStatus.CREATED);
    }

    //Get an inventory by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.GET)
    public ResponseEntity<InventoryDto> getInventory(@PathVariable Long id){
        return new ResponseEntity<InventoryDto>(service.getInventory(id), HttpStatus.OK);
    }

    //Get an inventory by playerId
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.GET)
    public ResponseEntity<List<InventoryDto>> getInventoryByPlayerID(@PathVariable Long playerId){
        return new ResponseEntity<List<InventoryDto>>(service.getInventoryByPlayerId(playerId), HttpStatus.OK);
    }


    //Delete an inventory by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<InventoryDto> deleteInventory(@PathVariable Long id){
        return new ResponseEntity<InventoryDto>(service.deleteInventory(id), HttpStatus.ACCEPTED);
    }

    //Delete an inventory by playerId
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<InventoryDto>> deleteInventoryByPlayerId(@PathVariable Long playerId){
        return new ResponseEntity<List<InventoryDto>>(service.deleteInventoryByPlayerId(playerId), HttpStatus.ACCEPTED);
    }

    //Update Inventories by id
    @RequestMapping(value = "inventories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable Long id, @RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<InventoryDto>(service.updateInventory(id, inventoryDto), HttpStatus.ACCEPTED);
    }


    //Update Inventories by playerid
    @RequestMapping(value = "inventories/playerid/{playerId}", method = RequestMethod.PUT)
    public ResponseEntity<List<InventoryDto>> updateInventoryByPlayerId(@PathVariable Long playerId, @RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<List<InventoryDto>>(service.updateInventoryByPlayerId(playerId, inventoryDto), HttpStatus.ACCEPTED);
    }




}
