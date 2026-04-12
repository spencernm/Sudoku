import java.util.ArrayList;

public class Sudoku{
    public static void main(String[] args){
        int[][] board = new int[9][9];
        ArrayList<Integer> seedNums = generateShuffledList();

        fillBoard(board, seedNums);
        printBoard(board);
    }
    
    public static ArrayList<Integer> generateShuffledList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++){
            int rand = (int) (Math.random() * 9);
            int temp = list.get(i);
            list.set(i, list.get(rand));
            list.set(rand, temp);
        }
        return list;
    }
    
    public static boolean fillBoard(int[][] board, ArrayList<Integer> seedNums){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if (board[row][col] == 0){
                    
                    for (int num : seedNums) {
                        if (isValid(board, row, col, num)){
                            board[row][col] = num;
                            
                            if (fillBoard(board, seedNums)){
                                return true;
                            }
                            else
                            board[row][col] = 0; 
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++){
            if (board[row][i] == num || board[i][col] == num){
                return false;
            }
            int boxRow = 3*(row / 3) + i/3;
            int boxCol = 3*(col / 3) + i%3;
            if (board[boxRow][boxCol] == num){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] board){
        System.out.println("Solved Sudoku Generator");
        System.out.println("---------------------");
        for (int r = 0; r < 9; r++){
            if (r > 0 && r % 3 == 0){
                System.out.println("------+-------+------");
            }
            
            for (int c = 0; c < 9; c++){
                if (c > 0 && c % 3 == 0){
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}