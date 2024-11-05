package Homevork1;

import java.util.Arrays;

// Задача 3. Обработка исключений для разностных массивов
// Реализуйте метод subArraysWithExceptionHandling, который принимает
// два массива целых чисел. Метод должен возвращать новый массив, где
// каждый элемент является разностью соответствующих элементов двух входных
// массивов. Если длины массивов не равны, выбрасывайте
// IllegalArgumentException с сообщением "Массивы разной длины". Если
// результат разности оказывается отрицательным, выбрасывайте
// RuntimeException с сообщением "Отрицательный результат разности".

public class task3 {
    
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 1};
        int[] arr2 = {6, 7, 8};

        try {
            int[] result = subArraysWithExceptionHandling(arr1, arr2);
            System.out.println(Arrays.toString(result));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        

    }

    public static int[] subArraysWithExceptionHandling(int[] arr1, int[] arr2) {
        if (arr1.length!= arr2.length) {
            throw new IllegalArgumentException("Массивы разной длины");
        }
        
        int[] result = new int[arr1.length];
        
        for (int i = 0; i < arr1.length; i++) {
            int diff = arr1[i] - arr2[i];
            if (diff < 0) {
                throw new RuntimeException("Отрицательный результат разности");
            }
            result[i] = diff;
    
    }
    
    return result;
}
}
