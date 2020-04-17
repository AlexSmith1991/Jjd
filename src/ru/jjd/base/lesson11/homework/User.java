package ru.jjd.base.lesson11.homework;

public class User {
    private String fullName;
    private int salary;
    private Position position;

    public User(String fullName, int salary, String positionLetter) {
        setFullName(fullName);
        setSalary(salary);
        for (Position currentPosition: Position.values()){
            if (currentPosition.toString().startsWith(positionLetter)){
                setPosition(currentPosition);
                break;
            }
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null) {
            this.fullName = fullName;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

enum Position{
   APOSITION, BPOSITION, CPOSITION, DPOSITION
}
