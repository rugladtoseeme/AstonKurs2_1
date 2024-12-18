package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList_BogolepovaLyudmila<String> myArr = new ArrayList_BogolepovaLyudmila<String>();
        myArr.add("Aaa");
        myArr.add("B");
        myArr.add("Dddd");
        myArr.add("Ee");
        myArr.add("Ccccc");

        myArr.add(0,"F");

        System.out.println(myArr);

        myArr.quickSort(Comparator.comparing(String::length));

        System.out.println(myArr);

        myArr.split(4);

        System.out.println(myArr);

        System.out.println(myArr.remove(1));

        System.out.println(myArr.get(1));

        System.out.println(myArr);

        myArr.clear();

        System.out.println(myArr + " -its empty arr");

    }
}