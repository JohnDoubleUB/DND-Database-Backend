package com.qa.controllers;

import com.qa.persistence.models.Inventory;
import com.qa.persistence.repository.InventoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoriesControllerTest {
    @InjectMocks
    private InventoryController inventoriesController;

    @Mock
    private InventoryRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listAllInventoriesTest(){
        List<Inventory> invList = new ArrayList<>();
        Inventory inv = new Inventory();


        inv.setId(1L);
        inv.setGoldPiece(2);
        inv.setEquipment("Big equipment list!");

        invList.add(inv);
        when(repository.findAll()).thenReturn(invList);
        assertEquals(inventoriesController.listAllInventories().get(0).getId(), new Long(1L));
        assertEquals(inventoriesController.listAllInventories().get(0).getGoldPiece(), 2);
        assertEquals(inventoriesController.listAllInventories().get(0).getEquipment(), "Big equipment list!");
    }

    @Test
    public void addInventoryTest(){
        Inventory inv = new Inventory();
        inv.setId(5L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Bag");

        when(repository.saveAndFlush(inv)).thenReturn(inv);

        assertEquals(inventoriesController.addInventory(inv).getId(),new Long(5L));
        assertEquals(inventoriesController.addInventory(inv).getEquipment(),"A Bag");


    }

    @Test
    public void getInventoryTest(){
        Inventory inv = new Inventory();
        inv.setId(5L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Bag");

        Inventory inv2 = new Inventory();
        inv2.setId(8L);
        inv2.setGoldPiece(10);
        inv2.setEquipment("Another Bag");

        when(repository.findOne(anyLong())).thenReturn(inv).thenReturn(inv2);
        assertEquals(inventoriesController.getInventory(3L).getEquipment(), "A Bag");
        assertEquals(inventoriesController.getInventory(66L).getEquipment(), "Another Bag");
    }

    @Test
    public void getInventoryByPlayerIDTest(){
        List<Inventory> invList = new ArrayList<>();
        Inventory inv = new Inventory();
        inv.setId(5L);
        inv.setPlayerId(4L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Bag");

        Inventory inv2 = new Inventory();
        inv2.setPlayerId(2L);
        inv2.setGoldPiece(10);
        inv2.setEquipment("Another Bag");

        Inventory inv3 = new Inventory();
        inv3.setPlayerId(2L);
        inv3.setGoldPiece(10);
        inv3.setEquipment("Another Bag 2");

        invList.add(inv);
        invList.add(inv2);
        invList.add(inv3);

        when(repository.findAll()).thenReturn(invList);
        assertEquals(inventoriesController.getInventoryByPlayerID(4L).get(0).getEquipment(), "A Bag");
        assertEquals(inventoriesController.getInventoryByPlayerID(2L).get(1).getEquipment(), "Another Bag 2");
    }

    @Test
    public void deleteInventoriesTest(){

        Inventory inv = new Inventory();
        inv.setId(21L);
        inv.setPlayerId(2L);
        inv.setGoldPiece(10);
        inv.setEquipment("A small book");
        when(repository.findOne(anyLong())).thenReturn(inv);

        assertEquals(inventoriesController.deleteInventories(2L).getEquipment(), "A small book");


    }

    @Test
    public void deleteInventoryByPlayerID(){
        List<Inventory> invList = new ArrayList<>();
        Inventory inv = new Inventory();
        inv.setId(5L);
        inv.setPlayerId(4L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Bag");

        Inventory inv2 = new Inventory();
        inv2.setPlayerId(7L);
        inv2.setGoldPiece(10);
        inv2.setEquipment("Another Bag");

        Inventory inv3 = new Inventory();
        inv3.setPlayerId(7L);
        inv3.setGoldPiece(10);
        inv3.setEquipment("What");

        invList.add(inv);
        invList.add(inv2);
        invList.add(inv3);

        when(repository.findAll()).thenReturn(invList);
        assertEquals(inventoriesController.deleteInventoryByPlayerID(4L).get(0).getEquipment(), "A Bag");
        assertEquals(inventoriesController.deleteInventoryByPlayerID(7L).get(1).getEquipment(), "What");
    }

    @Test
    public void updateInventoryTest(){
        Inventory inv = new Inventory();
        inv.setPlayerId(40L);
        inv.setId(1L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Big box");

        Inventory inv2 = new Inventory();
        inv2.setPlayerId(8L);
        inv2.setId(2L);
        inv2.setGoldPiece(5);
        inv2.setEquipment("A Small box");


        when(repository.findOne(2L)).thenReturn(inv2);
        when(repository.findOne(1L)).thenReturn(inv);
        when(repository.saveAndFlush(inv2)).thenReturn(inv2);
        when(repository.saveAndFlush(inv)).thenReturn(inv);


        assertEquals(inventoriesController.updateInventory(2L, inv).getEquipment(), "A Big box");
        assertEquals(inventoriesController.updateInventory(2L, inv).getId(), new Long(2L));

        inv2.setPlayerId(8L);
        inv2.setId(2L);
        inv2.setGoldPiece(5);
        inv2.setEquipment("A Small box");

        assertEquals(inventoriesController.updateInventory(1L, inv2).getEquipment(), "A Small box");
        assertEquals(inventoriesController.updateInventory(1L, inv2).getId(), new Long(1L));

    }

    @Test
    public void updateInventoryByPlayerIdTest(){
        List<Inventory> invList = new ArrayList<>();

        Inventory inv = new Inventory();
        inv.setPlayerId(1L);
        inv.setGoldPiece(6);
        inv.setEquipment("A Big box");

        Inventory inv2 = new Inventory();
        inv2.setId(4L);
        inv2.setPlayerId(2L);
        inv2.setGoldPiece(5);
        inv2.setEquipment("A Small box");

        Inventory inv3 = new Inventory();
        inv2.setId(7L);
        inv3.setPlayerId(2L);
        inv3.setGoldPiece(5);
        inv3.setEquipment("A Small box");

        invList.add(inv);
        invList.add(inv2);
        invList.add(inv3);

        when(repository.findAll()).thenReturn(invList);

        assertEquals(inventoriesController.updateInventoryByPlayerId(2L, inv).get(0).getEquipment(), "A Big box");
        assertEquals(inventoriesController.updateInventoryByPlayerId(2L, inv).get(1).getEquipment(), "A Big box");
    }

}
