package JavaModule00.ex01;

import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int i = 2;
        int count = 0;
        boolean isPrime = true;
        while (i * i <= number) {
            count++;
            if (number % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }
        if (isPrime) {
            count++;
        }
        System.out.println(isPrime + " " + count);
    }
}
