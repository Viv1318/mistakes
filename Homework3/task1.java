
// Задание 1. Проверка корректности даты
// Напишите приложение, которое будет запрашивать у пользователя следующие
// данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// дата_рождения - строка формата dd.mm.yyyy
// номер_телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству. Если
// количество не совпадает с требуемым, вернуть код ошибки, обработать его и
// показать пользователю сообщение, что он ввел меньше и больше данных, чем
// требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из
// них требуемые параметры. Если форматы данных не совпадают, нужно бросить
// исключение, соответствующее типу проблемы. Можно использовать встроенные
// типы java и создать свои. Исключение должно быть корректно обработано,
// пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием,
// равным фамилии, в него в одну строку должны записаться полученные данные,
// вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно
// быть корректно обработано, пользователь должен увидеть стектрейс ошибки.



package Homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       System.out.print("Введите фамилию, имя, отчество, дату рождения(в формате dd.mm.yyyy), номер телефона (только цифры) и пол (m или f) через пробел: ");
       String input = scanner.nextLine();
       scanner.close();
       try{ 
       String[] data = input.split(" ");
       if (data.length!= 6) {
           throw new  IllegalArgumentException ("Введено недостаточно или слишком много данных.");
           
       }
    
     String surname = data[0];
     String name = data[1];
     String patronymic = data[2];
     LocalDate dateOfBirth = parseDate(data[3]);
     long phoneNumber = parsePhoneNumber(data[4]);
     char gender = parseGender(data[5]);

     
     writeToFile(surname, name, patronymic, dateOfBirth, phoneNumber, gender);

    }catch (IllegalArgumentException e) {

        System.out.println("Ошибка: " + e.getMessage());
    }catch (DateTimeParseException e1) { 
        System.out.println("Ошибка!!  Неправильный формат даты " );
    }catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private static LocalDate parseDate (String dateOfBirthStr) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateOfBirthStr, formatter);
    }
    
    private static long parsePhoneNumber (String phoneNumberStr){
        try{
            return Long.parseLong(phoneNumberStr);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона.");
        }
    }
    
    private static char parseGender (String genderStr){
        if (genderStr.equalsIgnoreCase("f")) {
            return 'f';
        } else if (genderStr.equalsIgnoreCase("m")) {
            return'm';
        } else {
            throw new IllegalArgumentException("Неверный формат пола, введите 'm' для мужского пола и 'f' для женского пола");
        }
    }
    
    private static void  writeToFile( String surname,String name, String patronymic,LocalDate dateOfBirth, long phoneNumber, char gender) throws IOException {
    String fileName = surname + ".md";
    String line = String.format("%s %s %s %s %d %c", surname, name, patronymic, dateOfBirth, phoneNumber, gender);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
      writer.write(line);
      writer.nullWriter();
      }

    
}
    
}
