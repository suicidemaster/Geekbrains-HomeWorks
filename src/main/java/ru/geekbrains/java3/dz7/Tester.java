package ru.geekbrains.java3.dz7;

/**
 * Created by KGBkid on 09.04.2017.
 */
public class Tester {

    @AfterSuite
    public void afterTest(){
        System.out.println("After test");
    }

    @Test (10)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test (-5)
    @AfterSuite
    public void test3(){
        System.out.println("Test 3");
    }

    @BeforeSuite
    public void beforeTest(){
        System.out.println("Before test");
    }



}
