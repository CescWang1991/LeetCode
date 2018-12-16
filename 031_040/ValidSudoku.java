import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args){
        char[] board = new char[]{'8','3','.','.','7','8','.','.','.'};
        System.out.println(new ValidSudoku().isValidArray(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        if(board.length == 9){
            // verify the rows
            for (int i = 0; i < 9; i++){
                valid = valid && isValidArray(board[i]);
            }
            // verify the columns
            for (int i = 0; i < 9; i++){
                char[] column = new char[9];
                for (int j = 0; j < 9; j++){
                    column[j] += board[j][i];
                }
                valid = valid && isValidArray(column);
            }
            // verify the boxes
            for (int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    char[] box = new char[9];
                    for(int k = 0; k < 9; k++){
                        box[k] = board[i*3 + k/3][j*3 + k%3];
                    }
                    System.out.println(Arrays.toString(box));
                    valid = valid && isValidArray(box);
                }
            }
            return valid;
        } else {
            return false;
        }
    }

    private boolean isValidArray(char[] arr){
        boolean norep = true;
        if(arr.length == 9){
            for(int i = 0; i<8; i++){
                for(int j = i+1; j<9; j++){
                    if(arr[i] != '.' && arr[i] == arr[j]){
                        norep = false;
                    }
                }
            }
            return norep;
        } else {
            return false;
        }
    }
}
