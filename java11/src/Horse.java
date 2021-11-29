import java.util.Scanner;  // Импорт класса Scanner для считывания данных.
import java.util.List; // Импорт класса List, описывающий упорядоченную последовательность объектов.
import java.util.ArrayList;  // Импорт класса ArrayList, реализующий изменяемый массив интерфейса List.


public class Horse  // Основной класс.
{
    public static void main(String[] args)  // Главная функция.
    {
        Scanner in = new Scanner(System.in);  // Объявление объекта in класса Scanner с указанным источником данных (строка с текстом в консоли).
        System.out.print("Введите кол-во лошадей (n): ");  // Вывод в консоль: "Введите кол-во лошадей (n): ".
        int n = in.nextInt();  // Объявление целочисленной переменной n и её инициализация со значением, введённым через консоль.
        startHorses(n);  // Запуск метода "startHorses" для запуска n лошадей.
    }

    public static void startHorses(int horses_number)  // Метод для запуска horses_number лошадей.
    {
        Object lock = new Object();  // Объявление объекта lock, который будет необходим для подачи доступа в метод потокам.
        List<Thread> horses = new ArrayList<Thread>(horses_number);  // Объявление изменяемого массива horses из horses_number потоков.
        String number;  // Объявление строковой переменной number для указания номера лошади в имени.
        for (int i = 1; i < horses_number + 1; i++)  // Повторять от 1 до horses_number + 1 с шагом 1:
        {
            number = i < 10 ? ("0" + i) : "" + i;  // Если i < 10, то number = "0" + i, иначе – number = "" + i.
            Thread horse_i = new Thread(new HorseThread(lock, "Лошадь_" + number));  // // Объявление потока horse_i как объекта класса HorseThread.
            horses.add(horse_i);  // Добавление потока horse_i в массив horses.
        }
        for (int i = 0; i < horses_number; i++)  // Повторять от 0 до horses_number с шагом 1:
        {
            horses.get(i).start();  // Запуск потока с индексом i из массива horses.
        }
    }
}
