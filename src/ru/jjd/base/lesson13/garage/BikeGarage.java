package ru.jjd.base.lesson13.garage;

public class BikeGarage extends Garage<Bus> {
    public void checkBike(){
        //getCarOnService() вернет объект типа Bus
        System.out.println(this.getCarOnService().isWiFi());
    }
}

class BikeGarage2 extends Garage<Transport>{
    public void checkBike(){
        //getCarOnService() вернет объект типа Transport, потому что он тут указан в наследовании
        System.out.println(this.getCarOnService().getNum());
    }
}

class BikeGarage3<T> extends Garage{
    private T manager;
    //локальный дженерик T никак не связан с дженериком T в гараже
    public void checkBike(){
        //getCarOnService() вернет объект типа Transport, потому что он указан в гараже, в самом классе
        //если бы в гараже не было ограничения по транспорту, а была просто Garage<T>,
        // то метод getCarOnService() вернул бы объект типа Object

        System.out.println(this.getCarOnService().getNum());
    }
}