package ru.jjd.base.lesson17;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClass {
    public static void main(String[] args) {
        //объект типа Properties основан на хэш-таблице, используется для хранения пар ключ-значение,
        // при этом тип данных ключей - String, тип данных значение - String,
        // удобно использовать для работы с Property файлами
        Properties properties = new Properties();

        //в корне проекта, на обном уровне с src и out, создаем директорию sources
        //правой кнопкой мыши -> mark directory as -> resources root

        //try (InputStream input = PropertiesClass.class.
           //     getClassLoader().getResourceAsStream("example.properties")){
          //  properties.load(input);
        //} catch (IOException e){
          //  e.printStackTrace();
        //}
        PropertiesLoader loader1 = PropertiesLoader.getPropertiesLoader("example.properties");
        PropertiesLoader loader2 = PropertiesLoader.getPropertiesLoader("example.properties");
        properties = loader1.getProperties();
        System.out.println(properties.getProperty("key"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("data"));//при выборе несуществующего ключа вернет null,
        // можно задать дефолтное значение
        System.out.println(properties.getProperty("data", "default"));

        //добавить пару ключ-значение
        properties.setProperty("ip", "97.167.23.9");
        //если в другом файле создавать объект properties, то там добавленных тут значений не будет
    }
}
