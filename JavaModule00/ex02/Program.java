package JavaModule00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum;

        int count = 0;
        while ((number = scanner.nextInt()) != 42) {
            System.out.print("-> ");
            if (number <= 1) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            sum = sumOfCoffeeRequests(number);
            if (isPrime(sum)) {
                count++;
            }
        }
        System.out.println("Count of coffee-request : " + count);
    }

    public static int sumOfCoffeeRequests(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static Boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
