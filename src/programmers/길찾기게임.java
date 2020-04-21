package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 길찾기게임 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeinfo);
        System.out.println(Arrays.deepToString(answer));
    }

    static class Node {
        int x, y, v;
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {

        List<Node> nodes = new LinkedList<>();
        for(int i=0; i<nodeinfo.length; ++i) {
            int[] node = nodeinfo[i];
            nodes.add(new Node(node[0], node[1], i+1));
        }

        return find(nodes);
    }

    public static int[][] find(List<Node> nodes) {

        Node root = nodes.stream()
                        .max(Comparator.comparingInt(o -> o.y))
                        .orElse(null);

        if(root == null) return new int[][] {{},{}};

        List<Node> leftTree = nodes.parallelStream().filter(node -> node.x < root.x).collect(Collectors.toList());
        List<Node> rightTree = nodes.parallelStream().filter(node -> node.x > root.x).collect(Collectors.toList());

        int[][] left = find(leftTree);
        int[][] right = find(rightTree);

        int lenL = left[0].length;
        int lenR = right[0].length;

        int[] preorder = new int[lenL + lenR + 1];
        int[] postorder = new int[lenL + lenR + 1];

        // preorder
        preorder[0] = root.v;
        for(int i=0; i<lenL; ++i) preorder[i+1] = left[0][i];
        for(int i=0; i<lenR; ++i) preorder[i+lenL+1] = right[0][i];

        // postorder
        for(int i=0; i<lenL; ++i) postorder[i] = left[1][i];
        for(int i=0; i<lenR; ++i) postorder[i+lenL] = right[1][i];
        postorder[lenL + lenR] = root.v;

        return new int[][] {preorder, postorder};
    }

}
