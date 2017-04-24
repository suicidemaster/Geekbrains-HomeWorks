package ru.geekbrains.java2.dz3.Comparators;

import ru.geekbrains.java2.dz3.Pupil;

import java.util.Comparator;

/**
 * Created by олег on 09.02.2017.
 */
public class PupilsSurnameComparator implements Comparator<Pupil> {

    public int compare(Pupil a, Pupil b) {

        return a.getSurname().compareTo(b.getSurname());
    }
}
