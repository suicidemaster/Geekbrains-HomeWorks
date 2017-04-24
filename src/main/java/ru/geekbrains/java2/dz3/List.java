package ru.geekbrains.java2.dz3;

import ru.geekbrains.java2.dz3.Comparators.ForwardAvarageGradeComparator;
import ru.geekbrains.java2.dz3.Comparators.LessonNumberComparator;
import ru.geekbrains.java2.dz3.Comparators.ReverseAvarageGradeComparator;
import ru.geekbrains.java2.dz3.Comparators.PupilsSurnameComparator;

import java.util.*;

/**
 * Created by олег on 09.02.2017.
 */
public class List {


    public static void main(String[] args) {
        //Задание №1 (Создать список учеников нашей группы)
        ArrayList<Pupil> list0 = new ArrayList<Pupil>();
        list0.add(new Pupil("Олег", "Мошков", 3.4));
        list0.add(new Pupil("Максим", "Иванов", 4.2));
        list0.add(new Pupil("Дмитрий", "Медведев", 1.6));
        list0.add(new Pupil("Владимир", "Ленин", 5.0));
        list0.add(new Pupil("Иосиф", "Бродский", 2.2));
        list0.add(new Pupil("Николай", "Смирнов", 3.9));
        list0.add(new Pupil("Петр", "Первый", 1.1));
        list0.add(new Pupil("Александр", "Шульгин", 4.7));
        list0.add(new Pupil("Василий", "Теркин", 3.4));
        list0.add(new Pupil("Ахалай", "Махалай", 1.8));
        //Задание №2 (Отсортировать список по фамилии)
        System.out.println("\n" + "Сортировка по фамилии:" + "\n");
        list0.sort(new PupilsSurnameComparator());
        for (Pupil temp : list0) {
            System.out.println(temp.getSurname() + " " + temp.getName());
        }
        //Задание №3 (Отсортировать список по среднему баллу (по убыванию))
        System.out.println("\n" + "Сортировка по среднему баллу:" + "\n");
        list0.sort(new ReverseAvarageGradeComparator());
        for (Pupil temp : list0) {
            System.out.println(temp);
        }
        //Задание №4 (Создать Отображение, в котором будут храниться пары [Номер занятия]-[Список учеников].)
        System.out.println("\n" + "Список сдавших ДЗ:" + "\n");
        TreeMap<Lesson, ArrayList<Pupil>> map = new TreeMap<>(new LessonNumberComparator());
        ArrayList<Pupil> lesson1 = new ArrayList<Pupil>(
                Arrays.asList(list0.get(1), list0.get(4), list0.get(5), list0.get(8))
        );

        ArrayList<Pupil> lesson3 = new ArrayList<Pupil>(
                Arrays.asList(list0.get(2), list0.get(3), list0.get(4), list0.get(9))
        );
        ArrayList<Pupil> lesson2 = new ArrayList<Pupil>(
                Arrays.asList(list0.get(0), list0.get(3), list0.get(5), list0.get(7))
        );
        map.put(new Lesson("Lesson1"), lesson1);
        map.put(new Lesson("Lesson2"), lesson2);
        map.put(new Lesson("Lesson3"), lesson3);
        for (Map.Entry<Lesson, ArrayList<Pupil>> temp : map.entrySet()) {
            System.out.print(temp.getKey() + ": ");
            System.out.println(temp.getValue());
        }
        //Задание №5
        System.out.println("\n" + "Cписок учеников, отсортированных по среднему баллу (по возрастанию)" + "\n");
        for (Map.Entry<Lesson, ArrayList<Pupil>> temp : map.entrySet()) {
            temp.getKey().gradsAtLesson(temp.getKey(), map);
        }
        //Задание №6
        System.out.println("\n" + "Cписок  номеров занятий, в которых ученик сдавал домашнюю работу:" + "\n");
        for (Pupil temp : list0.subList(3, 5)) {
            temp.homeworkByPupil(temp, map);
        }

    }
}
