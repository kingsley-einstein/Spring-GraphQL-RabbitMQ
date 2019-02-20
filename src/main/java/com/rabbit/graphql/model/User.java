package com.rabbit.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "profile", nullable = true)
    private Long profileId;

    protected User() {
    }

    public User(final String username, final String password, final String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public Long getProfileId() {
        return profileId;
    }

}