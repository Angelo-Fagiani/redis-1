package it.develhope.redis1.services;

import it.develhope.redis1.entities.jpa.UserJPA;
import it.develhope.redis1.entities.redis.UserRedis;
import it.develhope.redis1.repositories.jpa.UserRepositoryJPA;
import it.develhope.redis1.repositories.redis.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;
    @Autowired
    private UserRepositoryRedis userRepositoryRedis;

    //A cosa serve questo metodo
    public UserRedis convertData(UserJPA user){
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user, userRedis);
        return userRedis;
    }

    public UserJPA convertData(UserRedis user){
        UserJPA userJPA = new UserJPA();
        BeanUtils.copyProperties(user, userJPA);
        return userJPA;
    }

    public UserJPA create(UserJPA userJPA){
        if (userJPA == null) return null;
        userJPA.setId(null);
        return userRepositoryJPA.save(userJPA);
    }

    public List<UserJPA> readAll(){
        return userRepositoryJPA.findAll();
    }

    public UserJPA readOne(Long id){
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()){
            return convertData(userRedis.get());
        }else {
            UserJPA userFromDB = userRepositoryJPA.getById(id);
            if (userFromDB == null ) return null;
            userRepositoryRedis.save(convertData(userFromDB));
            return userFromDB;
        }
        }

        public UserJPA update(Long id, UserJPA userJPA) {
        if (userJPA == null) return null;
        userJPA.setId(id);
        UserJPA newUser = userRepositoryJPA.save(userJPA);
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
            if(userRedis.isPresent()) {
                //userRepositoryRedis.deleteById(id); // FASTER update - SLOWER read
                userRepositoryRedis.save(convertData(newUser)); // SLOWER update - FASTER read
            }

            return userJPA;
    }

    public void delete(Long id){
        userRepositoryJPA.deleteById(id);
        userRepositoryRedis.deleteById(id);
    }

    public void readOneFast(Long id) {
    }

    public void deleteAll() {
        userRepositoryJPA.deleteAll();
        userRepositoryRedis.deleteAll();
    }
}
