package ru.jjd.base.lesson18;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.FileHandler;

public class IOLesson {
    public static void main(String[] args) {
        //IO API (java.io)
        //передачу данных в программу и из программы

        //IO API предоставляет возможности по передаче данных в виде последовательности byre или последовательности char

        //IO не единственная возможность передачи данных, аналогичную возможность предоставляет пакет nio

        //методами класса File можно создавать/удалять файлы/директории,
        // проверять наличие файла, получать тип файла и т.д.
        File file = new File("filepath.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //возвращает абсолютный путь
        System.out.println(file.getAbsolutePath());
        //возвращает относительный путь(относительно корня проекта)
        System.out.println(file.getPath());
        //проверка на директорию
        System.out.println(file.isDirectory());
        //проверка на файл
        System.out.println(file.isFile());
        //доступен для чтения
        System.out.println(file.canRead());
        //доступен для записи
        System.out.println(file.canWrite());
        //размер в байтах
        System.out.println(file.length());

        //если данные передаются из программы в виде последовательности байт, то мы будем работать с OutputStream
        //если данные передаются в программу в виде последовательности байт, то мы будем работать с InputStream

        try {
            writeToFile(file, "hello", false);
            //writeToFileWithBuffer(file);
            System.out.println(readFromFileToByteArray(file));

            byte[] bytes = imgToByteArray(new File("C:\\Users\\Djadj\\Downloads\\Telegram Desktop\\image_2020-04-27_20-15-50.png"));
            byteArrayToImage(new File("C:\\Users\\Djadj\\Downloads\\Telegram Desktop\\image_2020-04-27_20-15-50.png"), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(File file, String data, boolean append) throws IOException{
        //строка data должна быть записана в файл file
        //если append-true - запись в конец файла
        //если append-false - запись в начало
        //круглые скобки - try-with-resources - доступен начиная с седьмой версии языка
        //все ресурсы из круглых скобок будут закрыты автоматически когда блок try завершит свою работу
        //закрываются сначала ресурсы, а потом блок catch
        //открытие ресурса - открытие исходящего потока
        //конструкция круглых скобок - только с try
        //для того, чтобы ресурсы были закрыты, у всех объектов в круглых скобках вызывается метод close
        //close() - из интерфейса AutoCloseable
        //если класс интерфейс реализует, значит точно есть метод close(),
        // значит он точно будет вызван по завершению try
        //можно создать класс, имплементировать метод, и потом использовать его в круглых скобках
        //если в блоке try произойдет ошибка, то сначала закроются ресурсы, потом catch и только потом все остальное
        //file <---- java app
        try (FileOutputStream fileOutput = new FileOutputStream(file, append)) {
            byte[] bytes = data.getBytes();
            fileOutput.write(bytes);//запишет набор байт, чтобы передать строку, надо превратить ее в набор байт
            //если нужно записать большой текст, то нужно использовать буфер, для маленьких строк можно писать
            // через массив байт

        }
    }

    private static void writeToFileWithBuffer(File file) throws IOException {
        //file <---[buffer]--- java app
        //обращение к ресурсу только когда накопится буфер, а не каждый раз
        //неважно что просходит с файлами по дороге, запись всегда через FileOutputStream
        try (FileOutputStream fileOutput = new FileOutputStream(file);
                BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOutput)){
            //размер буфера по умолчанию - 8192 байта
            //если буфер заполнен - вызывается write у fileOutput
            //размер буфера можно установить через конструктор new BufferedOutputStream(fileOutput, size)
            //BufferOutputStream - декоратор для любого другого OutputStream, то есть добавляет ему функционал
            for (int i = 0; i < 1000000; i++) {
                bufferedOut.write((i + "").getBytes());
            }
        }
    }

    public static String readFromFileToByteArray(File file) throws IOException {
        String string = null;

        //если fileoutput не найдет файл, он его создаст, а если fileOutput - выдаст Exception
        try (FileInputStream fileInput = new FileInputStream(file);
                ByteArrayOutputStream arrayOut = new ByteArrayOutputStream()){
            byte[] buf = new byte[512];//необязательно высчитывать точный размер файла, не обязательно степени 2,
            // оптимальный размер - 8192
            int data;
            while ((data = fileInput.read(buf)) > 0){
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                arrayOut.write(buf, 0, data);//копируем из массива buf, без отступов, столько, сколько считали
            }
            //string = new String(arrayOut.toByteArray());
            string = arrayOut.toString();
        }

        return string;
    }

    public static byte[] imgToByteArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "png", output);
        return output.toByteArray();
    }

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes)){
            BufferedImage image = ImageIO.read(input);//если на вход файл - пишет в файл, если потом, то пишет в поток
            return ImageIO.write(image, "png", file);
        }
    }

    private static void WriteReadData(File file) throws IOException{
        try (FileOutputStream fileOutput = new FileOutputStream(file);
                DataOutputStream dataOutput = new DataOutputStream(fileOutput)){
            dataOutput.writeBoolean(true);
            dataOutput.writeDouble(6.555);
            dataOutput.writeInt(34);
            dataOutput.writeUTF("hello")
            ;
        }

        try (FileInputStream fileInput = new FileInputStream(file);
             DataInputStream dataInput = new DataInputStream(fileInput)){
            System.out.println(dataInput.readBoolean());
            System.out.println(dataInput.readDouble());
            System.out.println(dataInput.readInt());
            System.out.println(dataInput.readUTF());
        }
    }

}
