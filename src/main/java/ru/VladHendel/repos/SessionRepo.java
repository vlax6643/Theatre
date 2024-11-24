package ru.VladHendel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.VladHendel.domain.Hall;
import ru.VladHendel.domain.Session;
import ru.VladHendel.domain.Show;

import java.util.List;
import java.util.Optional;

public interface SessionRepo extends JpaRepository<Session, Long> {
    List<Session> findByShow(Show show);
    List<Session> findByShowIn(List<Show> shows);
    List<Session> findByShowInAndHall(List<Show> shows, Hall hall);
    List<Session> findByHall(Hall hall);
}
