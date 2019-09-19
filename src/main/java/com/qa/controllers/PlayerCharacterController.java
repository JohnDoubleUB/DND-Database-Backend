package com.qa.controllers;

import com.qa.persistence.models.PlayerCharacter;
import com.qa.persistence.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PlayerCharacterController {

    @Autowired
    private PlayerCharacterRepository repository;

    //Get all characters - DONE THIS ONE
    @RequestMapping(value = "characters", method = RequestMethod.GET)
    public List<PlayerCharacter> getCharacters(){
        return repository.findAll();
    }

    //Add a new character - DONE THIS ONE
    @RequestMapping(value = "characters", method = RequestMethod.POST)
    public PlayerCharacter addCharacter(@RequestBody PlayerCharacter player){
        return repository.saveAndFlush(player);
    }

    //Get a specific character - DONE THIS ONE
    @RequestMapping(value = "characters/{id}", method = RequestMethod.GET)
    public PlayerCharacter getCharacter(@PathVariable Long id){
//        return repository.findById(id);
//        return repository.findOne(id);
    }

    //Delete a specific character -- DONE THIS ONE
    @RequestMapping(value = "characters/{id}", method = RequestMethod.DELETE)
    public PlayerCharacter deleteCharacter(@PathVariable Long id){
        PlayerCharacter existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    //Update Character by id -- DONE!
    @Transactional
    @RequestMapping(value = "characters/{id}", method = RequestMethod.PUT)
    public PlayerCharacter updateCharacter(@PathVariable Long id, @RequestBody PlayerCharacter player){
        PlayerCharacter existing = repository.findOne(id);

        existing.setName(player.getName());
        existing.setRace(player.getRace());
        existing.setPlayerClass(player.getPlayerClass());
        existing.setAlignment(player.getAlignment());
        existing.setBackground(player.getBackground());
        existing.setLevel(player.getLevel());
        existing.setBaseStr(player.getBaseStr());
        existing.setBaseInt(player.getBaseInt());
        existing.setBaseDex(player.getBaseDex());
        existing.setBaseCon(player.getBaseCon());
        existing.setBaseWis(player.getBaseWis());
        existing.setBaseCha(player.getBaseCha());
        existing.setBaseHP(player.getBaseHP());
        existing.setBaseProficiency(player.getBaseProficiency());


        return repository.saveAndFlush(existing);
    }


}
