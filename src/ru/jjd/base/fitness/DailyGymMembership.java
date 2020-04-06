package ru.jjd.base.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class DailyGymMembership extends GymMembership {
    public DailyGymMembership(LocalDate registrationDate, LocalDate registrationEndDate, Owner owner) {
        super(registrationDate, registrationEndDate, LocalTime.of(8, 0),
                LocalTime.of(16, 0), owner, "Дневной");
    }
}
