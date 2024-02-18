package com.example.tjv_project.api.model;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonDTO {

    private Long personId;
    private String lastName;
    private String firstName;
    private LocalDateTime dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String taxIdentifier;
}
