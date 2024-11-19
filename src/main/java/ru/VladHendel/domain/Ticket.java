package ru.VladHendel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
    @Column(name = "seat_number")
    private Integer seatNumber;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
}
