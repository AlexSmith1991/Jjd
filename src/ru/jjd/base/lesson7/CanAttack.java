package ru.jjd.base.lesson7;

public interface CanAttack {//на основе интерфейся нельзя создать объект
    //до восьмой версии могут быть только методы без реализации
    //
    void attack(BattleUnit enemy);

    default void runFromField(){
        System.out.println("runFromField CanAttack qwe");
    }
}
