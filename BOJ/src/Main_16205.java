import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_16205 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		List<String> words = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		char[] chs = str[1].toCharArray();

		for (char c : chs) {
			
			boolean isUnderscore = c=='_';
			boolean isUpperCase = (Character.isUpperCase(c) && !sb.toString().isEmpty());
			
			if (isUnderscore || isUpperCase) {
				words.add(sb.toString());
				sb.delete(0, sb.length());
			}
			
			if(!isUnderscore) sb.append(c);
			
		}
		words.add(sb.toString());
		
		for(int i=0; i<3; ++i) {
	
			sb.delete(0, sb.length());
			
			for(int j=0; j<words.size(); ++j) {
				
				String word = words.get(j);
				char firstChar = word.charAt(0);
				
				boolean isCamelCase = (i==0 && j==0);
				boolean isSnakeCase = (i==1);
				
				word = (isCamelCase||isSnakeCase)
						? word.replaceFirst(firstChar+"", Character.toLowerCase(firstChar)+"")
						: word.replaceFirst(firstChar+"", Character.toUpperCase(firstChar)+"");
						
				sb.append(word);
				
				boolean isLastChar = (j==words.size()-1);
				
				if(isSnakeCase && !isLastChar) sb.append('_');
				
			}

			System.out.println(sb.toString());
			
		}
		
	}
}