package com.qa.controllers;


import com.qa.models.PlayerCharacters;
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
    private PlayerCharactersController playerCharactersController;

    @Mock
    private PlayerCharacterRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void listAllCharactersTest(){
        List<PlayerCharacters> charList = new ArrayList<>();

        PlayerCharacters chara = new PlayerCharacters();
        chara.setName("Bob");
        chara.setId(2L);

        PlayerCharacters chara2 = new PlayerCharacters();
        chara2.setName("Joey");
        chara2.setId(4L);

        charList.add(chara);
        charList.add(chara2);
        when(repository.findAll()).thenReturn(charList);

        assertEquals(playerCharactersController.listAllCharacters().get(0).getName(), "Bob");
        assertEquals(playerCharactersController.listAllCharacters().get(0).getId(), 2L);
        assertEquals(playerCharactersController.listAllCharacters().get(1).getName(), "Joey");
        assertEquals(playerCharactersController.listAllCharacters().get(1).getId(), 4L);
    }

    @Test
    public void addCharacterTest(){
        PlayerCharacters chara = new PlayerCharacters();
        chara.setName("Debra");
        chara.setId(5L);

        when(repository.saveAndFlush(chara)).thenReturn(chara);

        assertEquals(playerCharactersController.addCharacter(chara).getName(), "Debra");
        assertEquals(playerCharactersController.addCharacter(chara).getId(), 5L);
    }

    @Test
    public void getCharacterTest(){
        PlayerCharacters chara = new PlayerCharacters();
        chara.setName("Brian");
        chara.setRace("Man");
        chara.setPlayerClass("Monk");
        chara.setAlignment("Evil");
        chara.setId(5L);

        when(repository.findOne(anyLong())).thenReturn(chara);

        assertEquals(playerCharactersController.getCharacter(anyLong()).getName(), "Brian");
        assertEquals(playerCharactersController.getCharacter(anyLong()).getRace(), "Man");
        assertEquals(playerCharactersController.getCharacter(anyLong()).getPlayerClass(), "Monk");
        assertEquals(playerCharactersController.getCharacter(anyLong()).getAlignment(), "Evil");
        assertEquals(playerCharactersController.getCharacter(anyLong()).getId(), 5L);

    }

    @Test
    public void deleteCharacterTest(){
        PlayerCharacters chara = new PlayerCharacters();
        chara.setName("Owen");
        chara.setRace("Elf");

        PlayerCharacters chara2 = new PlayerCharacters();
        chara2.setName("Stevo");
        chara2.setRace("Orc");

        when(repository.findOne(1L)).thenReturn(chara);
        when(repository.findOne(2L)).thenReturn(chara2);

        assertEquals(playerCharactersController.deleteCharacter(1L).getName(), "Owen");
        assertEquals(playerCharactersController.deleteCharacter(2L).getName(), "Stevo");

    }

    @Test
    public void updateCharacterTest(){
        PlayerCharacters ch1 = new PlayerCharacters();
        ch1.setId(1L);
        ch1.setName("bobby");
        ch1.setRace("elf");

        PlayerCharacters ch2 = new PlayerCharacters();
        ch2.setId(2L);
        ch2.setName("joey");
        ch2.setRace("orc");


        when(repository.findOne(2L)).thenReturn(ch2);
        when(repository.findOne(1L)).thenReturn(ch1);
        when(repository.saveAndFlush(ch2)).thenReturn(ch2);
        when(repository.saveAndFlush(ch1)).thenReturn(ch1);


        assertEquals(playerCharactersController.updateCharacter(2L, ch1).getName(), "bobby");
        assertEquals(playerCharactersController.updateCharacter(2L, ch1).getId(), 2L);

        ch2.setId(2L);
        ch2.setName("joey");
        ch2.setRace("orc");

        assertEquals(playerCharactersController.updateCharacter(1L, ch2).getName(), "joey");
        assertEquals(playerCharactersController.updateCharacter(1L, ch2).getId(), 1L);
    }
}
