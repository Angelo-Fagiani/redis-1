package it.develhope.redis1.controller;

import it.develhope.redis1.entities.jpa.UserJPA;
import it.develhope.redis1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity create(@RequestBody UserJPA userJPA){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(userJPA));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity raedAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.readAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity readOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.readOne(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    //Non riesco a fare la ResponseEntity in questo metodo
    @GetMapping("/{id}/fast")
    public void readOneFast(@PathVariable Long id){
        userService.readOneFast(id);
    }

    //Non riesco a fare la ResponseEntity in questo metodo
    @PutMapping("/{id}")
    public  UserJPA update(@PathVariable Long id,@RequestBody UserJPA userJPA){
        return userService.update(id,userJPA);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    /*@DeleteMapping()
    public void deleteAll(){
        userService.deleteAll();
    }*/
}



