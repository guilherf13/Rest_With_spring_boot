package com.example.demo.controller;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices services;

    public PersonController(PersonServices services) {
        this.services = services;
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO findById(@PathVariable(value = "id") Long id
    ) {
        return services.findById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO created(@RequestBody PersonVO personVO) {
        return services.created(personVO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO updated(@RequestBody PersonVO personVO) {
        return services.updated(personVO);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> deleted(@PathVariable(value = "id") Long id) {
        services.deleted(id);
        return ResponseEntity.noContent().build();
    }

}
