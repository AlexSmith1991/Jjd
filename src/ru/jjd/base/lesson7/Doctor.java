package ru.jjd.base.lesson7;

public class Doctor extends BattleUnit {
    private int medicineScore;

    public Doctor(int healthScore, int speed, int attackScore, int medicineScore) {
        super(healthScore, speed, attackScore);
        setMedicineScore(medicineScore);
    }

    public int getMedicineScore() {
        return medicineScore;
    }

    public void setMedicineScore(int medicineScore) {
        this.medicineScore = medicineScore;
    }


    @Override
    //аннотация override говорит что мы переопределяем метод интерфейса, либо метода родительского класса,
    //без нее тоже все будет работать, но это также и указатель компилсятору о переопределении метода
    //
    public void attack(BattleUnit unit) {
        System.out.println("Атака доктора");
        unit.healthScore += attackScore + medicineScore;
    }

    @Override
    public void rest() {
        System.out.println("Доктор отдыхает");
    }
}
