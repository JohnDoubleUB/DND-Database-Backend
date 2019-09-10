package com.qa.controllers;

import com.qa.repository.InventoryRepository;
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
    private InventoriesController inventoriesController;

    @Mock
    private InventoryRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listAllInventoriesTest(){

    }

    @Test
    public void addInventoryTest(){

    }

    @Test
    public void getInventoryTest(){

    }

    @Test
    public void getInventoryByPlayerIDTest(){

    }

    @Test
    public void deleteInventoriesTest(){

    }

    @Test
    public void deleteInventoryByPlayerID(){

    }

    @Test
    public void updateInventoryTest(){

    }

    @Test
    public void updateInventoryByPlayerIdTest(){

    }

}
