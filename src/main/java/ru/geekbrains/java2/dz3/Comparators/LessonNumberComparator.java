package ru.geekbrains.java2.dz3.Comparators;
import ru.geekbrains.java2.dz3.Lesson;

import java.util.Comparator;

/**
 * Created by олег on 09.02.2017.
 */
public class LessonNumberComparator implements Comparator<Lesson> {

    public int compare(Lesson a, Lesson b) {

        return a.toString().compareTo(b.toString());
    }
}
