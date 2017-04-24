package ru.geekbrains.java2.dz3.Comparators;

import java.util.Comparator;

import ru.geekbrains.java2.dz3.Pupil;

/**
 * Created by олег on 09.02.2017.
 */
public class ReverseAvarageGradeComparator implements Comparator<Pupil> {

    @Override
    public int compare(Pupil o1, Pupil o2) {
        if ((o1.getAvarageGrade() - o2.getAvarageGrade() > 0)) return -1;
        else if ((o1.getAvarageGrade() == o2.getAvarageGrade())) return 0;
        else return 1;

    }
}
