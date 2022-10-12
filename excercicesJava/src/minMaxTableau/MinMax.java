package minMaxTableau;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import com.google.common.primitives.Ints;



public class MinMax {
    // ---------------1----------------- Solution simple et classique
    public static void MinMaxSimple(int[] array) {
        int maxVal = Integer.MAX_VALUE;
        int minVal = Integer.MIN_VALUE;

        for (int nombre : array)
            System.out.print(nombre + " ");

        for (int i = 0; i < array.length; i++) {
            if (array[i] < maxVal)
                maxVal = array[i];
            if (array[i] > minVal)
                minVal = array[i];
        }

        System.out.print("\nValeur minimale = " + maxVal);
        System.out.print("\nValeur maximale = " + minVal);
    }

    // ---------------2----------------- Solution avec java8 et les stream

    public static void MaxJava8(int[] array) {
        OptionalInt max1 = Arrays.stream(array).max();
        System.out.println("le premier maximum est " + max1.getAsInt());
        //ou
        OptionalInt max2 = IntStream.of(array).max();
        System.out.println("le deuxieme maximum est " + max2.getAsInt());
    }

    public static void MinJava8(int[] array) {
        OptionalInt min1 = Arrays.stream(array).min();
        System.out.println("le premier minimum est " + min1.getAsInt());
        //ou
        OptionalInt min2 = IntStream.of(array).min();
        System.out.println("le premier minimum est " + min2.getAsInt());

    }


    // ---------------3-----------------Solution avec L'API "Guava" de Google

    public static void Maxguava (int[] tab) {
        int max = Ints.max(tab);
        System.out.println(max) ;
    }

    public static void Minguava (int[] tab) {
        int min = Ints.min(tab);
        System.out.println(min) ;
    }


    public static void main(String[] args) {
        int array[] = {51, 24, 19, 5, 37, 76, 61, 99, 101, 36};
        //MinMaxSimple(array);
        //MaxJava8(array);
        //MinJava8(array);
        Maxguava(array);
        Minguava(array);


    }
}


