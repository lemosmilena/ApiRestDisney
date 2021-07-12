package com.example.apirestdisney.controllers;

import com.example.apirestdisney.entities.CharacterEntity;
import com.example.apirestdisney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController{
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /** Lista todos los personajes **/
    // TODO falta devolver la lista de peliculas

    @GetMapping()
    public List<CharacterEntity> findAll(){
        return characterService.findAll();
    }

    /** Lista personajes por nombre **/

    @GetMapping("/name/{name}")
    public List<CharacterEntity> findByName(@PathVariable String name){
        return characterService.findByName(name);
    }

    /** Lista personajes por ID**/

    @GetMapping("/id/{id}")
    public Optional<CharacterEntity> findById(@PathVariable Integer id){
        return characterService.findById(id);
    }


    //TODO Lista personajes por peso

    @GetMapping("/weight/{weight}")
    public List<CharacterEntity> findByWeight(@PathVariable Integer weight){
       return characterService.findByWeight(weight);
   }

   /** Lista personajes por edad **/

   @GetMapping("age/{age}")
   public List<CharacterEntity> findByAge(@PathVariable Integer age){
       return characterService.findByAge(age);
   }
   
   /** Guardar personaje **/

   @PostMapping(path = "save", consumes = "application/json")
   public void saveCharacter(@RequestBody CharacterEntity characterEntity){
       characterService.save(characterEntity);
   }

   /** Borrar personaje **/
   @DeleteMapping({"delete/{id}"})
    public void deleteCharacter(@PathVariable Integer id){
        characterService.deleteById(id);
   }

   // TODO modificar personaje


}
