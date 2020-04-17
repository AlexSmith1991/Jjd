package ru.jjd.base.lesson13.garage;
//если в качестве типа мы укажем дженерик без ограничений <T>,
// то тип данных может быть любым(в гараж может заехать любой объект)
//в такой ситуации для carOnService будут доступны только методы Object

//если в качестве дженерика мы укажем <T extends Transport & Repairing>, то тип данных carOnService может быть
// Transport и любой из его потомков + он должен реализовывать интерфейс Repairing,
// интерфейсов может быть сколько угодно, класс один
//если интерфейсов несколько - класс должен реализовывать каждый из них & - и, или использовать нельзя
//public class Garage<T extends Transport & Repairing, K> {//указываем что может быть типа транспорт, или любого его потомка,
public class Garage<T extends Transport & Repairing> {//указываем что может быть типа транспорт, или любого его потомка,
//public class Garage<T extends Bus & Stops> {//указываем что может быть типа транспорт, или любого его потомка,
    // все потомки, не только дочерние
    // множественное наследование запрещено, тип может быть указан только один,
    // также можно ограничить интерфейсом, но все равно через слово extends
    //после такого указания помимо методов object будут также доступны все методы Transport
    private T carOnService;
    //private K secondCarOnService;
    //тут K - любой объект, ограничения относятся только к тому дженерику, за которым они написаны

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }

    public void service(){
        carOnService.repair();
    }
}
