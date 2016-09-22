/* Source of the question:
 * https://leetcode.com/problems/valid-sudoku/
 * */
import java.util.HashMap;

public class Easy_ValidSudoku {
	
	public static void main(String []args) {
		// Define a two-dimensional array
		char[][] board = {	{'.','.','.','.','.','.','.','.','.'}, 
							{'.','.','.','.','.','.','3','.','.'},
							{'.','.','.','1','8','.','.','.','.'},
							{'.','.','.','7','.','.','.','.','.'},
							{'.','.','.','.','1','.','9','7','.'},
							{'.','.','.','.','.','.','.','.','.'},
							{'.','.','.','3','6','.','1','.','.'},
							{'.','.','.','.','.','.','.','.','.'},
							{'.','.','.','.','.','.','.','2','.'}	};
		Easy_ValidSudoku e = new Easy_ValidSudoku();
		System.out.println(	e.isValidSudoku(board)	);
	}
	
    public boolean isValidSudoku(char[][] board) {
    	int i,k;
    	HashMap< Character, Integer > map = new HashMap<>();

    	for( i = 0 ; i < 9 ; i++ ) {
    		
    		// Rows
    		for( char j : board[i] ){
    			if( map.containsKey(j) && Character.isDigit(j) ){
    				return false;
    			}
    			map.put(j,1);
    		}
    		
    		map.clear();
    		// Columns
    		for( k=0; k<9; k++ ) {
    			if( Character.isDigit(board[k][i])  && map.containsKey(board[k][i]) ){
    				return false;
    			}
    			map.put(board[k][i],1);
    		}

    		map.clear();
    	}
    	
    	// Cubes
    	for(i=0; i<3; i++ ) {
    		for( k=0; k<3;k++ ){
    			for( int j=0; j<9; j++ ) {
    				if( Character.isDigit(board[j/3+i*3][j%3+k*3])  && map.containsKey(board[j/3+i*3][j%3+k*3]) ){
    					return false;
    				}
    					map.put(board[j/3+i*3][j%3+k*3] , 1);
    			}
    			map.clear();
    		}
    	}
		
		return true;
    }
}
