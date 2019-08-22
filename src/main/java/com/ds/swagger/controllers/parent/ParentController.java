package com.ds.swagger.controllers.parent;

import com.ds.swagger.entities.Parent;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParentController {

    @PostMapping(value = "/parent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parent createparent(@RequestBody Parent parent){
        return parent;
    }

    @PutMapping(value = "/parent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parent updatePerson(@RequestBody Parent parent){
        return parent;
    }
}
