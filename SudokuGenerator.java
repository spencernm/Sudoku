import java.util.ArrayList;

public class SudokuGenerator {

    public static void main(String[] args) {
        // Part 1: Use a 2D array to store the final board
        int[][] board = new int[9][9];

        // Part 1: Use an ArrayList to create our base set of numbers
        ArrayList<Integer> seedNums = generateShuffledList();

        // Fill the 2D array using a shifting logic pat  tern
        fillBoard(board, seedNums);

        // Print the completed solved Sudoku board neatly
        printBoard(board);
    }

    /**
     * Creates an ArrayList with numbers 1-9 and shuffles them 
     * manually using Math.random().
     */
    public static ArrayList<Integer> generateShuffledList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        // Manual Shuffle Logic
        for (int i = 0; i < list.size(); i++) {
            // Generate a random index from 0 to 8
            int randomIndex = (int) (Math.random() * list.size());
            
            // Swap current element with the element at the random index
            int temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }
        return list;
    }

    /**
     * Logic: To ensure no repeats in rows, columns, or 3x3 boxes,
     * we shift the starting position of the seed list for every row.
     */
    public static void fillBoard(int[][] board, ArrayList<Integer> seed) {
        for (int r = 0; r < 9; r++) {
            /* Pattern Formula: (row * 3 + row / 3) % 9
               This shift ensures that the numbers wrap around in a way 
               that satisfies all Sudoku rules.
            */
            int shift = (r * 3 + r / 3) % 9;
            
            for (int c = 0; c < 9; c++) {
                int index = (c + shift) % 9;
                board[r][c] = seed.get(index);
            }
        }
    }

    /**
     * Formats the output for the console.
     */
    public static void printBoard(int[][] board) {
        System.out.println("   SOLVED SUDOKU GENERATOR");
        System.out.println("-------------------------");
        for (int r = 0; r < 9; r++) {
            // Print a separator every 3 rows
            if (r > 0 && r % 3 == 0) {
                System.out.println("------+-------+------");
            }
            
            for (int c = 0; c < 9; c++) {
                // Print a separator every 3 columns
                if (c > 0 && c % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}