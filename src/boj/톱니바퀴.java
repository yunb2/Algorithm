package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 톱니바퀴 {

    static int[] o;
    static char[][] gear;

    public static void main(String[] args) throws Exception {

        o = new int[5];
        gear = new char[5][8];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=4; ++i) gear[i] = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i) {

            String[] str = br.readLine().split(" ");

            int num = Integer.parseInt(str[0]);
            int dir = Integer.parseInt(str[1]);

            turn(0, num, dir);
        }

        int sum = 0;
        for(int i=1; i<=4; ++i) {
            if(gear[i][o[i]] == '1') sum += Math.pow(2, i-1);
        }
        System.out.println(sum);
    }

    public static void turn(int from, int num, int dir) {

        int l = num-1, r = num+1;

        if(l != from && l > 0 && gear[num][(o[num]+6)%8] != gear[l][(o[l]+2)%8]) {
            turn(num, l, (-1)*dir);
        }

        if(r != from && r <= 4 && gear[num][(o[num]+2)%8] != gear[r][(o[r]+6)%8]) {
            turn(num, r, (-1)*dir);
        }

        o[num] = (dir > 0)? (o[num]+7)%8 : (o[num]+1)%8;
    }

}
