package ru.jjd.base.lesson7;

abstract public class BattleUnit extends Unit implements CanAttack{
    //Если в классах есть что-то общее, то это выносится в общий класс
    //при наследовании все дочерние классы получают от родительских все доступные(не приватные) свойства и методы
    //наследование это всегда расширение а не изменение, если свойства или метода родителя практически не используются
    //цепочку наследования надо разорвать
    //наследование через слово extends, слева - дочерний, справа - родитель
    //множественное наследование классов через extends запрещено, можно наследовать только от одного класса
    //Implements - реализация методов интерфейса, имплементируя интерфейс класс заключает контракт
    //Имплементировать можно несколько интерфейсов через запятую
    //класс заключая контракт на реализацию интерфейса обязан реализовать все нереализованные методы
    //абстрактрый класс - объекты на его основе создать нельзя, плюс у абстрактрых классов могут быть методы
    //с реализацией и без реализации
    //свойства обычно в интерфейсах не используются, если нужно, то уже абстрактный класс
    //при использовании в методе родительского класса можно туда передавать экземпляры дочерних классов,
    //но в метод передадутся только свойства и методы указанного родительского класса
    //если метод дефолтный и у него есть реализация в интерфейсе, методы не обязаны его реализовывать
    //дефолтных методов много не описывается, если так - неправильная архитектура
    //если в двух интерфейсах одинаковые методы с реализацией - в классе нужно его определить
    //в интерфейсах по умолчанию доступ public
    //при переопределении доступ можно повышать, но нельзя понижать

    protected int attackScore;

    public BattleUnit(int healthScore, int speed, int attackScore) {
        super(healthScore, speed);//super - вызов из родительского класса, тут - вызов конструктора родительского класса
        //вызов метода через super.
        setAttackScore(attackScore);
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    @Override
    public void attack(BattleUnit enemy) {

    }

    @Override
    public void runFromField() {
        System.out.println("runFromField CanAttack");
    }
        //knight / doctor / infantry

    public static BattleUnit getBattleUnit(String type){
        BattleUnit battleUnit = null;
        if ("knight".equals(type)){
            battleUnit = new Knight((int) (Math.random() * 10) + 2,
                    (int) (Math.random() * 7) + 1,
                    (int) (Math.random() * 8) + 1,
                    (int) (Math.random() * 13) + 3);
        } else if ("doctor".equals(type)){
            battleUnit = new Doctor((int) (Math.random() * 10) + 2,
                    (int) (Math.random() * 7) + 1,
                    (int) (Math.random() * 8) + 1,
                    (int) (Math.random() * 13) + 3);
        } else if ("infantry".equals(type)){
            battleUnit = new Infantry((int) (Math.random() * 10) + 2,
                    (int) (Math.random() * 7) + 1,
                    (int) (Math.random() * 8) + 1,
                    (int) (Math.random() * 13) + 3);
        }
        //есть соглашение что несколько return в методах лучше не делать
        return battleUnit;
        //конструкции if...else if принято заменять на switch
    }

    //abstract public void attack();
}
