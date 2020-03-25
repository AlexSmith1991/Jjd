package ru.jjd.base.examfarm;

public class Farmer implements CanFeed {
    private int resource;

    public Farmer() {
        setResource(5);
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        if (resource >= 0) {
            this.resource = resource;
        }
    }

    public boolean tookResources(Farm farm){
        boolean result = true;
        resource += farm.tookResources();
        if (resource < 2){
            resource += farm.eatAnimal();
            if (resource < 2){
                System.out.println("Фермер проиграл");
                result = false;
            }
        }
        return result;
    }

    @Override
    public void feed(CanEat animal) {
        animal.eat();
    }
}
