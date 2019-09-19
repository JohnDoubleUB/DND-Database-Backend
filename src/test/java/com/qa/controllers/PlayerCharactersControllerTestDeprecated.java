package com.qa.controllers;


import com.qa.persistence.models.PlayerCharacter;
import com.qa.persistence.repository.PlayerCharacterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerCharactersControllerTestDeprecated {

//    @InjectMocks
//    private PlayerCharacterController playerCharactersController;
//
//    @Mock
//    private PlayerCharacterRepository repository;
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//
//    @Test
//    public void listAllCharactersTest(){
//        List<PlayerCharacter> charList = new ArrayList<>();
//
//        PlayerCharacter chara = new PlayerCharacter();
//        chara.setName("Bob");
//        chara.setId(2L);
//
//        PlayerCharacter chara2 = new PlayerCharacter();
//        chara2.setName("Joey");
//        chara2.setId(4L);
//
//        charList.add(chara);
//        charList.add(chara2);
//        when(repository.findAll()).thenReturn(charList);
//
//        assertEquals(playerCharactersController.listAllCharacters().get(0).getName(), "Bob");
//        assertEquals(playerCharactersController.listAllCharacters().get(0).getId(), new Long(2L));
//        assertEquals(playerCharactersController.listAllCharacters().get(1).getName(), "Joey");
//        assertEquals(playerCharactersController.listAllCharacters().get(1).getId(), new Long(4L));
//    }
//
//    @Test
//    public void addCharacterTest(){
//        PlayerCharacter chara = new PlayerCharacter();
//        chara.setName("Debra");
//        chara.setId(5L);
//
//        when(repository.saveAndFlush(chara)).thenReturn(chara);
//
//        assertEquals(playerCharactersController.addCharacter(chara).getName(), "Debra");
//        assertEquals(playerCharactersController.addCharacter(chara).getId(), new Long(5L));
//    }
//
//    @Test
//    public void getCharacterTest(){
//        PlayerCharacter chara = new PlayerCharacter();
//        chara.setName("Brian");
//        chara.setRace("Man");
//        chara.setPlayerClass("Monk");
//        chara.setAlignment("Evil");
//        chara.setId(5L);
//
//        when(repository.findOne(anyLong())).thenReturn(chara);
//
//        assertEquals(playerCharactersController.getCharacter(anyLong()).getName(), "Brian");
//        assertEquals(playerCharactersController.getCharacter(anyLong()).getRace(), "Man");
//        assertEquals(playerCharactersController.getCharacter(anyLong()).getPlayerClass(), "Monk");
//        assertEquals(playerCharactersController.getCharacter(anyLong()).getAlignment(), "Evil");
//        assertEquals(playerCharactersController.getCharacter(anyLong()).getId(), new Long(5L));
//
//    }
//
//    @Test
//    public void deleteCharacterTest(){
//        PlayerCharacter chara = new PlayerCharacter();
//        chara.setName("Owen");
//        chara.setRace("Elf");
//
//        PlayerCharacter chara2 = new PlayerCharacter();
//        chara2.setName("Stevo");
//        chara2.setRace("Orc");
//
//        when(repository.findOne(1L)).thenReturn(chara);
//        when(repository.findOne(2L)).thenReturn(chara2);
//
//        assertEquals(playerCharactersController.deleteCharacter(1L).getName(), "Owen");
//        assertEquals(playerCharactersController.deleteCharacter(2L).getName(), "Stevo");
//
//    }
//
//    @Test
//    public void updateCharacterTest(){
//        PlayerCharacter ch1 = new PlayerCharacter();
//        ch1.setId(1L);
//        ch1.setName("bobby");
//        ch1.setRace("elf");
//
//        PlayerCharacter ch2 = new PlayerCharacter();
//        ch2.setId(2L);
//        ch2.setName("joey");
//        ch2.setRace("orc");
//
//
//        when(repository.findOne(2L)).thenReturn(ch2);
//        when(repository.findOne(1L)).thenReturn(ch1);
//        when(repository.saveAndFlush(ch2)).thenReturn(ch2);
//        when(repository.saveAndFlush(ch1)).thenReturn(ch1);
//
//
//        assertEquals(playerCharactersController.updateCharacter(2L, ch1).getName(), "bobby");
//        assertEquals(playerCharactersController.updateCharacter(2L, ch1).getId(), new Long(2L));
//
//        ch2.setId(2L);
//        ch2.setName("joey");
//        ch2.setRace("orc");
//
//        assertEquals(playerCharactersController.updateCharacter(1L, ch2).getName(), "joey");
//        assertEquals(playerCharactersController.updateCharacter(1L, ch2).getId(), new Long(1L));
//    }
}
