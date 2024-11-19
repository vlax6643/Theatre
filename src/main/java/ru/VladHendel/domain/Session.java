package ru.VladHendel.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private Long Id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @Column(name = "available_seats")
    private Integer availableSeats;

    @ElementCollection
    @CollectionTable(name = "session_seats", joinColumns = @JoinColumn(name = "session_id"))
    @Column(name = "seat_status")
    private Map<Integer, Boolean> seatStatus = new HashMap<>(); // true = занято, false = свободно
}
