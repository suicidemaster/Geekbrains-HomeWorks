package ru.geekbrains.java2.dz5;

/**
 * Created by олег on 15.02.2017.
 */
public class App extends Thread {
    static final int SIZE = 10000000;
    static float[] data = new float[SIZE];

    public static void main(String[] args) {
        App app = new App();
        app.createArray();
        System.out.println("Пускаем все в одном потоке");
        app.arraySeparation(data,1);
        System.out.println("Пускаем все в 2 потока.");
        app.arraySeparation(data,2);
        System.out.println("Пускаем все в 4 потока.");
        app.arraySeparation(data,4);
        System.out.println("Пускаем все в 8 потоков.");
        app.arraySeparation(data,8);
    }


    public void createArray() {

        for (int i = 0; i < SIZE; i++)

        {
            data[i] = 1;
        }
    }

    public void arraySeparation(float[] arr, int num) {
        long a = System.currentTimeMillis();
        int h = SIZE / num;
        for (int i = 0; i < num; i++) {
            float[] array = new float[h];
            System.arraycopy(arr, i*h, array, 0, h);
            ArrayCalculation arrCalc = new ArrayCalculation(array);
            Thread thread = new Thread(arrCalc);
            if (num != 1)thread.start();
            else thread.run();
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static class ArrayCalculation implements Runnable {
        float[] arr;

        public ArrayCalculation(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}

