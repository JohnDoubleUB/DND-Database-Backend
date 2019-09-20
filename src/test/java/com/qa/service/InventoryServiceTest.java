package com.qa.service;

import com.qa.dto.InventoryDto;
import com.qa.persistence.models.Inventory;
import com.qa.persistence.repository.InventoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryService inventoryService;

    //Long id, Long playerId, int copperPiece, int silverPiece, int goldPiece, int platinumPiece, String equipment
    @Test
    public void getInventoriesTest(){
        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(new Inventory(1L, 2L, 4, 5, 6, 0, "Not much"));
        inventories.add(new Inventory(2L, 4L, 7, 8, 20, 2, "Slightly more"));

        List<InventoryDto> inventoryDtos = new ArrayList<InventoryDto>();
        inventoryDtos.add(new InventoryDto(1L, 2L, 4, 5, 6, 0, "Not much"));
        inventoryDtos.add(new InventoryDto(2L, 4L, 7, 8, 20, 2, "Slightly more"));

        Mockito.when(repository.findAll()).thenReturn(inventories);

        assertEquals(inventoryDtos.get(1).getId(), inventoryService.getInventories().get(1).getId());
        assertEquals(inventoryDtos.get(1).getPlayerId(), inventoryService.getInventories().get(1).getPlayerId());
        assertEquals(inventoryDtos.get(1).getCopperPiece(), inventoryService.getInventories().get(1).getCopperPiece());
        assertEquals(inventoryDtos.get(1).getSilverPiece(), inventoryService.getInventories().get(1).getSilverPiece());
        assertEquals(inventoryDtos.get(1).getPlatinumPiece(), inventoryService.getInventories().get(1).getPlatinumPiece());
        assertEquals(inventoryDtos.get(1).getEquipment(), inventoryService.getInventories().get(1).getEquipment());
    }

//    @Test
//    public void addInventoryTest(){
//
//    }

    @Test
    public void getInventoryTest(){
        Long id = 1L;

        Inventory inventory = new Inventory(1L, 2L, 4, 5, 6, 0, "Not much");
        InventoryDto inventoryDto = new InventoryDto(1L, 2L, 4, 5, 6, 0, "Not much");

        Mockito.when(repository.getOne(id)).thenReturn(inventory);

        assertEquals(inventoryDto.getId(), inventoryService.getInventory(id).getId());
        assertEquals(inventoryDto.getPlayerId(), inventoryService.getInventory(id).getPlayerId());
        assertEquals(inventoryDto.getCopperPiece(), inventoryService.getInventory(id).getCopperPiece());
        assertEquals(inventoryDto.getSilverPiece(), inventoryService.getInventory(id).getSilverPiece());
        assertEquals(inventoryDto.getGoldPiece(), inventoryService.getInventory(id).getGoldPiece());
        assertEquals(inventoryDto.getPlatinumPiece(), inventoryService.getInventory(id).getPlatinumPiece());
        assertEquals(inventoryDto.getEquipment(), inventoryService.getInventory(id).getEquipment());
    }

    @Test
    public void getInventoryByPlayerIdTest(){
        Long id = 2L;

        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(new Inventory(1L, 4L, 7, 8, 6, 0, "ignore"));
        inventories.add(new Inventory(1L, 2L, 4, 5, 6, 0, "Not much"));

        InventoryDto inventoryDto = new InventoryDto(1L, 2L, 4, 5, 6, 0, "Not much");

        Mockito.when(repository.findAll()).thenReturn(inventories);

        assertEquals(inventoryDto.getId(), inventoryService.getInventoryByPlayerId(id).get(0).getId());
        assertEquals(inventoryDto.getPlayerId(), inventoryService.getInventoryByPlayerId(id).get(0).getPlayerId());
        assertEquals(inventoryDto.getCopperPiece(), inventoryService.getInventoryByPlayerId(id).get(0).getCopperPiece());
        assertEquals(inventoryDto.getSilverPiece(), inventoryService.getInventoryByPlayerId(id).get(0).getSilverPiece());
        assertEquals(inventoryDto.getGoldPiece(), inventoryService.getInventoryByPlayerId(id).get(0).getGoldPiece());
        assertEquals(inventoryDto.getPlatinumPiece(), inventoryService.getInventoryByPlayerId(id).get(0).getPlatinumPiece());
        assertEquals(inventoryDto.getEquipment(), inventoryService.getInventoryByPlayerId(id).get(0).getEquipment());
    }

    @Test
    public void deleteInventoryTest(){
        Long id = 1L;
        Inventory inventory = new Inventory(1L, 2L, 4, 5, 6, 0, "Not much here");

        Mockito.when(repository.getOne(id)).thenReturn(inventory);
        assertEquals("Not much here", inventoryService.deleteInventory(id).getEquipment());
        verify(repository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void deleteInventoryByPlayerIdTest(){
        Long playerId = 2L;

        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(new Inventory(1L, 4L, 7, 8, 6, 0, "ignore"));
        inventories.add(new Inventory(1L, 2L, 4, 5, 6, 0, "Not much here"));

        Mockito.when(repository.findAll()).thenReturn(inventories);

        assertEquals("Not much here", inventoryService.deleteInventoryByPlayerId(playerId).get(0).getEquipment());
        verify(repository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void updateInventoryTest(){
        InventoryDto inventoryDto = new InventoryDto(1L, 4L, 7, 8, 6, 0, "ignore");
        Inventory inventory = new Inventory(1L, 2L, 4, 5, 6, 0, "Not much here");

        Mockito.when(repository.getOne(inventoryDto.getId())).thenReturn(inventory);

        assertEquals(inventoryDto.getEquipment(), inventoryService.updateInventory(inventoryDto.getId(), inventoryDto).getEquipment());
        assertEquals(inventoryDto.getId(), inventoryService.updateInventory(inventoryDto.getId(), inventoryDto).getId());
    }

    @Test
    public void updateInventoryByPlayerIdTest(){
        Long playerId = 2L;

        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(new Inventory(1L, 4L, 7, 8, 6, 0, "ignore"));
        inventories.add(new Inventory(1L, 2L, 4, 3, 9, 10, "Not much"));

        InventoryDto inventoryDto = new InventoryDto(4L, 2L, 4, 5, 6, 0, "Not much updated");

        Mockito.when(repository.findAll()).thenReturn(inventories);

        assertEquals(inventoryDto.getEquipment(), inventoryService.updateInventoryByPlayerId(playerId, inventoryDto).get(0).getEquipment());
        assertEquals((Long)1L, inventoryService.updateInventoryByPlayerId(playerId, inventoryDto).get(0).getId());
    }
}
