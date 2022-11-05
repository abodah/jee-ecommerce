package org.jee.commerce.security.v2.model;

import java.util.Objects;

public class CustomerDTO {

    private String username;
    private String password;
    private String email;

    public CustomerDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }
}
