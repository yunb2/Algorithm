package practice.hash;

import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {

		String[][] participants = {
				{"leo", "kiki", "eden"},
				{"marina", "josipa", "nikola", "vinko", "filipa"},
				{"mislav", "stanko", "mislav", "ana"}
		};
		
		String[][] completions = {
				{"eden", "kiki"},
				{"josipa", "filipa", "marina", "nikola"},
				{"stanko", "ana", "mislav"}
		};
		
		String[] answer = { "leo", "vinko", "mislav" };
		
		for(int t=0; t<3; ++t) {
			System.out.println("#"+(t+1)+" "+solution(participants[t], completions[t]).equals(answer[t]));
		}
		
	}
	
	public static String solution(String[] participant, String[] completion) {
		
		HashMap<String, Integer> playerMap  = new HashMap<>();
		
		for(String player : participant) playerMap.put(player, playerMap.getOrDefault(player, 0)+1);
		for(String player : completion) playerMap.put(player, playerMap.get(player)-1);
		for(String player : playerMap.keySet()) if(playerMap.get(player)>0) return player;
		
		return null;
		
    }
	
}
