package com.ds.swagger.service.beans;

import org.springframework.stereotype.Component;

@Component(Service1.serviceName)
public class Service1 extends AbstractService{
    protected static final String serviceName = "SERVICE";

    public Service1() {
        super(serviceName);
    }
}
