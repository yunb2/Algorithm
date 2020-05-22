package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 상범빌딩 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String[] str = br.readLine().split(" ");

            int L = Integer.parseInt(str[0]);
            int R = Integer.parseInt(str[1]);
            int C = Integer.parseInt(str[2]);

            if(L==0 && R==0 && C==0) break;

            char[][][] building = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            Queue<Node> q = new LinkedList<>();

            for(int i=0; i<L; ++i) {
                for(int j=0; j<R; ++j) {
                    String temp = br.readLine();
                    for(int k=0; k<C; ++k) {

                        building[i][j][k] = temp.charAt(k);
                        if(building[i][j][k]=='S') {
                            q.offer(new Node(i,j,k,0));
                            visited[i][j][k] = true;
                        }

                    }
                }
                br.readLine();
            }

            int ans = -1;
            int[][] dir = {{-1,0,0},{1,0,0},{0,-1,0},{0,0,1},{0,1,0},{0,0,-1}};
            while(!q.isEmpty()) {

                Node cn = q.poll();

                if(building[cn.l][cn.r][cn.c]=='E') {
                    ans = cn.depth;
                    break;
                }

                for(int i=0; i<6; ++i) {

                    int nl = cn.l+dir[i][0];
                    int nr = cn.r+dir[i][1];
                    int nc = cn.c+dir[i][2];

                    if(nl>=0 & nr>=0 && nc>=0 && nl<L && nr<R && nc<C && !visited[nl][nr][nc] && building[nl][nr][nc]!='#') {

                        q.offer(new Node(nl,nr,nc,cn.depth+1));
                        visited[nl][nr][nc] = true;

                    }
                }

            }

            System.out.println((ans>0)?"Escaped in "+ans+" minute(s).":"Trapped!");

        }

    }

    static class Node{
        int l,r,c, depth;
        public Node(int l, int r, int c, int d) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.depth = d;
        }
    }

}
