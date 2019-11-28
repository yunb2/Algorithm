import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14719 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int H = Integer.parseInt(str[0]);
		int W = Integer.parseInt(str[1]);
		boolean[][] buildings = new boolean[H][W];
	
		str = br.readLine().split(" ");
		for(int w=0; w<W; ++w) {
			int height = Integer.parseInt(str[w]);
			for(int h=0; h<height; ++h) buildings[h][w] = true;
		}
		
		int total = 0;
		for(int h=0; h<H; ++h) {
			int cnt = 0;
			boolean start = false;
			
			for(int w=0; w<W; ++w) {
				if(!start) {
					if(buildings[h][w]) start = true;
					continue;
				}
	
				if(!buildings[h][w]) cnt++;
				else {
					total += cnt;
					cnt = 0;
				}
			}
		}
		
		System.out.println(total);
		
	}
	
}
