package practice.graph;

import java.util.Arrays;

public class UnionFind {

	static int getParent(int[] parent, int x) {
		if(parent[x]==x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	static void unionParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		return a==b;
	}
	
	public static void main(String[] args) {
		
		int[] parent = new int[8];
		
		for(int i=0; i<8; ++i) parent[i] = i;
		
		unionParent(parent, 0, 1);
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		
		unionParent(parent, 4, 5);
		unionParent(parent, 5, 6);
		unionParent(parent, 6, 7);

		System.out.println(findParent(parent, 3, 4));
		System.out.println(Arrays.toString(parent));
		
		unionParent(parent, 0, 7);
		
		System.out.println(findParent(parent, 3, 6));
		System.out.println(Arrays.toString(parent));
		
	}
	
}
