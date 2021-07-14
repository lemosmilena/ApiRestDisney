package com.example.apirestdisney.controllers;

import com.example.apirestdisney.entities.CharacterEntity;
import com.example.apirestdisney.services.CharacterService;
import com.example.apirestdisney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController{
    private final CharacterService characterService;
    private final UserService userService;

    @Autowired
    public CharacterController(CharacterService characterService, UserService userService) {
        this.characterService = characterService;
        this.userService = userService;
    }

    /** Validación de TOKEN **/
    private boolean validateToken(Optional<String> email, Optional <String> tokenTemporal) {
        if (email.isPresent() && tokenTemporal.isPresent())
            return userService.valiteTemporalAndCountApiCall(email.get(), tokenTemporal.get());
        return false;
    }

    /** Lista todos los personajes **/
    // TODO falta devolver la lista de peliculas

    @GetMapping()
    public List<CharacterEntity> findAll(@PathVariable Optional<String> email, @PathVariable Optional<String> token){
        return ((validateToken(email, token)?characterService.findAll():null));
    }

    /** Lista personajes por nombre **/

    @GetMapping("/name/{name}")
    public List<CharacterEntity> findByName(@PathVariable Optional<String> email, @PathVariable Optional<String> token,@PathVariable String name){
        return ((validateToken(email, token)?characterService.findByName(name):null));
    }

    /** Lista personajes por ID**/

    @GetMapping("/id/{id}")
    public Optional<CharacterEntity> findById(@PathVariable Optional<String> email, @PathVariable Optional<String> token, @PathVariable Integer id){
        return ((validateToken(email, token)?characterService.findById(id):null));
    }


    //TODO Lista personajes por peso

    @GetMapping("/weight/{weight}")
    public List<CharacterEntity> findByWeight(@PathVariable Optional<String> email, @PathVariable Optional<String> token, @PathVariable Integer weight){
        return ((validateToken(email, token)?characterService.findByWeight(weight):null));
   }

   /** Lista personajes por edad **/

   @GetMapping("age/{age}")
   public List<CharacterEntity> findByAge(@PathVariable Optional<String> email, @PathVariable Optional<String> token, @PathVariable Integer age){
       return ((validateToken(email, token)?characterService.findByAge(age):null));
   }
   
   /** Guardar personaje **/

   @PostMapping(path = "save", consumes = "application/json")
   public void saveCharacter(@PathVariable Optional<String> email, Optional<String> tokenTemporal, @RequestBody CharacterEntity characterEntity) {
       if (validateToken(email, tokenTemporal) == true)
           characterService.save(characterEntity);

   }

   /** Borrar personaje **/
   @DeleteMapping({"delete/{id}"})
    public void deleteCharacter(@PathVariable Optional<String> email, @PathVariable Optional<String> tokenTemporal, @PathVariable Integer id) {
       if (validateToken(email, tokenTemporal) == true)
           characterService.deleteById(id);
   }

    // TODO modificar personaje
}
