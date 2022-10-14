package com.bridgelabz.greetingsapp.Service;

import com.bridgelabz.greetingsapp.exception.GreetingException;
import com.bridgelabz.greetingsapp.model.Greeting;
import com.bridgelabz.greetingsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingAppService implements IGreetingAppService {

    @Autowired
    private UserRepo greetingRepository;

    public String greetingMessage() {
        return "Hello World";
    }

    /**
     * Method For Greeting With Name
     *
     * @param name
     */
    @Override
    public String greetingMessage(String name) {
        String message = "Hello " + name;
        Greeting greeting = new Greeting((greetingRepository.count() + 1), name, message);
        greetingRepository.save(greeting);
        return message;
    }

    /**
     * Method For Finding Message
     *
     * @param id
     */
    @Override
    public Optional<Greeting> findGreetingMessage(long id) {
        return greetingRepository.findById(id);
    }

    /**
     * Method For Getting All Messages
     */
    @Override
    public List<Greeting> listAllGreetingMessage() {
        return greetingRepository.findAll();
    }

    /**
     * Method For Updating Greeting Message
     *
     * @param greeting
     * @param id
     */
    @Override
    public Optional<Greeting> updateGreetingMessage(Greeting greeting, long id) {
        Optional<Greeting> greetingObject = Optional.ofNullable(greetingRepository.findById(id).orElseThrow(() -> new GreetingException("Message with Id = " + id + " Doesn't Exist! ")));
        greetingObject.get().setMessage(greeting.getMessage());
        greetingRepository.save(greetingObject.get());
        return greetingObject;
    }

    /**
     * Method For Deleting Message
     *
     * @param id
     */
    @Override
    public void deleteGreetingMessage(long id) {
        greetingRepository.deleteById(id);
    }
}