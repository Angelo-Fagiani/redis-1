package it.develhope.redis1.repositories.jpa;

import it.develhope.redis1.entities.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserJPA,Long> {
}
