package JavaModule00.ex00;

public class Program {
    public static void main(String[] args) {
        int number = 479598;
        System.out.println(getDigitSum(number));
    }

    public static int bitwiseAdd(int a, int b) {
        if (b == 0) {
            return a; // Base case: no carry left
        }
        int sumWithoutCarry = a ^ b;      // XOR sums corresponding bits
        int carry = (a & b) << 1;         // AND identifies carry bits, shifted left
        return bitwiseAdd(sumWithoutCarry, carry); // Recursively add carry
    }

    public static int getDigitSum(int number) {
        // Base case: if the number reduces to 0, sum contribution is 0
        if (number == 0) {
            return 0;
        }

        int lastDigit = number % 10;
        int remainingNumber = number / 10;

        // Combine the last digit with the sum of remaining digits using bitwise addition
        return bitwiseAdd(lastDigit, getDigitSum(remainingNumber));
    }
}
