package com.ds.swagger.service.beans;

public class AbstractService {
    private String serviceName;

    public AbstractService(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("----> " +this.serviceName);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
