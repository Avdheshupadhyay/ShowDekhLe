package com.project.showdekhle.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "usermodel")
public class UserModel {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    private String password;
    private String phone;
    private String created_at;
    private String updated_at;
}
