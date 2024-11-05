package Homevork1;
// Задача 2. Объединение массивов с проверкой длины и содержимого
// Реализуйте метод mergeAndValidateArrays, который принимает два
// массива целых чисел. Метод должен объединить массивы и вернуть новый
// массив. Если длины массивов не равны, выбрасывайте исключение
// IllegalArgumentException. Если хотя бы один элемент объединенного
// массива отрицательный, выбрасывайте исключение RuntimeException с
// сообщением "Обнаружен отрицательный элемент".

import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, -6,};

        try {
            int[] mergedArray = mergeAndValidateArrays(arr1, arr2);
            System.out.println(Arrays.toString(mergedArray));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        

    }

    public static int[] mergeAndValidateArrays(int[] arr1, int[] arr2) {
        if (arr1.length!= arr2.length) {
            throw new IllegalArgumentException("Массивы разной длинны");
        }

        int[] result = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);



        for (int i = 0; i < result.length; i++) {
            if (result[i] <0){
                throw new RuntimeException("Обнаружен отрицательный элемент");
            }
       
    }
    return result;
}
}
