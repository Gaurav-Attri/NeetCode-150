/**
 * My Solution
 * TC - O(1)
 * SC - O(1)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!validRow(board, i)) return false;
        }

        for(int i = 0; i < 9; i++){
            if(!validColumn(board, i)) return false;
        }

        int a = 0, b = 0, c = 2, d = 2;
        for(int i = 1; i <= 3; i++){
            int count = 0;
            while(count < 3){
                if(!validSubBox(board, a, b, c, d)) return false;
                b += 3;
                d += 3;
                count++;
            }
            a += 3;
            c += 3;
            b = 0;
            d = 2;
            count = 0;
        }

        return true;
    }

    public boolean validRow(char[][] board, int row){
        int[] freq = new int[10];

        for(int col = 0; col < 9; col++) if(board[row][col] != '.') freq[board[row][col]-'0']++;
        for(int i = 1; i <= 9; i++){
            if(freq[i] > 1) return false;
        }

        return true;
    }

    public boolean validColumn(char[][] board, int col){
        int[] freq = new int[10];
        
        for(int row = 0; row < 9; row++) if(board[row][col] != '.') freq[board[row][col]-'0']++;
        for(int i = 1; i <= 9; i++){
            if(freq[i] > 1) return false;
        }

        return true;
    }

    public boolean validSubBox(char[][] board, int a, int b, int c, int d){
        int[] freq = new int[10];

        for(int i = a; i <= c; i++){
            for(int j = b; j <= d; j++){
                if(board[i][j] != '.') freq[board[i][j]-'0']++;
            }
        }
        for(int i = 1; i <= 9; i++){
            if(freq[i] > 1) return false;
        }

        return true;
    }
}