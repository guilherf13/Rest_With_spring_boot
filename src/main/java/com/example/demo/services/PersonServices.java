package com.example.demo.services;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Finding one person");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){

        logger.info("Finding one person");
        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO created(PersonVO person){

        logger.info("Created Person" + person.toString());
        Person entity = DozerMapper.parseObject(person, Person.class);
        Person personConvert = repository.save(entity);
        return DozerMapper.parseObject(personConvert, PersonVO.class);
    }

    public PersonVO updated(PersonVO person){

        logger.info("Updated Person");
        Person entity = DozerMapper.parseObject(person, Person.class);

        Person personConvert = repository.findById(entity.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));

        personConvert.setFirstName(entity.getFirstName());
        personConvert.setLastName(entity.getLastName());
        personConvert.setAddress(entity.getAddress());
        personConvert.setGender(entity.getGender());

        return DozerMapper.parseObject(personConvert, PersonVO.class);
    }

    public void deleted(Long id){

        logger.info("Deleted Person");
        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));

        repository.delete(entity);
    }

}
