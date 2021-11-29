package work;

public class PingPongThread implements Runnable
{
    private Object lock;  // Объявление поля lock.
    private String name;  // Объявление поля name.

    public PingPongThread(Object lock, String name)  // Конструктор класса.
    {
        this.lock = lock;
        this.name = name;
    }

    @Override  // Так как в Java уже есть встроенный метод run() для потоков.
    public void run()  // Метод для потока, который запустится после запуска потока методом start().
    {
        synchronized (lock)  // Данный блок может выполняться только одним потоком одновременно.
        {
            while(true)  // Выполнять:
            {
                System.out.println(name);  // Вывод текущего имени ("ping" или "pong").
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