package com.qa.controllers;

import com.qa.models.PlayerCharacters;
import com.qa.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PlayerCharactersController {

    @Autowired
    private PlayerCharacterRepository repository;

    //Get all characters
    @RequestMapping(value = "characters", method = RequestMethod.GET)
    public List<PlayerCharacters> listAllCharacters(){
        return repository.findAll();
    }

    //Add a new character
    @RequestMapping(value = "characters", method = RequestMethod.POST)
    public PlayerCharacters addCharacter(@RequestBody PlayerCharacters player){
        return repository.saveAndFlush(player);
    }

    //Get a specific character
    @RequestMapping(value = "characters/{id}", method = RequestMethod.GET)
    public PlayerCharacters getCharacter(@PathVariable Long id){
        return repository.findOne(id);
    }

    //Delete a specific character
    @RequestMapping(value = "characters/{id}", method = RequestMethod.DELETE)
    public PlayerCharacters deleteCharacter(@PathVariable Long id){
        PlayerCharacters existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    //Update Character
    @RequestMapping(value = "characters/{id}", method = RequestMethod.PUT)
    public PlayerCharacters updateCharacter(@PathVariable Long id, @RequestBody PlayerCharacters player){
        PlayerCharacters existing = repository.findOne(id);
        existing = player;
        return repository.saveAndFlush(existing);
    }


}
