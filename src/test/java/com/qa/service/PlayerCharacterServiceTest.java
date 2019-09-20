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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerCharacterServiceTest {

    @Mock
    private PlayerCharacterRepository repository;

    @InjectMocks
    private PlayerCharacterService playerCharacterService;

    @Test
    public void getCharactersTest(){
        List<PlayerCharacter> playerCharacters = new ArrayList<PlayerCharacter>();
        List<PlayerCharacterDto> playerCharacterDtos = new ArrayList<PlayerCharacterDto>();

        playerCharacters.add(new PlayerCharacter(2L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 ));
        playerCharacters.add(new PlayerCharacter(1L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 ));

        playerCharacterDtos.add(new PlayerCharacterDto(playerCharacters.get(0)));
        playerCharacterDtos.add(new PlayerCharacterDto(playerCharacters.get(1)));

        Mockito.when(repository.findAll()).thenReturn(playerCharacters);

        assertEquals(playerCharacterDtos.get(0).getName(), playerCharacterService.getCharacters().get(0).getName());
        assertEquals(playerCharacterDtos.get(0).getId(), playerCharacterService.getCharacters().get(0).getId());
        assertEquals(playerCharacterDtos.get(0).getAlignment(), playerCharacterService.getCharacters().get(0).getAlignment());
        assertEquals(playerCharacterDtos.get(0).getBackground(), playerCharacterService.getCharacters().get(0).getBackground());
        assertEquals(playerCharacterDtos.get(0).getPlayerClass(), playerCharacterService.getCharacters().get(0).getPlayerClass());
        assertEquals(playerCharacterDtos.get(0).getRace(), playerCharacterService.getCharacters().get(0).getRace());
        assertEquals(playerCharacterDtos.get(0).getLevel(), playerCharacterService.getCharacters().get(0).getLevel());
        assertEquals(playerCharacterDtos.get(0).getBaseCha(), playerCharacterService.getCharacters().get(0).getBaseCha());
        assertEquals(playerCharacterDtos.get(0).getBaseStr(), playerCharacterService.getCharacters().get(0).getBaseStr());
        assertEquals(playerCharacterDtos.get(0).getBaseInt(), playerCharacterService.getCharacters().get(0).getBaseInt());
        assertEquals(playerCharacterDtos.get(0).getBaseDex(), playerCharacterService.getCharacters().get(0).getBaseDex());
        assertEquals(playerCharacterDtos.get(0).getBaseCon(), playerCharacterService.getCharacters().get(0).getBaseCon());
        assertEquals(playerCharacterDtos.get(0).getBaseWis(), playerCharacterService.getCharacters().get(0).getBaseWis());
        assertEquals(playerCharacterDtos.get(0).getBaseHP(), playerCharacterService.getCharacters().get(0).getBaseHP());
        assertEquals(playerCharacterDtos.get(0).getBaseProficiency(), playerCharacterService.getCharacters().get(0).getBaseProficiency());
    }


    @Test
    public void addCharacterTest(){
        PlayerCharacter playerCharacter = new PlayerCharacter(null, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(2L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );

        Mockito.when(repository.saveAndFlush(any())).thenReturn(playerCharacter);

        assertEquals(playerCharacter.getId(), playerCharacterService.addCharacter(playerCharacterDto).getId());
    }


    @Test
    public void getCharacterTest(){
        Long id = 1L;

        PlayerCharacter playerCharacter = new PlayerCharacter(1L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(playerCharacter);

        Mockito.when(repository.getOne(id)).thenReturn(playerCharacter);

        assertEquals(playerCharacterDto.getName(), playerCharacterService.getCharacter(id).getName());
        assertEquals(playerCharacterDto.getId(), playerCharacterService.getCharacter(id).getId());
        assertEquals(playerCharacterDto.getAlignment(), playerCharacterService.getCharacter(id).getAlignment());
        assertEquals(playerCharacterDto.getBackground(), playerCharacterService.getCharacter(id).getBackground());
        assertEquals(playerCharacterDto.getPlayerClass(), playerCharacterService.getCharacter(id).getPlayerClass());
        assertEquals(playerCharacterDto.getRace(), playerCharacterService.getCharacter(id).getRace());
        assertEquals(playerCharacterDto.getLevel(), playerCharacterService.getCharacter(id).getLevel());
        assertEquals(playerCharacterDto.getBaseCha(), playerCharacterService.getCharacter(id).getBaseCha());
        assertEquals(playerCharacterDto.getBaseStr(), playerCharacterService.getCharacter(id).getBaseStr());
        assertEquals(playerCharacterDto.getBaseInt(), playerCharacterService.getCharacter(id).getBaseInt());
        assertEquals(playerCharacterDto.getBaseDex(), playerCharacterService.getCharacter(id).getBaseDex());
        assertEquals(playerCharacterDto.getBaseCon(), playerCharacterService.getCharacter(id).getBaseCon());
        assertEquals(playerCharacterDto.getBaseWis(), playerCharacterService.getCharacter(id).getBaseWis());
        assertEquals(playerCharacterDto.getBaseHP(), playerCharacterService.getCharacter(id).getBaseHP());
        assertEquals(playerCharacterDto.getBaseProficiency(), playerCharacterService.getCharacter(id).getBaseProficiency());
    }

    @Test
    public void deleteCharacterTest(){
        Long id = 1L;
        PlayerCharacter playerCharacter = new PlayerCharacter(1L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );

        Mockito.when(repository.getOne(id)).thenReturn(playerCharacter);

        assertEquals("Socrowtes", playerCharacterService.deleteCharacter(id).getName());

        verify(repository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void updateCharacterTest(){
        PlayerCharacter playerCharacter = new PlayerCharacter(1L, "Socrowtes", "Kenku", "Monk", "Chaotic Neutral", "Criminal", 4, 10, 10, 15, 17, 10, 28, 22, 2 );
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(1L, "CrowBar", "Kenku", "Bard", "Neutral", "Noble", 4, 10, 14, 15, 12, 10, 30, 22, 4 );

        Mockito.when(repository.getOne(playerCharacterDto.getId())).thenReturn(playerCharacter);
        assertEquals(playerCharacterDto.getName(), playerCharacterService.updateCharacter(playerCharacterDto.getId(), playerCharacterDto).getName());
        assertEquals(playerCharacter.getId(), playerCharacterService.updateCharacter(playerCharacterDto.getId(),playerCharacterDto).getId());
    }

}
