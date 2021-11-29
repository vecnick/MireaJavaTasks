package work;

public class PingPong {
    public static void main(String[] args)
    {
        Object lock = new Object();  // Объявление объекта lock, который будет необходим для подачи доступа в метод потокам.
        Thread ping = new Thread(new PingPongThread(lock, "Ping"));  // Объявление потока "ping" как объекта класса PingPongThread.
        Thread pong = new Thread(new PingPongThread(lock, "Pong"));  // Объявление потока "pong" как объекта класса PingPongThread.
        ping.start();  // Запуск потока "ping".
        pong.start();  // Запуск потока "pong".
    }
}
