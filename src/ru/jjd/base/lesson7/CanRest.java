package ru.jjd.base.lesson7;

public interface CanRest {

    void rest();

    default void runFromField(){
        System.out.println("runFromField CanRest qwe");
    }
}
