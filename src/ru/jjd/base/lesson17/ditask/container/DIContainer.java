package ru.jjd.base.lesson17.ditask.container;

import ru.jjd.base.lesson17.PropertiesClass;
import ru.jjd.base.lesson17.ditask.Main;
import ru.jjd.base.lesson17.ditask.container.marks.ConfigClass;
import ru.jjd.base.lesson17.ditask.container.marks.Required;
import ru.jjd.base.lesson17.ditask.container.marks.RequiredClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

public class DIContainer {
    private Set classes;
    private Map<String, Object> createdObjects;
    private Map<String, Properties> readConfig;


    public DIContainer(Set classes) {
        this.classes = classes;
        createdObjects = new HashMap<>();
        readConfig = new HashMap<>();
    }

    public void addClass(Object o){
        if (o != null){
            classes.add(o);
        }
    }

    public Object getObject(String name){
        Object result = null;
        //Class aClass = Class.
        Iterator<Class> classIterator = classes.iterator();
        while (classIterator.hasNext()){
            Class nextClass = classIterator.next();
            if (nextClass.getSimpleName().equals(name)){
                result = getObject(nextClass);
                break;
            }
        }
        return result;
    }

    public Object getObject(Class aClass){
        Object result = null;
        if (classes.contains(aClass)){
            result = createInstance(aClass);
        }
        return result;
    }

    private Object createInstance(Class aClass){
        Object result = null;
        result = createdObjects.get(aClass.getName());
        if (result != null){
            return result;
        }
        Constructor constructor;
        try {
            constructor = aClass.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

        try {
            result = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            return null;
        }

        Field[] fields = aClass.getDeclaredFields();

        if (aClass.isAnnotationPresent(ConfigClass.class)){
            ConfigClass configClass = (ConfigClass) aClass.getDeclaredAnnotation(ConfigClass.class);
            Properties properties = getConfig(configClass);
            for (Field field: fields){
                field.setAccessible(true);
                try {
                    String value = properties.getProperty(configClass.prefix() + "." + field.getName());
                    if (field.getType().equals(int.class) || field.getType().equals(Integer.class)){
                        field.set(result, Integer.parseInt(value));
                    } else {
                        field.set(result, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else if (aClass.isAnnotationPresent(RequiredClass.class)) {
            for (Field field: fields){
                field.setAccessible(true);
                if (field.isAnnotationPresent(Required.class)){
                    try {
                        field.set(result, createInstance(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            return null;
        }

        createdObjects.put(aClass.getName(), result);
        return result;
    }

    private Properties getConfig(ConfigClass configClass){
        Properties result = readConfig.get(configClass.file() + "/" + configClass.prefix());
        if (result == null){
            try (InputStream input = DIContainer.class.getClassLoader().getResourceAsStream(configClass.file())){
                result = new Properties();
                result.load(input);
                readConfig.put(configClass.file() + "/" + configClass.prefix(), result);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }

}
