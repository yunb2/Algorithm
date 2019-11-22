import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main_1181 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; ++i) set.add(br.readLine());
		
		List<String> list = new LinkedList<>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) list.add(it.next());
		
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length()==o2.length()? o1.compareTo(o2) : o1.length()-o2.length(); 
			}
		});

		for(String s : list) sb.append(s+'\n');
		System.out.println(sb.toString());
	}
	
}
