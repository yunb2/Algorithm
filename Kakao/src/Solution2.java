import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"	;
		
		int[] answer = solution(s);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	public static int[] solution(String s) {
		
		char[] chars = s.toCharArray();
		
		List<ArrayList> gList = new LinkedList<>();
		ArrayList<Integer> lList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		for(int i=1; i<chars.length-1; ++i) {
			
			switch(chars[i]) {
			case '{': break;
			case ',':
				if(chars[i-1]=='}') break;
				
				num = Integer.parseInt(sb.toString());
				lList.add(num);
				sb.delete(0, sb.length());
				
				break;
			case '}': 
				num = Integer.parseInt(sb.toString());
				lList.add(num);
				sb.delete(0, sb.length());
				
				gList.add((ArrayList) lList.clone());
				lList.clear();
				
				break;
			default:
				sb.append(chars[i]);
				break;
			}
			
		}
		
		Collections.sort(gList, new Comparator<ArrayList>() {
			@Override
			public int compare(ArrayList o1, ArrayList o2) {
				return o1.size()-o2.size();
			}
		});
	
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<gList.size(); ++i) {

			lList = gList.get(i);
			
			for(int j=0; j<lList.size(); ++j) {
				int temp = lList.get(j);
				if(list.contains(temp)) continue;
				list.add(temp);
			}
			
		}
		
		int[] answer = new int[list.size()];
		
		for(int i=0; i<list.size(); ++i) {
			answer[i] = list.get(i);
		}
		
        return answer;
    }
	
}
