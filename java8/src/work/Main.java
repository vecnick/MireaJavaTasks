package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static class Pet {}
    static class Cat extends Pet {}
    static class Dog extends Pet {}
    static class Owl extends Pet {}
    public static void main(String[] args) {
        HashMap<String, Pet> hashmap = new HashMap<>();
        hashmap.put("Pet", new Pet());
        hashmap.put("Cat", new Cat());
        hashmap.put("Dog", new Dog());
        hashmap.put("Owl", new Owl());
        Object[] arr_1 = hashmap.keySet().toArray();
        Object[] arr_2 = hashmap.values().toArray();
        System.out.print(arr_1[0] + " ");
        System.out.println(arr_2[0]);
        System.out.print(arr_1[1] + " ");
        System.out.println(arr_2[1]);
        System.out.print(arr_1[2] + " ");
        System.out.println(arr_2[2]);
        System.out.print(arr_1[3] + " ");
        System.out.println(arr_2[3]);
        hashmap.put("Garfield", new Cat());

        List<Integer> numbers = new ArrayList<Integer>(20);
        int count = 0;
        for (int i = 0; i < 20; i++) {
            int n = (int) (Math.random() * 19);
            if (numbers.contains(n)) count++;
            numbers.add(n);
        }
        System.out.println(numbers);
        System.out.println(count);
    }
}