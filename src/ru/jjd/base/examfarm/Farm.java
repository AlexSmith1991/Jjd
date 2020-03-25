package ru.jjd.base.examfarm;

import java.util.Random;

public class Farm {
    HomeAnimal[] homeAnimals;
    Bear bear;
    Wolf wolf;
    Fox fox;
    int count;
    int days;

    public Farm() {
        Random random = new Random();
        count = random.nextInt(10) + 1;
        homeAnimals = new HomeAnimal[count];
        for (int i = 0; i < count; i++) {
            addAnimal(null);
        }
        bear = new Bear("Bear", random.nextInt(301) + 200,
                random.nextInt(10) + 1, random.nextInt(50) + 1);
        wolf = new Wolf("Wolf", random.nextInt(81) + 20,
                random.nextInt(10) + 1, random.nextInt(20) + 1);
        fox = new Fox("Wolf", random.nextInt(6) + 5,
                random.nextInt(10) + 1, random.nextInt(20) + 1);
    }

    public int getDays() {
        return days;
    }

    private HomeAnimal getRandomAnimal(){
        Random random = new Random();
        byte[] randomBytes = new byte[20];
        HomeAnimal animal;
        random.nextBytes(randomBytes);
        String name = new String(randomBytes);
        switch (random.nextInt(4)){
            case 0:
                animal = new Cow(name, random.nextInt(151) + 50,
                        random.nextInt(10) + 1, random.nextInt(50) + 1,
                        random.nextInt(10) + 1);
                break;
            case 1:
                animal = new Cat(name, random.nextInt(5) + 1,
                        random.nextInt(10) + 1, random.nextInt(10) + 1);
                break;
            case 2:
                animal = new Chicken(name, random.nextInt(3) + 1,
                        random.nextInt(10) + 1, random.nextInt(5) + 1,
                        random.nextInt(10) + 1);
                break;
            default:
                animal = new Rabbit(name, random.nextInt(10) + 1,
                        random.nextInt(10) + 1, random.nextInt(20) + 1);
                break;
        }
        return animal;
    }

    public void addAnimal(HomeAnimal animal){
        if (animal == null){
          animal = getRandomAnimal();
        }
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] == null){
                homeAnimals[i] = animal;
                break;
            }
        }
    }

    public void checkDead(){
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].isDie()){
                homeAnimals[i] = null;
            }
        }
    }

    public int tookResources(){
        int resource = 0;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null){
                resource += homeAnimals[i].getResource();
            }
        }
        return resource;
    }

    public int eatAnimal(){
        int resources = 0;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].getResource() == 0 && homeAnimals[i].isCanBeEaten()){
                resources = homeAnimals[i].getWeight();
                homeAnimals[i] = null;
                return resources;
            }
        }
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].isCanBeEaten()){
                resources = homeAnimals[i].getWeight();
                homeAnimals[i] = null;
                break;
            }
        }
        return resources;
    }

    public boolean dayOnFarm(Farmer farmer){
        boolean result = true;
        Random random = new Random();
        days++;
        farmer.setResource(farmer.getResource() - 2);
        HomeAnimal animalForAttack = homeAnimals[random.nextInt(count)];
        if (animalForAttack != null) {
            switch (random.nextInt(3)) {
                case 0:
                    if (random.nextBoolean()){
                        bear.beDrivedAway();
                    } else {
                        bear.attack(animalForAttack);
                    }
                case 1:
                    if (random.nextBoolean()){
                        wolf.beDrivedAway();
                    } else {
                        wolf.attack(animalForAttack);
                    }
                default:
                    if (random.nextBoolean()){
                        fox.beDrivedAway();
                    } else {
                        fox.attack(animalForAttack);
                    }
            }
        }
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null){
                farmer.feed(homeAnimals[i]);
            }
        }
        if (farmer.tookResources(this)) {
            checkDead();
            if (bear.getTryCount() > 3 &&
                    wolf.getTryCount() > 3 &&
                    fox.getTryCount() > 3 &&
                    tookResources() >= 2) {
                System.out.println("Фермер победил");
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
}
