package p04Generating01Vectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] vector = new int[n];
        gen01(vector, 0);

    }

    private static void gen01(int[] vector, int index){
        if (index > vector.length - 1){
            for (int value : vector) {
                System.out.print(value);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            gen01(vector, index + 1);
        }
    }
}
