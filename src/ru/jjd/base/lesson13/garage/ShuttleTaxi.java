package ru.jjd.base.lesson13.garage;

public class ShuttleTaxi extends Bus implements Stops{
    private boolean onStop;

    public ShuttleTaxi(String departureSt, String destSt, String num, boolean wiFi) {
        super(departureSt, destSt, num, wiFi);
    }

    public boolean isOnStop() {
        return onStop;
    }

    public void setOnStop(boolean onStop) {
        this.onStop = onStop;
    }

    @Override
    public void Stop() {
        setOnStop(true);
        System.out.println("Остановка маршрутного такси");
    }
}
