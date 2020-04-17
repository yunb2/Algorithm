package programmers.kakao;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500,600,150,800,2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Genre> map = new HashMap<>();

        for(int i=0; i<genres.length; ++i) {

            Genre g = map.getOrDefault(genres[i], new Genre());

            g.total += plays[i];
            g.q.add(new int[] {i, plays[i]});

            map.put(genres[i], g);
        }

        PriorityQueue<Genre> q = new PriorityQueue<>((o1, o2) -> (int) (o2.total-o1.total));
        q.addAll(map.values());

        List<Integer> answer = new LinkedList<>();

        while(!q.isEmpty()) {
            Genre g = q.poll();
            if(g.q.isEmpty()) continue;
            answer.add(g.q.poll()[0]);
            if(g.q.isEmpty()) continue;
            answer.add(g.q.poll()[0]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Genre {
        long total = 0;
        PriorityQueue<int[]> q;

        Genre() {
            this.total = 0;
            this.q =  new PriorityQueue<>((o1, o2) -> {
                if(o2[1]==o1[1]) return o1[0] - o2[0];
                return o2[1] - o1[1];
            });
        }
    }

}
