
// Задача 2. Проверка строки на палиндром
// Напишите метод, который проверяет, является ли введенная строка
// палиндромом. Если строка палиндром, возвращайте "Palindrome". Если нет
// — "Not a palindrome".



package Homework2;

public class task2 {
    public static void main(String[] args) {

        String str = "A man a plan a canal Panama";
        System.out.println(checkPalindrome(str));
        
    }

    public static String checkPalindrome(String str) {
        try{
        // Приводим все символы к нижнему регистру
        str = str.toLowerCase();
        
        // Удаляем все знаки пунктуации и пробелы
        str = str.replaceAll("[^a-z0-9]", "");
        
        // Проверяем, является ли полученная строка палиндромом

        // Обратите внимание: StringBuilder может быть более эффективным для реверса
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversedStr)? "Palindrome" : "Not a palindrome";
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}
}
