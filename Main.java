package ru.vsu.cs.KiselevaMaria;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 100, -100, 8, 8, 0};
        int[] arr1 = {5};
        int[] arr2 = {0, 1, 3, 2, 4, 5};
        int[] arr3 = {35, 4, 0, 2, 1, 100, -100, 8, 8, 0};
        int[] arr4 = {5, 4, 3, 2, 1, 100, -100, 8, 8, 0, 100000, 9999, 55555};
        int[] newArr = sortArray(arr4);
        for(int i=0; i< newArr.length; i++) {
            System.out.print(newArr[i] + ", ");
        }
    }

    public static int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент
        if (arrayA.length < 2) {
            return arrayA;
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray( arrayC, arrayB);
    }

    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] b = new int[a1.length + a2.length];
        int positionA1 = 0;
        int positionA2 = 0;

        for(int i = 0; i < b.length; i++) {
            if(positionA1 == a1.length){
                b[i] = a2[positionA2];
                positionA2++;
            } else if(positionA2 == a2.length){
                b[i] = a1[positionA1];
                positionA1++;
            } else if(a1[positionA1] < a2[positionA2]){
                b[i] = a1[positionA1];
                positionA1++;
            } else {
                b[i] = a2[positionA2];
                positionA2++;
            }
        }
        return b;
    }


}