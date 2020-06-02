package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 배 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        Integer[] crane = new Integer[N];
        for(int i=0; i<N; ++i) crane[i] = Integer.parseInt(str[i]);
        Arrays.sort(crane, Comparator.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> boxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        str = br.readLine().split(" ");
        for(int i=0; i<M; ++i) boxQueue.add(Integer.parseInt(str[i]));

        int t = 0;
        while(!boxQueue.isEmpty()) {

            List<Integer> temp = new LinkedList<>();
            boolean check = false;

            for(int i=0; i<N; ++i) {

                if(crane[i] == 0) continue;

                check = true;

                while(!boxQueue.isEmpty()) {

                    int box = boxQueue.poll();

                    if(crane[i] >= box) break;

                    temp.add(box);
                }

                if(boxQueue.isEmpty()) crane[i] = 0;
            }

            if(!check) {
                t = -1;
                break;
            }

            boxQueue.addAll(temp);
            t++;
        }

        System.out.println(t);

    }

}
