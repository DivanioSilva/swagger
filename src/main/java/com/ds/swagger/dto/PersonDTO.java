package com.ds.swagger.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PersonDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String city;
    private Date today;
    private String helloDavid;
}
