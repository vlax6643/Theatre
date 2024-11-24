package ru.VladHendel.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.VladHendel.domain.Ganre;
import ru.VladHendel.domain.Hall;
import ru.VladHendel.domain.Seat;
import ru.VladHendel.repos.GanreRepo;
import ru.VladHendel.repos.HallRepo;
import ru.VladHendel.repos.SeatRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    private final HallRepo hallRepo;
    private final GanreRepo ganreRepo;
    private  final SeatRepo seatRepo;
    public DataInitializer(HallRepo hallRepo, GanreRepo ganreRepo, SeatRepo seatRepo) {
        this.hallRepo = hallRepo;
        this.ganreRepo = ganreRepo;
        this.seatRepo = seatRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (hallRepo.count() == 0) {
            Hall hall1 = new Hall();
            hall1.setName("Большой");
            hall1.setRows(15);
            hall1.setSeatsPerRow(25);
            hallRepo.save(hall1);
            for (int row = 1; row <= hall1.getRows(); row++) {
                for (int place = 1; place <= hall1.getSeatsPerRow(); place++) {
                    Seat seat = new Seat();
                    seat.setRow((byte) row);
                    seat.setPlace((byte) place);
                    seat.setHall(hall1);
                    seatRepo.save(seat);
                }
            }

            Hall hall2 = new Hall();
            hall2.setName("Малый");
            hall2.setRows(8);
            hall2.setSeatsPerRow(15);
            hallRepo.save(hall2);
            for (int row = 1; row <= hall2.getRows(); row++) {
                for (int place = 1; place <= hall2.getSeatsPerRow(); place++) {
                    Seat seat = new Seat();
                    seat.setRow((byte) row);
                    seat.setPlace((byte) place);
                    seat.setHall(hall2);
                    seatRepo.save(seat);
                }
            }

            System.out.println("Таблица halls инициализирована начальными данными.");
        } else {
            System.out.println("Таблица halls уже содержит данные.");
        }

        if (ganreRepo.count() == 0) {
            Ganre ganre1 = new Ganre();
            ganre1.setName("Комедия");
            ganreRepo.save(ganre1);

            Ganre ganre2 = new Ganre();
            ganre2.setName("драма");
            ganreRepo.save(ganre2);

            Ganre ganre3 = new Ganre();
            ganre3.setName("мюзикл");
            ganreRepo.save(ganre3);

            Ganre ganre4 = new Ganre();
            ganre4.setName("мелодрама");
            ganreRepo.save(ganre4);

            Ganre ganre5 = new Ganre();
            ganre5.setName("Опера");
            ganreRepo.save(ganre5);

            Ganre ganre6 = new Ganre();
            ganre6.setName("трагикомедия");
            ganreRepo.save(ganre6);



            System.out.println("Таблица ganres инициализирована начальными данными.");
        } else {
            System.out.println("Таблица ganres уже содержит данные.");
        }
    }
}
