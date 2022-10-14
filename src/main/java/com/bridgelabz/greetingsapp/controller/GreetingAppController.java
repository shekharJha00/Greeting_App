package com.bridgelabz.greetingsapp.controller;

import com.bridgelabz.greetingsapp.Service.GreetingAppService;
import com.bridgelabz.greetingsapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    /**
     * Return Normal Greeting Hello World!
     */

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sayWelcome() {
        return new ResponseEntity("Welcome to Greeting App", HttpStatus.OK);
    }

    /**
     * Adding Greeting Message
     *
     * @return
     */

    @GetMapping(value = "/greeting/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessage() {
        return new ResponseEntity(greetingAppService.greetingMessage(), HttpStatus.OK);
    }

    /**
     * Adding Greeting Message With Name
     *
     * @param name
     * @return
     */

    @GetMapping(value = "/greeting/message/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessageWithName(@PathVariable("name") String name) {
        return new ResponseEntity(greetingAppService.greetingMessage(name), HttpStatus.OK);
    }

    /**
     * Greeting Message With Name
     *
     * @param id
     * @return
     */

    @GetMapping(value = "/greeting/message/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessageWithName(@PathVariable("id") long id) {
        return new ResponseEntity(greetingAppService.findGreetingMessage(id), HttpStatus.OK);
    }

    /**
     * Return All Message From Repository
     *
     * @return
     */

    @GetMapping(value = "/greeting/message/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllGreetingMessages() {
        return new ResponseEntity(greetingAppService.listAllGreetingMessage(), HttpStatus.OK);
    }

    /**
     * Update a Message By id
     *
     * @param greeting
     * @param id
     */
    @PutMapping(value = "/greeting/message/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateGreetingMessage(@RequestBody Greeting greeting, @PathVariable("id") long id) {
        return new ResponseEntity(greetingAppService.updateGreetingMessage(greeting, id), HttpStatus.OK);
    }

    /**
     * Delete A Message By Id
     *
     * @param id
     */

    @DeleteMapping(value = "/greeting/message/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGreetingMessage(@PathVariable("id") long id) {
        greetingAppService.deleteGreetingMessage(id);
    }
}