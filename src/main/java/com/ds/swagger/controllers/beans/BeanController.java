package com.ds.swagger.controllers.beans;

import com.ds.swagger.dto.DynamicBeanPayload;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BeanController {

    private static final Logger LOGGER = Logger.getLogger(BeanController.class.getName());

    @PostMapping(value = "/bean", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DynamicBeanPayload createparent(@RequestBody DynamicBeanPayload payload){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DynamicBeanPayload>> violations = validator.validate(payload);
        if(!violations.isEmpty()){
            for (ConstraintViolation<DynamicBeanPayload> violation: violations) {
                 LOGGER.log(Level.SEVERE, violation.getMessage());
            }
        }
        return payload;
    }

    @PutMapping(value = "/bean", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DynamicBeanPayload updatePerson(@RequestBody DynamicBeanPayload payload){
        return payload;
    }
}
