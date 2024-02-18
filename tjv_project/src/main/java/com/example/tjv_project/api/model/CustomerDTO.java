package com.example.tjv_project.api.model;

import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Person;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Collection;

@Data
public class CustomerDTO {

    private Long customerid;
    private String customertype;
    private Long personholder;

}
