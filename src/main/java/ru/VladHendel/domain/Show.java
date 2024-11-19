package ru.VladHendel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shows")
public class Show {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
        private Integer duration;
    @Column(name = "age_rating", nullable = true)
    private Integer ageRating;

    @ManyToOne
    @JoinColumn(name = "ganre_id", nullable = false)
    private Ganre ganre;
    private String filename;

    private String description;

    public Show() {
    }

   public String getGanre(){
        return ganre != null ? ganre.getName() : "none";
   }
    public String getAgeRating() {
        return ageRating != null ? String.valueOf(ageRating) : "none";
    }

    public Show(String title,Integer duration, Integer ageRating, Ganre ganre) {
        this.title = title;
        this.duration = duration;
        this.ageRating = ageRating;
        this.ganre = ganre;
    }
}
