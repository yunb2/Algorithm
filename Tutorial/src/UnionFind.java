public class UnionFind {

	public static int[] parent;

	public static void initParent(int cnt) {
		parent = new int[cnt+1];
		for(int i=1; i<=cnt; ++i) parent[i] = i;
	}
	
	public static int getParent(int node) {
		if(parent[node]==node) return node;
		return parent[node] = getParent(parent[node]);
	}
	
	public static void unionParent(int node1, int node2) {
		int parent1 = getParent(node1);
		int parent2 = getParent(node2);
		if(parent1<parent2) parent[parent2] = parent1;
		else parent[parent1] = parent2;
	}
	
	public static boolean findParent(int node1, int node2) {
		return getParent(node1) == getParent(node2);
	}
	
	public static void main(String[] args) {
		
		initParent(8);
		
		unionParent(1, 2);
		unionParent(2, 3);
		unionParent(3, 4);
		unionParent(5, 6);
		unionParent(6, 7);
		unionParent(7, 8);
		
		System.out.println(findParent(1,5));
		
		unionParent(4, 5);
		
		System.out.println(findParent(1,5));
		
	}
	
}
