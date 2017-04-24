package ru.geekbrains.java2.dz3;

import ru.geekbrains.java2.dz3.Comparators.ForwardAvarageGradeComparator;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by олег on 09.02.2017.
 */
public class Lesson {
    private String name;

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //Задание №5 (Написать метод который будет возвращать список учеников, отсортированных по среднему баллу (по возрастанию).)
    public void gradsAtLesson(Lesson lesson, TreeMap<Lesson, ArrayList<Pupil>> map) {
        map.get(lesson).sort(new ForwardAvarageGradeComparator());
        System.out.print(lesson + ": ");
        for (Pupil temp : map.get(lesson)) {
            System.out.print(temp +" ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
