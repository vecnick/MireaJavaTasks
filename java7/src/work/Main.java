package work;

import java.util.Stack;

public class Main {
    public static Stack<Integer> arr1;
    public static Stack<Integer> arr2;

    public static void main(String[] args) {
        arr1 = new Stack<>();
        arr2 = new Stack<>();
        int[] a1 = new int[5];
        int[] a2 = new int[5];

        for (int i = 0; i < 5; i++) {
            a1[i] = ((int) (Math.random() * 9));
            a2[i] = ((int) (Math.random() * 9));
            arr2.push(a1[i]);
            arr1.push(a2[i]);
        }

        System.out.println(arr1);
        System.out.println(arr2);

        int maxSteps = 106;
        int i;
        for (i = 0; !arr1.isEmpty() && !arr2.isEmpty() && i < maxSteps; i++) {
            int first = arr1.pop();
            int second = arr2.pop();

            if ((first == 0 && second == 9) || first > second && (first != 9 && second != 0)) {
                arr1.push(first);
                arr1.push(second);
            } else if (first < second || (first == 9 && second == 0)) {
                arr2.push(first);
                arr2.push(second);
            }
        }

        if(maxSteps == i) {
            System.out.println("botva");
        } else if (arr1.isEmpty()) {
            System.out.println("second " + i);
        } else if (arr2.isEmpty()) {
            System.out.println("first " + i);
        }
        System.out.println(arr1);
        System.out.println(arr2);
    }
}