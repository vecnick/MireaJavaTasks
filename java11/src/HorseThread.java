class HorseThread implements Runnable  // Класс HorseThread, использующий интерфейс Runnable.
{
    private Object lock;  // Объявление поля lock.
    private String name;  // Объявление поля name.

    public HorseThread(Object lock, String name)  // Конструктор класса HorseThread.
    {
        this.lock = lock;
        this.name = name;
    }

    @Override  // Метод – перегруженный, так как в Java уже есть встроенный метод run() для потоков.
    public void run()  // Метод для потока, который запустится после запуска потока методом start().
    {
        synchronized (lock)  // Данный блок может выполняться только одним потоком одновременно.
        {
            String s = "";  // Объявление строковой переменной s и её инициализация со значением "".
            for (int i = 0; i < 10001; i++)  // Повторять от 0 до 10001 с шагом 1:
            {
                if (i == 10000)  // Если i = 10000:
                {
                    s = " финишировала!";
                    System.out.println(name + s);  // Вывод имени лошади ("Лошадь_" + номер_лошади).
                    try  // При отсутствии исключений:
                    {
                        Thread.sleep(1000);  // Приостановка потока на 1 секунду (добавление остановок при выводе).
                    }
                    catch (InterruptedException e)  // В случае исключения:
                    {
                        e.printStackTrace();  // Указание точной строки, в которой метод вызвал исключение, а также название метода.
                    }
                    lock.notify();  // Продолжение работы того потока, который находится в режиме ожидания (у которого ранее был вызван метод wait()).
                    try  // При отсутствии исключений:
                    {
                        lock.wait(1000);  // Приостановка потока на 1 секунду или установка в режим ожидания, пока другим потоком не будет вызван метод notify().
                    }
                    catch (InterruptedException e)  // В случае исключения:
                    {
                        e.printStackTrace();  // Указание точной строки, в которой метод вызвал исключение, а также название метода.
                    }
                }
            }
        }
    }
}