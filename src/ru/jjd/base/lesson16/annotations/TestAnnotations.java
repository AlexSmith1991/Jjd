package ru.jjd.base.lesson16.annotations;

import org.w3c.dom.ls.LSOutput;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@ClassConfig(prefix = "test", version = 22)//если параметров несколько - их названия писать обязательно
public class TestAnnotations {
    @Required
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public String toString() {
        return "TestAnnotations{" +
                "stringData='" + stringData + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //аннотации - метаданные, дополнительная информация
        // которые можно прикреплять к классам, свойствам, методам и аргументам
        //можно использовать до компиляции, во время и после выполнения
        //по сути - какие-то маркеры, которыми можно пометить, и потом в зависимости от них выполнять какие-то действия
        //аннотация во время выполнения выполняется вместе с рефлексией
        //пример аннотации - @Override

        Class testClass = TestAnnotations.class;
        //получим все аннотации класса
        Annotation[] annotations = testClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        //проверим наличие аннотации
        if (testClass.isAnnotationPresent(ClassConfig.class)) {
            System.out.println("ClassConfig");
            //получим ссылку на аннотацию
            ClassConfig classConfig = (ClassConfig) testClass.getDeclaredAnnotation(ClassConfig.class);//если бы
            //на 34 строке обозначили дженерик - тут приводить не пришлось бы, приведение -
            //чтобы можно было обращаться с аннотацией как с аннотацией класса ClassConfig, получать ее параметры и т.д.
            System.out.println(classConfig.prefix() + classConfig.prefix().getClass());
            System.out.println(classConfig.version());
        }

        //получим аннотации полей класса
        Field[] fields = testClass.getDeclaredFields();
        for (Field field: fields){
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(fieldAnnotations));
            if (field.isAnnotationPresent(Required.class)){
                System.out.println("поле с Required");
            }
        }
        //рекурсивный toString может вызвать нехватку памяти, исследовать этот вопрос
    }
}
