package ru.VladHendel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ganres")
public class Ganre {
    @Column(name = "ganre_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Ganre(String name) {
        this.name = name;
    }

    public Ganre() {

    }
}
