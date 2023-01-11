package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Entity
@Table
//private final,getter,public constructor,equals,hashcode,toString
public class Customer{
    @Id
    private Long id;
    @NotBlank(message = "name must be not empty")
    private String name;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//只允许写不允许读
    private String password;
    @NotBlank
    @Email
    private String email;
    public Customer(Long id,String name,String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ",name=" + name + '\'' +
                ",password=" + password + '\'' +
                '}';
    }
}
