package com.ds.swagger.dto;

import java.util.List;

public class ResponseBodyVO<T> {

    private List<T> elements;

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}
