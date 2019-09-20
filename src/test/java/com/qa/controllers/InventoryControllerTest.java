package com.qa.controllers;

import com.qa.dto.InventoryDto;
import com.qa.dto.PlayerCharacterDto;
import com.qa.service.InventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InventoryControllerTest {

    @InjectMocks
    private InventoryController inventoryController;

    @Mock
    private InventoryService inventoryService;

    @Test
    public void getInventoriesTest(){
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();
        inventoriesDto.add(new InventoryDto(1L, 4L, 2, 4, 5, 6,"some things"));
        inventoriesDto.add(new InventoryDto(3L, 2L, 4, 6, 2, 0,"not alot"));

        Mockito.when(inventoryService.getInventories()).thenReturn(inventoriesDto);

        assertEquals(HttpStatus.OK, inventoryController.getInventories().getStatusCode());

    }


    //return new ResponseEntity<InventoryDto>(service.addInventory(inventoryDto), HttpStatus.CREATED);
    @Test
    public void addInventoryTest(){
        InventoryDto inventoryDto = new InventoryDto(null, 4L, 2, 4, 5, 6,"some things");
        Mockito.when(inventoryService.addInventory(inventoryDto)).thenReturn(new InventoryDto(2L, 4L, 2, 4, 5, 6,"some things"));

        assertEquals((Long) 2L, inventoryController.addInventory(inventoryDto).getBody().getId());
        assertEquals(HttpStatus.CREATED, inventoryController.addInventory(inventoryDto).getStatusCode());

    }

    //return new ResponseEntity<InventoryDto>(service.getInventory(id), HttpStatus.OK);
    @Test
    public void getInventoryTest(){
        InventoryDto inventoryDto = new InventoryDto(2L, 4L, 2, 4, 5, 6,"some things");
        Mockito.when(inventoryService.getInventory(2L)).thenReturn(inventoryDto);

        assertEquals(5, inventoryController.getInventory(2L).getBody().getGoldPiece());
        assertEquals(HttpStatus.OK, inventoryController.getInventory(2L).getStatusCode());
    }

    @Test
    public void getInventoryByPlayerIdTest(){
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();
        inventoriesDto.add(new InventoryDto(2L, 4L, 2, 4, 5, 6,"some things"));
        inventoriesDto.add(new InventoryDto(6L, 1L, 6, 8, 5, 10,"not much"));

        Mockito.when(inventoryService.getInventoryByPlayerId(4L)).thenReturn(inventoriesDto);

        assertEquals((Long) 2L, inventoryController.getInventoryByPlayerID(4L).getBody().get(0).getId());
        assertEquals(HttpStatus.OK, inventoryController.getInventoryByPlayerID(2L).getStatusCode());
    }

    @Test
    public void deleteInventoryTest(){

    }

    @Test
    public void deleteInventoryByPlayerIdTest(){

    }

    @Test
    public void updateInventoryTest(){

    }

    @Test
    public void updateInventoryByPlayerIdTest(){

    }


}
