package ru.VladHendel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.VladHendel.domain.Hall;
import ru.VladHendel.domain.Seat;

public interface SeatRepo extends JpaRepository<Seat, Long> {
    Seat findByRowAndPlaceAndHall(Byte row, Byte place, Hall hall);
}
