package com.example.demo.services;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){

        logger.info("Finding one person");
        return new Person(
                counter.incrementAndGet(),
                "Gui",
                "Silva",
                "Rua Iracema",
                "Male"
        );
    }

    public Person created(Person person){

        logger.info("Created Person");
        return person;
    }

    public Person updated(Person person){

        logger.info("Updated Person");
        return person;
    }

    public void deleted(String id){

        logger.info("Deleted Person");
    }

    private Person mockPerson(int i) {
        logger.info("Finding one person");
        return new Person(
                counter.incrementAndGet(),
                "Gui " + i,
                "Silva " + i,
                "Rua Iracema " + i,
                "Male " + i
        );
    }
}
