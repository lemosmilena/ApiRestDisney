package com.example.apirestdisney.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String token;
    private String tokenTemporal;
    private String justification;
    private Integer apiCallsLimit;
    private Integer apiCallsAvailable;

    public UserEntity() {
    }

    public UserEntity(String name, String email, String token, String tokenTemporal, String justification, Integer apiCallsLimit, Integer apiCallsAvailable) {
        this.name = name;
        this.email = email;
        this.token = token;
        this.tokenTemporal = tokenTemporal;
        this.justification = justification;
        this.apiCallsLimit = apiCallsLimit;
        this.apiCallsAvailable = apiCallsAvailable;
    }

    public UserEntity(Integer user_id, String name, String email, String token, String tokenTemporal, String justification, Integer apiCallsLimit, Integer apiCallsAvailable) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.tokenTemporal = tokenTemporal;
        this.justification = justification;
        this.apiCallsLimit = apiCallsLimit;
        this.apiCallsAvailable = apiCallsAvailable;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer usuario_id) {
        this.user_id = usuario_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String use) {
        this.justification = use;
    }

    public Integer getApiCallsLimit() {
        return apiCallsLimit;
    }

    public void setApiCallsLimit(Integer apiCallsLimit) {
        this.apiCallsLimit = apiCallsLimit;
    }

    public Integer getApiCallsAvailable() {
        return apiCallsAvailable;
    }

    public void setApiCallsAvailable(Integer getApiCallsAvailable) {
        this.apiCallsAvailable = getApiCallsAvailable;
    }

    public String getEmail() { return email; }

    public void setEmail(String mail) { this.email = mail; }

    public String getTokenTemporal() {
        return tokenTemporal;
    }

    public void setTokenTemporal(String tokenTemporal) {
        this.tokenTemporal = tokenTemporal;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", tokenTemporal='" + tokenTemporal + '\'' +
                ", justification='" + justification + '\'' +
                ", apiCallsLimit=" + apiCallsLimit +
                ", apiCallsAvailable=" + apiCallsAvailable +
                '}';
    }

    public void descontarCall() {
        apiCallsAvailable--;
    }
}

