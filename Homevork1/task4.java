package Homevork1;

import java.util.ArrayList;
import java.util.List;

// Задача 4. Поиск и замена строк
// Реализуйте метод findAndReplace, который принимает массив строк, строку
// для поиска и строку для замены. Если искомая строка не найдена, добавьте
// сообщение об ошибке в список. Верните новый массив строк с выполненной
// заменой.


public class task4 {
    

    public static void main(String[] args) {

        List <String> error = new ArrayList<String>();
        String[] arr = {"Hello", "World", "Hello", "Java", "Hello"};
        String search = "Hi";
        String replace = "Bye";

        String[] result = findAndReplace(arr, search, replace, error);
        System.out.println(java.util.Arrays.toString(result)); // Output: [Bye, World, Bye, Java, Bye]

        System.out.println(error); // Output: [Строка 'Hello' не найдена.]
        
    }

    public static String[] findAndReplace(String[] arr, String search, String replace, List<String> error) {

        boolean found = false;

        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(search)) {
                result[i]=(replace);
                found = true;
            } else {
                result[i] = arr[i];
            }
        }

        if (!found){
            error.add("Строка '" + search + "' не найдена.");
        }
        
        return result;
    }
}
    
    

