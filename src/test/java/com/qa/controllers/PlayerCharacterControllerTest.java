package com.qa.controllers;

import com.qa.dto.PlayerCharacterDto;
import com.qa.service.PlayerCharacterService;
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
public class PlayerCharacterControllerTest {

    @InjectMocks
    private PlayerCharacterController playerCharacterController;

    @Mock
    private PlayerCharacterService playerCharacterService;

    @Test
    public void getCharactersTest(){
        List<PlayerCharacterDto> characters = new ArrayList<PlayerCharacterDto>();
        PlayerCharacterDto p1 = new PlayerCharacterDto(2L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );
        PlayerCharacterDto p2 = new PlayerCharacterDto(1L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 );

        characters.add(p1);
        characters.add(p2);

        Mockito.when(playerCharacterService.getCharacters()).thenReturn(characters);

        assertEquals(HttpStatus.OK, playerCharacterController.getCharacters().getStatusCode());
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
