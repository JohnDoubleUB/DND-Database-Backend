package com.qa.controllers;

import com.qa.dto.PlayerCharacterDto;
import com.qa.service.PlayerCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PlayerCharacterController {

    @Autowired
    private PlayerCharacterService service;

    //Get all characters
    @RequestMapping(value = "characters", method = RequestMethod.GET)
    public ResponseEntity<List<PlayerCharacterDto>> getCharacters(){
        return new ResponseEntity<List<PlayerCharacterDto>>(service.getCharacters(), HttpStatus.OK);
    }

    //Add a new character
    @RequestMapping(value = "characters", method = RequestMethod.POST)
    public ResponseEntity<PlayerCharacterDto> addCharacter(@RequestBody PlayerCharacterDto player){
        return new ResponseEntity<PlayerCharacterDto>(service.addCharacter(player), HttpStatus.CREATED);
    }

    //Get a character by id
    @RequestMapping(value = "characters/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlayerCharacterDto> getCharacter(@PathVariable Long id){
        return new ResponseEntity<PlayerCharacterDto>(service.getCharacter(id), HttpStatus.OK);
    }

    //Delete a character by id
    @RequestMapping(value = "characters/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PlayerCharacterDto> deleteCharacter(@PathVariable Long id){
        return new ResponseEntity<PlayerCharacterDto>(service.deleteCharacter(id), HttpStatus.ACCEPTED);
    }

    //Update a Character by id
    @RequestMapping(value = "characters/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PlayerCharacterDto> updateCharacter(@PathVariable Long id, @RequestBody PlayerCharacterDto player){
        return new ResponseEntity<PlayerCharacterDto>(service.updateCharacter(id, player), HttpStatus.ACCEPTED);
    }


}
