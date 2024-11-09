

// Задача 3. Сортировка массива строк
// Напишите метод, который принимает массив строк и сортирует его в
// алфавитном порядке. Если входной массив null, метод должен вернуть пустой
// массив и вывести сообщение об ошибке.

package Homework2;

import java.util.Arrays;

public class task3 {

    public static void main(String[] args) {
         String[] arr = {"apple", "banana", "cherry", "date", null,  "elderberry"};
         System.err.println(Arrays.toString(sortStrings(arr)));
    }
    public static String[] sortStrings(String[] arr) {

        try{
            
            if (arr == null) {
                System.out.println("массив содержит null");
                return new String[0] ;
            }
            Arrays.sort(arr);
            return arr;
    } catch (Exception e)
    {
        System.out.println("некоректное значение в массиве");
        return new String[0];
    }
        
            
        
    }
}
