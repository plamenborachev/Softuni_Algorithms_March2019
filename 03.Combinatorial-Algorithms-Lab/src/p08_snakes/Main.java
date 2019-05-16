package p08_snakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static  char[] currentSnake;
    private static Set<String> visitedCells = new HashSet<>();
    private static Set<String> result = new HashSet<>();
    private static Set<String> allPossibleSnakes = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        currentSnake = new char[n];
        generateSnakes(0, 0, 0, 'S');
        for (String snake : result) {
            System.out.println(snake);
        }
        System.out.println(String.format("Snakes count = %s", result.size()));
    }

    static void generateSnakes(int index, int row, int col, char direction){
        if (index >= currentSnake.length){
            markSnake();
        } else {
            String cell = String.format("%s %s", row, col);
            if (!visitedCells.contains(cell)){
                currentSnake[index] = direction;
                visitedCells.add(cell);
                generateSnakes(index + 1, row, col + 1, 'R');
                generateSnakes(index + 1, row + 1, col, 'D');
                generateSnakes(index + 1, row, col - 1, 'L');
                generateSnakes(index + 1, row - 1, col, 'U');
                visitedCells.remove(cell);
            }
        }
    }

    private static void markSnake() {
        String normalSnake = new String(currentSnake);
        if (allPossibleSnakes.contains(normalSnake)){
            return;
        }
        result.add(normalSnake);
        String flippedSnake = flip(normalSnake);
        String reversedSnake = reverse(normalSnake);
        String reversedFlippedSnake = flip (reversedSnake);


//        for each of 4 rotations
        for (int i = 0; i < 4; i++) {
            allPossibleSnakes.add(normalSnake);
            normalSnake = rotate(normalSnake);

            allPossibleSnakes.add(flippedSnake);
            flippedSnake = rotate(flippedSnake);

            allPossibleSnakes.add(reversedSnake);
            reversedSnake = rotate(reversedSnake);

            allPossibleSnakes.add(reversedFlippedSnake);
            reversedFlippedSnake = rotate(reversedFlippedSnake);
        }
    }

    private static String reverse(String snake) {
        char[] newSnake = new char[snake.length()];
        newSnake[0] = 'S';
        for (int i = 1; i < snake.length(); i++) {
            newSnake[snake.length() - i] = snake.toCharArray()[i];
        }
        return new String(newSnake);
    }

    private static String flip(String snake) {
        char[] newSnake = new char[snake.length()];
        for (int i = 0; i < snake.length(); i++) {
            switch (snake.toCharArray()[i]){
                case 'U': newSnake[i] = 'D'; break;
                case 'D': newSnake[i] = 'U'; break;
                default: newSnake[i] = snake.toCharArray()[i]; break;
            }
        }
        return new String(newSnake);
    }

    private static String rotate(String snake) {
        char[] newSnake = new char[snake.length()];
        for (int i = 0; i < snake.length(); i++) {
            switch (snake.toCharArray()[i]){
                case 'R': newSnake[i] = 'D'; break;
                case 'D': newSnake[i] = 'L'; break;
                case 'L': newSnake[i] = 'U'; break;
                case 'U': newSnake[i] = 'R'; break;
                default: newSnake[i] = snake.toCharArray()[i]; break;
            }
        }
        return new String(newSnake);
    }
}
