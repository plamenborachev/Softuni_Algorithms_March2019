package p01Fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers;

    private static int fibonacci(int n){
        if (numbers[n] != 0){
            return numbers[n];
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        numbers[n] = result;
        return result;
    }
    public static void main(String[] args) throws IOException {
        numbers = new int[100];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(fibonacci(n));
    }
}
