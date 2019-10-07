package com.ds.swagger.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class DynamicBeanPayload implements Serializable {
    private String nome;
    private String company;
    @Min(value = 18, message = "Age should not be less than 18")
    private Integer nif;
    @NotNull
    List<String> tags;

    public DynamicBeanPayload() {
    }

    public DynamicBeanPayload(String nome, String company, Integer nif,
                              @NotNull List<String> tags) {
        this.nome = nome;
        this.company = company;
        this.nif = nif;
        this.tags = tags;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
