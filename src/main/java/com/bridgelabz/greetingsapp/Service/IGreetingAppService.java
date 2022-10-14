package com.bridgelabz.greetingsapp.Service;

import com.bridgelabz.greetingsapp.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface IGreetingAppService {

    String greetingMessage();

    String greetingMessage(String name);

    Optional<Greeting> findGreetingMessage(long id);

    List<Greeting> listAllGreetingMessage();

    Optional<Greeting> updateGreetingMessage(Greeting greeting, long id);

    void deleteGreetingMessage(long id);
}