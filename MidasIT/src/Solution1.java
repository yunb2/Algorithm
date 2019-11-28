
public class Solution1 {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2},
				{3,4}
		};
		
		print(solution(matrix, 1));
		print(solution(matrix, 2));
		
	}
	
	public static int[][] solution(int[][] matrix, int r){
		
		r %= 4;
		for(int i=0; i<r; ++i) matrix = copyArr(turn(matrix));
		
		return matrix;
	}
	
	public static int[][] turn(int[][] matrix) {
		
		int N = matrix.length;
		int[][] newMat = copyArr(matrix);
		
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		
		for(int i=0; i<N/2; ++i) {
			
			int r = i, c = i, d = 0, cnt = 0;
			
			while(true) {
			
				newMat[r][c] = matrix[N-c-1][r];
				r += dir[d][0];
				c += dir[d][1];
				
				if(++cnt==N-1) { cnt = 0; d++; };
				
				if(d==4) break;
				
			}
		}
		
		return newMat;
		
	}
	
	public static int[][] copyArr(int[][] matrix){
		int N = matrix.length;
		int[][] newMat = new int[N][N];
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				newMat[i][j] = matrix[i][j];
			}
		}
		
		return newMat;
	}
	
	public static void print(int[][] matrix) {
		for(int[] row : matrix) {
			for(int col : row) {
				System.out.format("%2d", col);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
