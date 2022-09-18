package it.develhope.redis1.entities.redis;

import it.develhope.redis1.entities.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@RedisHash(value = "user",timeToLive = 60)
@Data
public class UserRedis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

