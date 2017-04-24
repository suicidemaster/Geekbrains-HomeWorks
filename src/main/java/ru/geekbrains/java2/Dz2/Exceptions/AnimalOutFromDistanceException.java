package ru.geekbrains.java2.Dz2.Exceptions;

/**
 * Created by олег on 02.02.2017.
 */
public class AnimalOutFromDistanceException extends AppException {
    public AnimalOutFromDistanceException(String text){
        System.out.println(text);
    }
}
