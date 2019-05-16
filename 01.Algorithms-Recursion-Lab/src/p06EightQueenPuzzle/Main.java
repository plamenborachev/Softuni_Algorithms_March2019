package p06EightQueenPuzzle;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static Set<Integer> attackedRows = new HashSet<>();
    private static Set<Integer> attackedCols = new HashSet<>();
    private static Set<Integer> attackedLeftDiagonals = new HashSet<>();
    private static Set<Integer> attackedRightDiagonals = new HashSet<>();
    private static int solutionsFound = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.println(solutionsFound);
    }

    private static void solve(int row){
        if (row == SIZE) {
            printSolution();
            return;
        }
        for (int col = 0; col < SIZE; col++) {
            if (canPlaceQueen(row, col)) {
                markAttackedFields(row, col);
                solve(row + 1);
                unmarkAttackedFields(row, col);
            }
        }
    }

    private static void printSolution () {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[col][row] == 1) {
                    sb.append("* ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());
        solutionsFound++;
        System.out.println(sb.toString());
    }

    private static void unmarkAttackedFields ( int row, int col){
        board[row][col] = 0;
        attackedRows.remove(row);
        attackedCols.remove(col);
        attackedLeftDiagonals.remove(col - row);
        attackedRightDiagonals.remove(col + row);
    }

    private static void markAttackedFields ( int row, int col){
        board[row][col] = 1;
        attackedRows.add(row);
        attackedCols.add(col);
        attackedLeftDiagonals.add(col - row);
        attackedRightDiagonals.add(col + row);
    }

    private static boolean canPlaceQueen ( int row, int col){
        boolean positionOccupied = attackedRows.contains(row)
                || attackedCols.contains(col)
                || attackedLeftDiagonals.contains(col - row)
                || attackedRightDiagonals.contains(col + row);
        return !positionOccupied;
//        if (attackedRows.contains(row) || attackedCols.contains(col)) {
//            return false;
//        }
//        //left-up diagonal
//        for (int i = 1; i < SIZE; i++) {
//            int currentRow = row - i;
//            int currentCol = col - i;
//
//            if (currentRow < 0 || currentRow >= SIZE
//                    || currentCol < 0 || currentCol >= SIZE) {
//                break;
//            }
//            //Queen here
//            if (board[currentRow][currentCol] == 1) {
//                return false;
//            }
//        }
//
//        //right-up diagonal
//        for (int i = 1; i < SIZE; i++) {
//            int currentRow = row - i;
//            int currentCol = col + i;
//
//            if (currentRow < 0 || currentRow >= SIZE
//                    || currentCol < 0 || currentCol >= SIZE) {
//                break;
//            }
//            //Queen here
//            if (board[currentRow][currentCol] == 1) {
//                return false;
//            }
//        }
//
//        //left-down diagonal
//        for (int i = 1; i < SIZE; i++) {
//            int currentRow = row + i;
//            int currentCol = col - i;
//
//            if (currentRow < 0 || currentRow >= SIZE
//                    || currentCol < 0 || currentCol >= SIZE) {
//                break;
//            }
//            //Queen here
//            if (board[currentRow][currentCol] == 1) {
//                return false;
//            }
//        }
//
//        //right-down diagonal
//        for (int i = 1; i < SIZE; i++) {
//            int currentRow = row + i;
//            int currentCol = col + i;
//
//            if (currentRow < 0 || currentRow >= SIZE
//                    || currentCol < 0 || currentCol >= SIZE) {
//                break;
//            }
//            //Queen here
//            if (board[currentRow][currentCol] == 1) {
//                return false;
//            }
//        }
//
//        return true;
    }

}
