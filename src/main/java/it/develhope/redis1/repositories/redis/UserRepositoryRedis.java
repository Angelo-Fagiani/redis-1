package it.develhope.redis1.repositories.redis;

import it.develhope.redis1.entities.redis.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryRedis extends CrudRepository<UserRedis,Long> {
}
