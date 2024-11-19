package ru.VladHendel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.VladHendel.domain.User;

import java.util.List;

public interface UsersRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
