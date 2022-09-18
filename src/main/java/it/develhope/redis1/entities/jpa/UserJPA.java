package it.develhope.redis1.entities.jpa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.develhope.redis1.entities.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class UserJPA{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


