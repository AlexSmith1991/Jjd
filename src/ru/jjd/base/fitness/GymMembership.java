package ru.jjd.base.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class GymMembership {
    private LocalDate registrationDate;
    private LocalDate registrationEndDate;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Owner owner;
    private String type;

    public GymMembership(LocalDate registrationDate, LocalDate registrationEndDate,
                         LocalTime timeStart, LocalTime timeEnd, Owner owner, String type) {
        setRegistrationDate(registrationDate);
        setRegistrationEndDate(registrationEndDate);
        setOwner(owner);
        setTimeStart(timeStart);
        setTimeEnd(timeEnd);
        setType(type);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate != null && !registrationDate.isBefore(LocalDate.now())) {
            this.registrationDate = registrationDate;
        }
    }

    public LocalDate getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(LocalDate registrationEndDate) {
        if (registrationEndDate != null && !registrationEndDate.isBefore(LocalDate.now())){
            this.registrationEndDate = registrationEndDate;
        }
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        if (owner != null) {
            this.owner = owner;
        }
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        if (timeStart != null) {
            this.timeStart = timeStart;
        }
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        if (timeEnd != null) {
            this.timeEnd = timeEnd;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if ("Разовый".equals(type) ||
                "Дневной".equals(type) ||
                "Полный".equals(type)) {
            this.type = type;
        }
    }

    @Override
    public String toString() {
        return owner.getSurname() + " " + owner.getName() + " " + type + " " +
                registrationDate + "-" + registrationEndDate;
    }
}
