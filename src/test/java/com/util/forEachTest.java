package com.util;

import java.util.ArrayList;

public class forEachTest {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        array.forEach(item -> {
            System.out.print(item);
            if (item == 5){
                return;
            }
        });

        System.out.println("");

        array.stream().anyMatch(item -> {
            System.out.print(item);
            if (item == 5){
                return true;
            }
            return false;
        });

    }

}
