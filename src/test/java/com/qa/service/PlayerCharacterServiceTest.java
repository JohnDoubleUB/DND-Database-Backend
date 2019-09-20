package com.qa.service;

import com.qa.dto.PlayerCharacterDto;
import com.qa.persistence.models.PlayerCharacter;
import com.qa.persistence.repository.PlayerCharacterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PlayerCharacterServiceTest {

    @Mock
    private PlayerCharacterRepository repository;

    @InjectMocks
    private PlayerCharacterService playerCharacterService;

    @Test
    public void getCharactersTest(){
        List<PlayerCharacter> playerCharacters = new ArrayList<>();
        List<PlayerCharacterDto> playerCharacterDtos = new ArrayList<PlayerCharacterDto>();

        playerCharacters.add(new PlayerCharacter(2L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 ));
        playerCharacters.add(new PlayerCharacter(1L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 ));

        playerCharacterDtos.add(new PlayerCharacterDto(playerCharacters.get(0)));
        playerCharacterDtos.add(new PlayerCharacterDto(playerCharacters.get(1)));

        Mockito.when(repository.findAll()).thenReturn(playerCharacters);

        assertEquals("Socrowtes", playerCharacterService.getCharacters().get(0).getName());
        assertEquals(new Long(2L), playerCharacterService.getCharacters().get(0).getId());
        assertEquals("CrowBar", playerCharacterService.getCharacters().get(1).getName());
        assertEquals(new Long(1L), playerCharacterService.getCharacters().get(1).getId());
    }

    @Test
    public void getCharacterTest(){

    }

    @Test
    public void addCharacterTest(){

    }

    @Test
    public void deleteCharacterTest(){

    }

    @Test
    public void updateCharacterTest(){

    }

}
