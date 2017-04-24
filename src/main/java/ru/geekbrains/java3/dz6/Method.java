package ru.geekbrains.java3.dz6;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by KGBkid on 04.04.2017.
 */
public class Method {

    public int[] myMethodOne(int array[]) {


        int newArray[] = ArrayUtils.subarray(array,
                ArrayUtils.lastIndexOf(array, 4) + 1,
                ArrayUtils.getLength(array)+1);
        if (array.equals(newArray)) throw new RuntimeException();
        return newArray;
    }
    public boolean myMethodTwo(int array[]) {
       return  (ArrayUtils.contains(array, 1) || ArrayUtils.contains(array, 4));
    }
}
