package Homevork1;

// Задание 1. Преобразование строки в число
// Реализуйте метод convertAndSum, который принимает массив строк, каждая
// из которых должна быть преобразована в целое число. Метод возвращает
// сумму всех чисел. Если хотя бы одна строка не может быть преобразована в
// число, метод должен выбросить исключение NumberFormatException.
// Дополнительно, если сумма чисел превышает 100, выбрасывайте
// ArithmeticException с сообщением "Превышен лимит суммы"


public class task1 {

    public static void main(String[] args) {

        String[] strArr = {"1", "2", "3", "4", "tt"};

        try {
            int sum = convertAndSum(strArr);
            System.out.println("Сумма чисел: " + sum);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
       
        
    }

    public static int convertAndSum(String[] strArr) {
        int sum = 0;
        for (String str : strArr) {
            try {
                int num = Integer.parseInt(str);
                sum += num;
                if (sum > 100) {
                    throw new ArithmeticException("Превышен лимит суммы");
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Не удалось преобразовать строку " +str + " в число: ");
            }
        }
        return sum;
    }
}