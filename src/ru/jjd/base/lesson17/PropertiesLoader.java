package ru.jjd.base.lesson17;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static PropertiesLoader propertiesLoader;
    private String propFileName;

    public static PropertiesLoader getPropertiesLoader(String propFileName){
        if (propertiesLoader == null){
            propertiesLoader = new PropertiesLoader(propFileName);
        }
        return propertiesLoader;
        //такая реализация называется ленивой и не подходит для многопоточных сред
    }

    private Properties properties;

    //возможно создание объекта только внутри класса
    private PropertiesLoader(String propFileName){
        this.properties = new Properties();
        this.propFileName = propFileName;
        loadProperties();
    }

    public Properties getProperties(){
        return properties;
    }

    private void loadProperties(){
        //загрузка данных из properties файла
        try (InputStream input = PropertiesClass.class.
                getClassLoader().getResourceAsStream(propFileName)){
            properties.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
