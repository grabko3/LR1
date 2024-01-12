package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int listSize = 100000; 
        int insertionSize = 1000; 

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fill(arrayList, listSize, "ArrayList");
        fill(linkedList, listSize, "LinkedList");

        System.out.printf("Кількість елементів у списку: %d%n", listSize);

        randomAccess(arrayList, "ArrayList");
        randomAccess(linkedList, "LinkedList");

        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        insertAtBeginning(arrayList, insertionSize, "ArrayList");
        insertAtBeginning(linkedList, insertionSize, "LinkedList");

        insertAtEnd(arrayList, insertionSize, "ArrayList");
        insertAtEnd(linkedList, insertionSize, "LinkedList");

        insertInMiddle(arrayList, insertionSize, "ArrayList");
        insertInMiddle(linkedList, insertionSize, "LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            list.add(rand.nextInt(count));
        }
        System.out.printf("Заповнення %s: %d ms%n", listType, System.currentTimeMillis() - time);
        System.out.printf("Число введених елементів у %s: %d%n", listType, count);
    }

    private static void randomAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int element = list.get(i);
        }
        System.out.printf("Випадковий доступ у %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        int sum = 0;
        for (int element : list) {
            sum += element;
        }
        System.out.printf("Послідовний доступ у %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtBeginning(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        System.out.printf("Вставка на початок у %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtEnd(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < count; i++) {
            list.add(size + i, i);
        }
        System.out.printf("Вставка в кінець у %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void insertInMiddle(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        int middle = size / 2;
        for (int i = 0; i < count; i++) {
            list.add(middle, i);
        }
        System.out.printf("Вставка у середину у %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }
}
