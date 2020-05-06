package ru.jjd.base.lesson12.homework;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class HomeWork {
    public static void main(String[] args) {

    }

    public static void throwException (Status status) throws FileNotFoundException,
            AccessDeniedException, JarException {
        switch (status){
            case FILE_NOT_FOUND:
                throw new FileNotFoundException();
            case ACCESS_DENIED:
                throw new AccessDeniedException("test");
            case JAR_ERROR:
                throw new JarException();
            default:
                break;
        }
    }
}

enum Status{
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR
}