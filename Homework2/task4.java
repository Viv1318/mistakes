
// Задача 4. Нахождение среднеарифметического числа
// Напишите метод, который находит среднее значение массива целых чисел.
// Если массив пустой или null, метод должен вернуть Double.NaN и вывести
// сообщение об ошибке.

package Homework2;

public class task4 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 4, 5};
        double average = findAverage(arr);
        System.out.println("Среднее значение массива: " + average);
        
    }

    public static double findAverage(int[] arr) {
        try{
        if (arr == null || arr.length == 0) {
            System.out.println("Массив пуст или null.");
            return Double.NaN;
        }

        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        return  sum / arr.length;
    }catch (Exception e){
        System.out.println("Ошибка: " + e.getMessage());
        return Double.NaN;
    }
}
}
