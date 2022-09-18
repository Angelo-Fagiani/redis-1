package it.develhope.redis1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String email;
    private String passwordEncrypted;
    private String domicileAddress;
    private String domicileCity;
    private String domicileNumber;
    private String domicileState;
    private String fiscalCode;


    }


