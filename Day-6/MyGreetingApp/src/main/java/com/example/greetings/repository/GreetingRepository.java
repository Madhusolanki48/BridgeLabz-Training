package com.example.greetings.repository;
import com.example.greetings.model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class GreetingRepository {

    //this stores greetings in memory for this practice app.
    private final ConcurrentMap<Long, Greeting> greetings = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public GreetingRepository() {
        save(new Greeting(null, "Maddy", "Welcome to My Greeting App !!!"));
        save(new Greeting(null, "BridgeLabz", "Practice makes web apps better."));
    }

    public List<Greeting> findAll() {
        return greetings.values()
                .stream()
                .sorted(Comparator.comparing(Greeting::getId))
                .toList();
    }

    public Optional<Greeting> findById(Long id) {
        return Optional.ofNullable(greetings.get(id));
    }

    public Greeting save(Greeting greeting) {
        if (greeting.getId() == null) {
            greeting.setId(nextId.getAndIncrement());
        }

        greeting.setName(clean(greeting.getName(), "User"));
        greeting.setMessage(clean(greeting.getMessage(), "Hello, " + greeting.getName() + "!"));
        greetings.put(greeting.getId(), greeting);
        return greeting;
    }

    public void deleteById(Long id) {
        greetings.remove(id);
    }

    private String clean(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value.trim();
    }
}
