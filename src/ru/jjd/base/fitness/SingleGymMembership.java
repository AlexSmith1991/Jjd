package ru.jjd.base.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class SingleGymMembership extends GymMembership {
    public SingleGymMembership(LocalDate registrationDate, Owner owner) {
        super(registrationDate, registrationDate, LocalTime.of(8, 0),
                LocalTime.of(22, 0), owner);
    }
}
