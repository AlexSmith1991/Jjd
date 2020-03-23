package ru.jjd.base.school;

public class HeadMaster extends Human {

    public HeadMaster(String name, int age) {
        super(name, age);
    }

    public void AnnounceLessonsStart(){
        System.out.println("Начало занятий");
    }

    public void AnnounceLessonsEnd(){
        System.out.println("Конец занятий");
    }
}
