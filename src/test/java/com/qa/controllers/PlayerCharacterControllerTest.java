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
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(4L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );
        Mockito.when(playerCharacterService.addCharacter(playerCharacterDto)).thenReturn(new PlayerCharacterDto(4L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 ));

        assertEquals((Long) 4L, playerCharacterController.addCharacter(playerCharacterDto).getBody().getId());
        assertEquals(HttpStatus.CREATED, playerCharacterController.addCharacter(playerCharacterDto).getStatusCode());
    }

    @Test
    public void getCharacterTest(){
        //return new ResponseEntity<PlayerCharacterDto>(service.getCharacter(id), HttpStatus.OK);
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(6L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 );

        Mockito.when(playerCharacterService.getCharacter(6L)).thenReturn(playerCharacterDto);

        assertEquals("CrowBar", playerCharacterController.getCharacter(6L).getBody().getName());
        assertEquals(HttpStatus.OK, playerCharacterController.getCharacter(6L).getStatusCode());
    }

    @Test
    public void deleteCharacterTest(){
        Long id = 4L;
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(4L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );

        Mockito.when(playerCharacterService.deleteCharacter(id)).thenReturn(playerCharacterDto);

        assertEquals((Long) 4L, playerCharacterController.deleteCharacter(id).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, playerCharacterController.deleteCharacter(id).getStatusCode());


    }

    @Test
    public void updateCharacterTest(){
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(4L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 );
        Mockito.when(playerCharacterService.updateCharacter(4L, playerCharacterDto)).thenReturn(playerCharacterDto);

        assertEquals((Long) 4L, playerCharacterController.updateCharacter(4L, playerCharacterDto).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, playerCharacterController.updateCharacter(4L, playerCharacterDto).getStatusCode());


    }

}
