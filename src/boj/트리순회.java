package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 트리순회 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];
        for(int i=0; i<N; ++i) nodes[i] = new Node((char)('A' + i) + "");

        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            Node node = nodes[str[0].charAt(0) - 'A'];
            if(!str[1].equals(".")) node.l = nodes[str[1].charAt(0)-'A'];
            if(!str[2].equals(".")) node.r = nodes[str[2].charAt(0)-'A'];
        }

        String[] answer = go(nodes[0]);
        for(String a : answer) System.out.println(a);
    }

    public static String[] go(Node n) {

        if(n == null) return new String[] {"", "", ""};

        String[] left = go(n.l);
        String[] right = go(n.r);

        String preorder = n.v + left[0] + right[0];
        String inorder = left[1] + n.v + right[1];
        String postorder = left[2] + right[2] + n.v;

        return new String[] {preorder, inorder, postorder};
    }

    static class Node {
        String v;
        Node l, r;

        Node(String v) {
            this.v = v;
        }
    }

}
