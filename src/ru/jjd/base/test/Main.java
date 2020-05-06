package ru.jjd.base.test;

import ru.jjd.base.lesson16.annotations.ClassConfig;
import ru.jjd.base.lesson17.ditask.container.marks.ConfigClass;

import java.io.File;
import java.lang.constant.Constable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Map<Class, Object> zxc = new HashMap<>();
        Class qwe = Integer.class;
        Class asd = String.class;
        String wer = "qwe";
        String sdf = "asd";
        zxc.put(qwe, wer);
        zxc.put(asd, sdf);
        System.out.println((String) zxc.get(Integer.class));
        System.out.println(qwe.getName());
        Cat cat = new Cat();
        System.out.println(cat.getClass().getName());
        System.out.println(cat.getClass().getSimpleName());
        File file = new File("animals.example");

        System.out.println(file.getAbsolutePath());
        Object q1;
        String a1 = "25";
        q1 = a1;
        //int z1 = Integer.class.cast(a1);
        int z1 = Integer.parseInt(a1);
        System.out.println(z1);
    }

    public static void qwe(){
        Class<String> qwe = String.class;
        System.out.println(qwe.getGenericInterfaces());
    }
}

class Exaple{
    String qwe;

    public Exaple() {
    }
}
