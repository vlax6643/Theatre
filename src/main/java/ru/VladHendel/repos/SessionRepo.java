package ru.VladHendel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.VladHendel.domain.Session;
import ru.VladHendel.domain.Show;

import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {
    List<Session> findByShow(Show show);
}
