package com.qa.controllers;


import com.qa.repository.PlayerCharacterRepository;
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
public class PlayerCharactersControllerTest {

    @InjectMocks
    private PlayerCharactersController inventoriesController;

    @Mock
    private PlayerCharacterRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void listAllCharactersTest(){

    }

    @Test
    public void addCharacterTest(){

    }

    @Test
    public void getCharacterTest(){

    }

    @Test
    public void deleteCharacterTest(){

    }

    @Test
    public void updateCharacterTest(){

    }
}