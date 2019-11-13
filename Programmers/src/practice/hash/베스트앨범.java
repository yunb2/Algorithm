package practice.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class º£½ºÆ®¾Ù¹ü {

	public static void main(String[] args) {
		
		String[] genres = {"classic","rock","pop","pop","classic"};
		int[] plays = {500,600,150,800,2500};
		
		int[] answer = solution(genres, plays);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	static class Genre implements Comparable<Genre> {
		String title;
		int totalPlay;
		Genre(String title, int total) {
			this.title = title;
			this.totalPlay = total;
		}
		@Override
		public int compareTo(Genre o) {
			return o.totalPlay-this.totalPlay;
		}
	}
	
	static class Music implements Comparable<Music> {
		int index, play;
		Music(int i, int p){
			this.index = i;
			this.play = p;
		}
		@Override
		public int compareTo(Music o) {
			return o.play-this.play;
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {

		PriorityQueue<Genre> gq = new PriorityQueue<>();
		HashMap<String, Integer> gm = new HashMap<>();
		HashMap<String, PriorityQueue<Music>> mm = new HashMap<>();
		
		for(int i=0; i<genres.length; ++i) {
			
			gm.put(genres[i], gm.getOrDefault(genres[i], 0)+plays[i]);

			PriorityQueue<Music> q = mm.getOrDefault(genres[i], new PriorityQueue<>());
			q.add(new Music(i, plays[i]));
			mm.put(genres[i], q);
			
		}
		
		for(String key : gm.keySet()) gq.add(new Genre(key, gm.get(key)));
		
		List<Integer> list = new LinkedList<>();
		
		while(!gq.isEmpty()) {
			
			Genre genre = gq.poll();
			
			PriorityQueue<Music> q = mm.get(genre.title);

			list.add(q.poll().index);
			
			if(q.isEmpty()) continue;
			
			list.add(q.poll().index);
			
		}
		
		int[] answer = new int[list.size()];
		
		for(int i=0; i<list.size(); ++i) answer[i] = list.get(i);
		
		return answer;
		
	}
	
}
