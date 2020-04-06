package ru.jjd.base.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class FullGymMembership extends GymMembership {
    public FullGymMembership(LocalDate registrationDate, LocalDate registrationEndDate, Owner owner) {
        super(registrationDate, registrationEndDate, LocalTime.of(8, 0),
                LocalTime.of(22, 0), owner, "Полный");
    }
}
