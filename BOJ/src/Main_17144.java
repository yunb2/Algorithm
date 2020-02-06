import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_17144 {

	static int[][][] map;
	static int R, C, T;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static List<int[]> cleaner;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		
		map = new int[2][R][C];
		cleaner = new LinkedList<>();
		
		for(int r=0; r<R; ++r) {
			str = br.readLine().split(" ");
			for(int c=0; c<C; ++c) {
				map[0][r][c] = Integer.parseInt(str[c]);
				if(map[0][r][c] < 0) cleaner.add(new int[] {r, c});
			}
		}

		for(int t=0; t<T; ++t) {
			spread();
			move();
		}
		
		System.out.println(total());
		
	}
	
	public static void spread() {
		
		for(int r=0; r<R; ++r) {
			for(int c=0; c<C; ++c) {
				
				if(map[0][r][c] <= 0) continue;
				
				int dust = map[0][r][c] / 5;
				
				for(int d=0; d<4; ++d) {
					
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
					
					if(nr<0||nr>=R||nc<0||nc>=C||map[0][nr][nc]<0) continue;
					
					map[0][r][c] -= dust;
					map[1][nr][nc] += dust;
					
				}
			}
		}

		for(int r=0; r<R; ++r) {
			for(int c=0; c<C; ++c) {
				
				map[0][r][c] += map[1][r][c];
				map[1][r][c] = 0;
				
			}
		}
		
	}

	public static void move() {
		
		int r = cleaner.get(0)[0]-1;
		int c = cleaner.get(0)[1];
		int d = 0;
		
		while(map[0][r][c] >= 0) {
			
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			
			if(nr<0||nr>=R||nc<0||nc>=C||nr > cleaner.get(0)[0]) {
				d++;
				continue;
			}
			
			if(map[0][nr][nc]<0) {
				map[0][r][c] = 0;
				break;
			}
			
			map[0][r][c] = map[0][nr][nc];
			r = nr;
			c = nc;
			
		}
		
		r = cleaner.get(1)[0]+1;
		c = cleaner.get(1)[1];
		d = 2;
		
		while(map[0][r][c] >= 0) {
			
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			
			if(nr<0||nr>=R||nc<0||nc>=C||nr < cleaner.get(1)[0]) {
				if(--d < 0) d = 3;
				continue;
			}
			
			if(map[0][nr][nc]<0) {
				map[0][r][c] = 0;
				break;
			}
			
			map[0][r][c] = map[0][nr][nc];
			r = nr;
			c = nc;
			
		}
		
	}
	
	public static int total() {
		
		int total = 0;
		
		for(int i=0; i<R; ++i) {
			for(int j=0; j<C; ++j) {
				total += map[0][i][j];
			}
		}
		
		return total + 2;
	}
	
}
