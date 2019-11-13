import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution7 {
	
	static class RecommendScore implements Comparable<RecommendScore> {
		String name;
		int score;
	
		public RecommendScore(String name, int score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo(RecommendScore o) {
			return (this.score==o.score)
					?this.name.compareTo(o.name)
					:o.score-this.score;
		}
	}
	
	public static void main(String[] args) {
		
		String user = "mrko";
		String[][] friends = { 
								{"donut", "andole"}, 
								{"donut", "jun"}, 
								{"donut", "mrko"}, 
								{"shakevan", "andole"}, 
								{"shakevan", "jun"}, 
								{"shakevan", "mrko"} 
							};
		String[] visitors = {"bedi", "bedi", "donut", "bedi", "shakevan"};
		
		String[] answer = solution(user, friends, visitors);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	public static String[] solution(String user, String[][] friends, String[] visitors) {
        
		List<String> userFriends = new LinkedList<>();
        
        for(String[] friend : friends) {
        	
        	if(!(friend[0].equals(user)||(friend[1].equals(user)))) continue;
        	
        	String friendName = friend[0].equals(user)? friend[1] : friend[0];
        	
        	userFriends.add(friendName);
        	
        }
        
        HashMap<String, Integer> recommendedFriends = new HashMap<>();
        
        for(int i=0; i<userFriends.size(); ++i) {
        	
        	String userFriend = userFriends.get(i);
        	
        	for(String[] friend : friends) {
            	
        		if(!(friend[0].equals(userFriend)||(friend[1].equals(userFriend)))) continue;
   
            	String friendName = friend[0].equals(userFriend)? friend[1] : friend[0];
            	
            	if(friendName.equals(user)) continue;
        		
            	int score = recommendedFriends.containsKey(friendName)
        					? recommendedFriends.get(friendName)
        					: 0;
            	
        		recommendedFriends.put(friendName, score+10);			
        		
            }
        	
        }
        
        for(String visitor : visitors) {
        	if(userFriends.contains(visitor)) continue;
        	int score = recommendedFriends.containsKey(visitor)
					? recommendedFriends.get(visitor)
					: 0;
			recommendedFriends.put(visitor, score+1);
        }
     
        PriorityQueue<RecommendScore> q = new PriorityQueue<>();
        Set<String> keys = recommendedFriends.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	int score = recommendedFriends.get(key);
        	q.add(new RecommendScore(key, score));
        }
        
        int len = (q.size()<5)? q.size() : 5;
        String[] answer = new String[len];
        for(int i=0; i<len; ++i) {
        	answer[i] = q.poll().name;
        }
        
        return answer;
        
    }
	
}
