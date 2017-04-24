package ru.geekbrains.java2.dz3;

import ru.geekbrains.java2.dz3.Comparators.ForwardAvarageGradeComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by олег on 09.02.2017.
 */
public class Pupil implements Comparable<Pupil>{
    private String name;
    private String surname;
    private double avarageGrade;
    private int identifcator;

    public double getAvarageGrade() {
        return avarageGrade;
    }
    public double getIdentifcator() {
        return identifcator;
    }



    public String getSurname() {
        return surname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pupil(String name, String surname, double avarageGrade) {
        this.name = name;
        this.surname = surname;
        this.avarageGrade = avarageGrade;
        this.identifcator = (int) (Double.doubleToLongBits(avarageGrade) - (Double.doubleToLongBits(avarageGrade) >>> 32));
    }

    @Override
    public int compareTo(Pupil o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname() + " " + this.getAvarageGrade();
    }
    public void homeworkByPupil(Pupil pupil, TreeMap<Lesson, ArrayList<Pupil>> map) {

            for (Map.Entry<Lesson, ArrayList<Pupil>> temp : map.entrySet()) {
                if (temp.getValue().contains(pupil)) {
                    System.out.print(pupil.getSurname() + " " + pupil.getName() + " сдавал домашнюю работу на ");
                    System.out.println(" " + temp.getKey() + ".");
                }
            }
            System.out.println();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pupil pupil = (Pupil) o;

        if (Double.compare(pupil.avarageGrade, avarageGrade) != 0) return false;
        if (identifcator != pupil.identifcator) return false;
        if (name != null ? !name.equals(pupil.name) : pupil.name != null) return false;
        return surname != null ? surname.equals(pupil.surname) : pupil.surname == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        temp = Double.doubleToLongBits(avarageGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + identifcator;
        return result;
    }
}
