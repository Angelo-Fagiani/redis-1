package it.develhope.redis1;

import it.develhope.redis1.entities.jpa.UserJPA;
import it.develhope.redis1.entities.redis.UserRedis;
import it.develhope.redis1.repositories.jpa.UserRepositoryJPA;
import it.develhope.redis1.repositories.redis.UserRepositoryRedis;
import it.develhope.redis1.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisCacheMock.class)
public class RedisCacheMockTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepositoryRedis userRepositoryRedis;


    @Test
    public void shouldWriteOnRedisCache(){
        UserRedis userRedis = new UserRedis();
        userRedis.setDomicileCity("Agrigento");
        userRedis.setId(1L);
        userRedis.setEmail("email@email");
        userRedis.setFirstName("Nome");

        UserRedis userSavedInRedisCache =userRepositoryRedis.save(userRedis);
        Assertions.assertNotNull(userSavedInRedisCache);


    }

   /* @Test
    public void create(UserJPA user){
        UserJPA userJPA = new UserJPA();
        userJPA.setId(1L);
        userJPA.setFirstName("Angelo");
        userJPA.setDomicileState("italia");

        UserJPA newUserJpa = userService.create(userJPA);
        Assertions.assertNotNull(newUserJpa);
    }*/
}
