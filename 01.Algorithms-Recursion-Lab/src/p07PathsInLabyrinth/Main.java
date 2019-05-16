package p07PathsInLabyrinth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Character[][] labyrinth;
    private static List<Character> path = new ArrayList<>();
    private static int rows;
    private static int cols;

    public static void main(String[] args) throws IOException {
        readLabyrinth();
        solve(0, 0, 'S');
    }

    private static void readLabyrinth() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        rows = Integer.parseInt(reader.readLine());
        cols = Integer.parseInt(reader.readLine());

        labyrinth = new Character[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentLine = reader.readLine();
            for (int col = 0; col < cols; col++) {
                labyrinth[row][col] = currentLine.charAt(col);
            }
        }
    }

    private static void solve(int row, int col, Character direction){
        if (outsideOfLabyrinth(row, col)){
            return;
        }

        path.add(direction);

        if (isExit(row, col)){
            printSolution();
            return;
        }

        if (isPassable(row, col)){
            labyrinth[row][col] = 'x';

            solve(row + 1, col, 'D');
            solve(row - 1, col, 'U');
            solve(row, col + 1, 'R');
            solve(row, col - 1, 'L');

            labyrinth[row][col] = '-';
        }
        path.remove(path.size() - 1);
    }

    private static boolean isPassable(int row, int col) {
        return labyrinth[row][col] != 'x' && labyrinth[row][col] != '*';
    }

    private static void printSolution() {
        System.out.println(path);
    }

    private static boolean isExit(int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean outsideOfLabyrinth(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}
