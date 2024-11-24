package ru.VladHendel.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
        private Long sessionId;
        private List<Long> seats;
}
