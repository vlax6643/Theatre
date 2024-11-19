package ru.VladHendel.repos;

import org.springframework.data.repository.CrudRepository;
import ru.VladHendel.domain.Show;
import ru.VladHendel.domain.User;

import java.util.List;

public interface ShowRepo extends CrudRepository<Show, Long > {
    List<Show> findByTitle(String title);
}
