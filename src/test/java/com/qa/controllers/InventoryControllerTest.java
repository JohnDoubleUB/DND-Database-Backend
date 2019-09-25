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
        Long id = 4L;
        InventoryDto inventoryDto = new InventoryDto(4L, 1L, 6, 8, 5, 10,"not much");

        Mockito.when(inventoryService.deleteInventory(id)).thenReturn(inventoryDto);

        assertEquals((Long) 4L, inventoryController.deleteInventory(id).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, inventoryController.deleteInventory(id).getStatusCode());
    }

    @Test
    public void deleteInventoryByPlayerIdTest(){
        Long playerId = 2L;
        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();
        inventoriesDto.add(new InventoryDto(4L, 2L, 2, 4, 5, 6,"some things"));
        inventoriesDto.add(new InventoryDto(6L, 1L, 6, 8, 5, 10,"not much"));

        Mockito.when(inventoryService.deleteInventoryByPlayerId(playerId)).thenReturn(inventoriesDto);

        assertEquals((Long) 4L, inventoryController.deleteInventoryByPlayerId(playerId).getBody().get(0).getId());
        assertEquals(HttpStatus.ACCEPTED, inventoryController.deleteInventoryByPlayerId(playerId).getStatusCode());
    }

    @Test
    public void updateInventoryTest(){
        InventoryDto inventoryDto = new InventoryDto(null, 1L, 6, 8, 5, 10,"not much");

        Mockito.when(inventoryService.updateInventory(2L, inventoryDto)).thenReturn(new InventoryDto(2L, 1L, 6, 8, 5, 10,"not much"));

        assertEquals((Long) 2L, inventoryController.updateInventory(2L, inventoryDto).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, inventoryController.updateInventory(2L, inventoryDto).getStatusCode());
    }

    @Test
    public void updateInventoryByPlayerIdTest(){
        InventoryDto inventoryDto = new InventoryDto(null, 2L, 2, 4, 5, 6,"some things");

        List<InventoryDto> inventoriesDto = new ArrayList<InventoryDto>();
        inventoriesDto.add(new InventoryDto(1L, 2L, 2, 4, 5, 6,"some things"));
        inventoriesDto.add(new InventoryDto(2L, 2L, 2, 4, 5, 6,"some things"));

        Mockito.when(inventoryService.updateInventoryByPlayerId(2L, inventoryDto)).thenReturn(inventoriesDto);

        assertEquals((Long) 2L, inventoryController.updateInventoryByPlayerId(2L, inventoryDto).getBody().get(0).getPlayerId());
        assertEquals(HttpStatus.ACCEPTED, inventoryController.updateInventoryByPlayerId(2L, inventoryDto).getStatusCode());

    }


}
