public class Solution2 {
 
    public static void main(String[] args) {
    	
//    	String[] board = {"EEEEE","EEMEE","EEEEE","EEEEE"};
    	String[] board = {"MME", "EEE", "EME"};
    	
//    	String[] answer = solution(board, 2, 0);
    	String[] answer = solution(board, 0, 0);
    	
    	for(int i=0; i<answer.length; ++i) {
    		System.out.println(answer[i]);
    	}
    	
    }
    
    public static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static int X, Y;
    
    public static String[] solution(String[] board, int y, int x) {
    
    	if(board[y].charAt(x)=='M') {
    		char[] chs = board[y].toCharArray();
    		chs[x] = 'X';
    		board[y] = String.valueOf(chs);
    		return board;
    	}

    	Y = board.length;
    	X = board[0].length();
    	
    	int[][] map = new int[Y][X];
    	
    	for(int i=0; i<Y; ++i) {
    		for(int j=0; j<X; ++j) {
    			if(board[i].charAt(j)=='M') {
    				map[i][j] = -1;
    				char[] chs = board[i].toCharArray();
    	    		chs[j] = 'E';
    	    		board[i] = String.valueOf(chs);
    			}
    		}
    	}
    	
    	for(int i=0; i<Y; ++i) {
    		for(int j=0; j<X; ++j) {
    
    			if(map[i][j]>=0) continue;
    			
    			for(int d=0; d<8; ++d) {
    				
    				int ny = i + dir[d][0];
    				int nx = j + dir[d][1];

    				if(ny<0||nx<0||ny>=Y||nx>=X) continue;
    				
    				map[ny][nx]++;
    				
    			}
    		}
    	}
    	
    	return open(board, map, y, x);
    	
    }
     
    public static String[] open(String[] board, int[][] map, int y, int x) {
    	
    	char[] chs = board[y].toCharArray();
    	chs[x] = map[y][x]==0? 'B' : (char)(map[y][x]+'0');
    	board[y] = String.valueOf(chs);
  
    	if(map[y][x]>0) return board;
    	
		for(int d=0; d<8; ++d) {
			
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];

			if(ny<0||nx<0||ny>=Y||nx>=X) continue;
			
			if(board[ny].charAt(nx)!='E') continue;
			
			board = open(board, map, ny, nx);
			
		}
    	
    	return board;
    }

 
}