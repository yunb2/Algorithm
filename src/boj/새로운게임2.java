package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 새로운게임2 {

    static int N, K;
    static int[][] map;
    static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
    static Node[][] state;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        map = new int[N][N];
        state = new Node[N][N];

        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        Node[] nodes = new Node[K];
        for(int i=0; i<K; ++i) {
            nodes[i] = new Node(i+1, br.readLine().split(" "));
            state[nodes[i].r][nodes[i].c] = nodes[i];
        }

        int t = 0;
        while(t++ < 1000) {

            for(int i=0; i<K; ++i) {

                Node cn = nodes[i];

                int nr = cn.r + dir[cn.d][0];
                int nc = cn.c + dir[cn.d][1];

                if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc] == 2) {
                    cn.d += (cn.d%2 == 0)? 1 : -1;
                    nr = cn.r + dir[cn.d][0];
                    nc = cn.c + dir[cn.d][1];
                    if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc] == 2) continue;
                }

                LinkedList<Node> list = cn.getTops();

                if(cn.bottom != null) {
                    cn.bottom.top = null;
                    state[cn.r][cn.c] = cn.bottom;
                } else {
                    state[cn.r][cn.c] = null;
                }

                while(!list.isEmpty()) {

                    Node node = (map[nr][nc] == 1)? list.pollFirst() : list.pollLast();

                    if(state[nr][nc] == null) {
                        node.bottom = node.top = null;
                        state[nr][nc] = node;
                    } else {
                        node.bottom = state[nr][nc];
                        node.top = null;
                        state[nr][nc].top = state[nr][nc] = node;
                    }

                    node.r = nr;
                    node.c = nc;
                }

                if(state[nr][nc].cnt() >= 4) {
                    System.out.println(t);
                    return;
                }

            }

        }

        System.out.println(-1);
    }

    static class Node {
        int i, r, c, d;
        Node top, bottom;

        Node(int i, String[] str) {
            this.i = i;
            this.r = Integer.parseInt(str[0])-1;
            this.c = Integer.parseInt(str[1])-1;
            this.d = Integer.parseInt(str[2])-1;
        }

        LinkedList<Node> getTops() {
            LinkedList<Node> list = (top==null)? new LinkedList<>() : top.getTops();
            list.add(this);
            return list;
        }

        int cnt() {
            return (bottom==null)? 1 : bottom.cnt()+1;
        }
    }

}
