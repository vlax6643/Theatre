package ru.VladHendel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.VladHendel.domain.Hall;

public interface HallRepo extends JpaRepository<Hall, Long> {
    Hall findByName (String name);
}
