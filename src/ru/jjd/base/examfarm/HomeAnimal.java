package ru.jjd.base.examfarm;

public class HomeAnimal extends Animal implements CanEat, CanBeAttacked{
    private int currentHealth;
    private int health;
    private int resource;
    private boolean canBeEaten;

    public HomeAnimal(String name, int weight, int speed, int health, int resource, boolean canBeEaten) {
        super(name, weight, speed);
        setHealth(health);
        setResource(resource);
        setCurrentHealth(health);
        setCanBeEaten(canBeEaten);
    }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        }
    }

    public void setResource(int resource) {
        if (resource >= 0) {
            this.resource = resource;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getResource() {
        return resource;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth >= 0 && currentHealth <= health) {
            this.currentHealth = currentHealth;
        }
    }

    public boolean isCanBeEaten() {
        return canBeEaten;
    }

    public void setCanBeEaten(boolean canBeEaten) {
        this.canBeEaten = canBeEaten;
    }

    public boolean isDie(){
        if (currentHealth <= 0){
            return true;
        }
        return false;
    }

    @Override
    public void eat() {
        if (currentHealth == health){
            setWeight(getWeight() + 1);
        } else {
            currentHealth++;
        }
    }

    @Override
    public void beAttacked(CanAttack animal) {
        WildAnimal wildAnimal = (WildAnimal) animal;
        if (wildAnimal.getSpeed() > this.getSpeed()){
            currentHealth -= wildAnimal.getStrength();
        }
    }
}
