import java.util.ArrayList;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        ArrayList<Integer> seedNums = generateShuffledList();

        fillBoard(board, seedNums);
        printBoard(board);
    }
    
    public static ArrayList<Integer> generateShuffledList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            int rand = (int) (Math.random() * 9);
            int temp = list.get(i);
            list.set(i, list.get(rand));
            list.set(rand, temp);
        }
        return list;
    }
    
    public static void fillBoard(int[][] board, ArrayList<Integer> seedNums) {
        for (int r = 0; r < 9; r++) {
            int shift = (r * 3 + r / 3) % 9;
            for (int c = 0; c < 9; c++) {
                int index = (c + shift) % 9;
                board[r][c] = seedNums.get(index);
            }
        }
    }

    public static void printBoard(int[][] board) {
        System.out.println("Solved Sudoku Generator");
        System.out.println("---------------------");
        for (int r = 0; r < 9; r++) {
            if (r > 0 && r % 3 == 0) {
                System.out.println("------+-------+------");
            }
            
            for (int c = 0; c < 9; c++) {
                if (c > 0 && c % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}