package ru.jjd.base.lesson13;
//если нужно, чтобы при создании объекта типы данных key и value могли различаться,
// нужно указать несколько generic типов через запятую
public class PairContainer<T, K> {//когда используется несколько generic типов, они перечисляются через запятую
    //при создании объекта сначала надо будет указать тип key(его тип T указан первым)
    // потом тип value(его тип K указан вторым)
    private T key;
    private K value;

    public PairContainer(T key, K value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}
