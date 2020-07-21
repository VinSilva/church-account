package br.com.church.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LoginDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
