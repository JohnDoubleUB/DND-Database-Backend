package com.qa.service;

import com.qa.dto.PlayerCharacterDto;
import com.qa.persistence.models.PlayerCharacter;
import com.qa.persistence.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerCharacterService {
    @Autowired
    private PlayerCharacterRepository repository;


    public List<PlayerCharacterDto> getPlayerCharacters(){
        List<PlayerCharacter> playerCharacters = repository.findAll();
        List<PlayerCharacterDto> playerCharactersDto = new ArrayList<PlayerCharacterDto>();
        playerCharacters.forEach(pc -> playerCharactersDto.add(new PlayerCharacterDto(pc)));
        return playerCharactersDto;
    }

    public PlayerCharacterDto addCharacter(PlayerCharacterDto playerCharactersDto){
        playerCharactersDto.setId(null);
        PlayerCharacter playerCharacter = PlayerCharacter.createPlayerCharacter();

        playerCharacter.setName(playerCharactersDto.getName());
        playerCharacter.setRace(playerCharactersDto.getRace());
        playerCharacter.setPlayerClass(playerCharactersDto.getPlayerClass());
        playerCharacter.setAlignment(playerCharactersDto.getAlignment());
        playerCharacter.setBackground(playerCharactersDto.getBackground());
        playerCharacter.setLevel(playerCharactersDto.getLevel());
        playerCharacter.setBaseStr(playerCharactersDto.getBaseStr());
        playerCharacter.setBaseInt(playerCharactersDto.getBaseInt());
        playerCharacter.setBaseDex(playerCharactersDto.getBaseDex());
        playerCharacter.setBaseCon(playerCharactersDto.getBaseCon());
        playerCharacter.setBaseWis(playerCharactersDto.getBaseWis());
        playerCharacter.setBaseCha(playerCharactersDto.getBaseCha());
        playerCharacter.setBaseHP(playerCharactersDto.getBaseHP());
        playerCharacter.setBaseProficiency(playerCharactersDto.getBaseProficiency());
        return new PlayerCharacterDto()
    }

}
