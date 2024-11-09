
// Задание 1. Проверка корректности даты
// Напишите метод, который проверяет, является ли введенная строка корректной
// датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01
// до 9999-12-31. Если дата корректна, возвращайте её. Если нет — сообщение
// об ошибке.





package Homework2;

public class task1 {

    public static void main(String[] args) {

        String date = "2014-11-05";

        String result = checkDate(date);
        System.out.println(result);
        
    }

    public static String checkDate(String date) {

        try{

        if (date.length() != 10){

            return "Неверный формат даты. Дата должна быть в формате YYYY-MM-DD.";

        }

        String yersStr = date.substring(0, 4);
        String monthStr = date.substring(5, 7);
        String dayStr = date.substring(8,10);

        if (date.charAt(4) != '-' || date.charAt(7) != '-') {

            return "Неверный формат даты. Дата должна быть в формате YYYY-MM-DD.";

        }

        int year = Integer.parseInt(yersStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        
        
    
     if (year < 1 || year > 9999) {

         return "Неверный год. Год должен быть в пределах от 0001 до 9999.";
     }
     if (month < 1 || month > 12) {

        return"Неверный месяц. Месяц должен быть в пределах от 1 до 12";
     }

     int [] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

     if (month == 2 && isLeapYear(year)) {
              dayInMonth[1] = 29;
          }
     
     
          if (day < 1 || day >dayInMonth[month - 1]){
      
              return "Неверный день. День должен быть в пределах от 1 до " + dayInMonth[month - 1];
       
          }
          return date;
     } catch (NumberFormatException e){

         return "Неверный формат даты. Дата должна быть в формате YYYY-MM-DD.";
     } catch (Exception e){
         return "Неизвестная ошибка.";
     
     }
    }
         private static boolean isLeapYear(int year) {
             return (year % 4 == 0 && year % 100 !=0) || (year % 400 == 0 );
         }
        
    
}
