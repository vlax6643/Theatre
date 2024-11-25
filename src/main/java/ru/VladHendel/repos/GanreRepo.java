package ru.VladHendel.repos;

import org.springframework.data.repository.CrudRepository;
import ru.VladHendel.domain.Ganre;

import java.util.Optional;

public interface GanreRepo extends CrudRepository<Ganre, Integer> {
    Optional<Object> findById(Long ganreId);
    Ganre findByName(String name);
}
