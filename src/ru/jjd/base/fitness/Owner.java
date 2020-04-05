package ru.jjd.base.fitness;

import java.time.LocalDate;

public class Owner {
    private String name;
    private String surname;
    private int year;

    public Owner(String name, String surname, int year) {
        setName(name);
        setSurname(surname);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > (LocalDate.now().getYear() - 150) && year <= LocalDate.now().getYear()){
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + year;
    }
}
