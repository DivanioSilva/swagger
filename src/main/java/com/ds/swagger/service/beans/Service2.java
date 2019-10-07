package com.ds.swagger.service.beans;

import org.springframework.stereotype.Component;

@Component(Service2.serviceName)
public class Service2 extends AbstractService{
    protected static final String serviceName = "SERVICE2";

    public Service2() {
        super(serviceName);
    }
}
