package ru.jjd.base.school;

public class Human {

    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 1){
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 5){
            this.age = age;
        }
    }

    protected Human(String name, int age){
        setName(name);
        setAge(age);
    }
}
