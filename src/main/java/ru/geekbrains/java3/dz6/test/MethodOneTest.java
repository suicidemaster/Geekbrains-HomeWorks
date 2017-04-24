package ru.geekbrains.java3.dz7.test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.geekbrains.java3.dz6.Method;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by KGBkid on 04.04.2017.
 */
@RunWith(Parameterized.class)

public class MethodOneTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 5, 4, 6}, {6}},
                {{4, 2, 3, 5}, {2, 3, 5}},
                {{4, 4, 0, 1}, {0, 1}},
                {{5, 5, 5, 4}, {}},
                {{4, 7, 5, 4}, {}},
                {{5, 5, 4, 5,}, {5} },
        });
    }

    private int x[];
    private int result[];

    public MethodOneTest(int x[], int result[]) {
        this.x = x;
        this.result = result;
    }

    private static Method method;


    @Before
    public void init() {
        System.out.println("init Method");
        method = new Method();
    }

    @Test
    public void massTestAdd() {
        Assert.assertArrayEquals(result, method.myMethodOne(x));
    }

}
