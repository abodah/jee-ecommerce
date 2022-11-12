package org.jee.commerce.security.v2.model;

import java.io.Serializable;

public class LoginCredentials implements Serializable {
    private String email;
    private String password;

    public LoginCredentials() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
