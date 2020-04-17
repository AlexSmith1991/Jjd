package ru.jjd.base.lesson13.garage;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus);//тип поля carOnService - Bus, не Transport
        System.out.println(garage1.getCarOnService().isWiFi());//этот метод есть только у типа Bus,
        // мы можем его использовать

        Garage<Train> garage2 = new Garage<>();
        garage2.setCarOnService(train);//тип поля carOnService - Train, не Transport
        System.out.println(garage2.getCarOnService().getCarCount());//ограничения для дженериков
        // - относятся только к дженерикам

        Garage<Transport> garage3 = new Garage<>();
        garage3.setCarOnService(bus);
        garage3.setCarOnService(train);
        //тут тип поля carOnService - Transport, значит можно добавить и автобус и поезд,
        // но доступа к их уникальным методам уже нет

        Garage<ShuttleTaxi> garage4 = new Garage<>();
        garage4.setCarOnService(new ShuttleTaxi("Спб", "Тверь", "234", false));
        garage4.getCarOnService().Stop();
    }
}
