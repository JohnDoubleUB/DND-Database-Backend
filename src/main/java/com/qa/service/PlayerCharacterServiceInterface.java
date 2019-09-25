package com.qa.service;

import com.qa.dto.PlayerCharacterDto;
import java.util.List;

public interface PlayerCharacterServiceInterface {

    List<PlayerCharacterDto> getCharacters();

    PlayerCharacterDto addCharacter(PlayerCharacterDto playerCharacterDto);

    PlayerCharacterDto getCharacter(Long id);

    PlayerCharacterDto deleteCharacter(Long id);

    PlayerCharacterDto updateCharacter(Long id, PlayerCharacterDto playerCharacterDto);
}
