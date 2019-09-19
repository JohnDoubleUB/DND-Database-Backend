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


    public List<PlayerCharacterDto> getCharacters(){
        List<PlayerCharacter> playerCharacters = repository.findAll();
        List<PlayerCharacterDto> playerCharactersDto = new ArrayList<PlayerCharacterDto>();
        playerCharacters.forEach(pc -> playerCharactersDto.add(new PlayerCharacterDto(pc)));
        return playerCharactersDto;
    }

    public PlayerCharacterDto addCharacter(PlayerCharacterDto playerCharacterDto){
        playerCharacterDto.setId(null);
        PlayerCharacter playerCharacter = PlayerCharacter.createPlayerCharacter();

        playerCharacter.setName(playerCharacterDto.getName());
        playerCharacter.setRace(playerCharacterDto.getRace());
        playerCharacter.setPlayerClass(playerCharacterDto.getPlayerClass());
        playerCharacter.setAlignment(playerCharacterDto.getAlignment());
        playerCharacter.setBackground(playerCharacterDto.getBackground());
        playerCharacter.setLevel(playerCharacterDto.getLevel());
        playerCharacter.setBaseStr(playerCharacterDto.getBaseStr());
        playerCharacter.setBaseInt(playerCharacterDto.getBaseInt());
        playerCharacter.setBaseDex(playerCharacterDto.getBaseDex());
        playerCharacter.setBaseCon(playerCharacterDto.getBaseCon());
        playerCharacter.setBaseWis(playerCharacterDto.getBaseWis());
        playerCharacter.setBaseCha(playerCharacterDto.getBaseCha());
        playerCharacter.setBaseHP(playerCharacterDto.getBaseHP());
        playerCharacter.setBaseProficiency(playerCharacterDto.getBaseProficiency());

        return new PlayerCharacterDto(repository.saveAndFlush(playerCharacter));
    }

    public PlayerCharacterDto getCharacter(Long id){
        PlayerCharacter playerCharacter = repository.getOne(id);
        return new PlayerCharacterDto(playerCharacter);
    }

    public PlayerCharacterDto deleteCharacter(Long id){
        PlayerCharacter playerCharacter = repository.getOne(id);
        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(playerCharacter);
        repository.deleteById(id);
        return playerCharacterDto;
    }

    public PlayerCharacterDto updateCharacter(Long id, PlayerCharacterDto playerCharacterDto){
        PlayerCharacter playerCharacter = repository.getOne(id);

        playerCharacter.setName(playerCharacterDto.getName());
        playerCharacter.setRace(playerCharacterDto.getRace());
        playerCharacter.setPlayerClass(playerCharacterDto.getPlayerClass());
        playerCharacter.setAlignment(playerCharacterDto.getAlignment());
        playerCharacter.setBackground(playerCharacterDto.getBackground());
        playerCharacter.setLevel(playerCharacterDto.getLevel());
        playerCharacter.setBaseStr(playerCharacterDto.getBaseStr());
        playerCharacter.setBaseInt(playerCharacterDto.getBaseInt());
        playerCharacter.setBaseDex(playerCharacterDto.getBaseDex());
        playerCharacter.setBaseCon(playerCharacterDto.getBaseCon());
        playerCharacter.setBaseWis(playerCharacterDto.getBaseWis());
        playerCharacter.setBaseCha(playerCharacterDto.getBaseCha());
        playerCharacter.setBaseHP(playerCharacterDto.getBaseHP());
        playerCharacter.setBaseProficiency(playerCharacterDto.getBaseProficiency());

        repository.flush();
        return new PlayerCharacterDto(playerCharacter);
    }



}
