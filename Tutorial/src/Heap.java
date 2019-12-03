import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {
	
		int[] arr = {2, 8 ,6, 1, 10, 15, 3, 12, 11};
		
		System.out.println(Arrays.toString(arr));
		
		heapSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void heapSort(int[] arr) {
		
		int n = arr.length-1;
		
		for(int i=n/2; i>=0; --i) maxHeapify(arr, i, n); // Max Heap 구조
		
		while(n>0) {
			
			swap(arr, 0, n--);
			maxHeapify(arr, 0, n);
			
		}
		
	}
	
	public static void maxHeapify(int[] arr, int parent, int n) {
		
		int leftChild = 2*parent+1;
		int rightChild = 2*parent+2;
		
		if(leftChild > n) return; // 자식 노드가 없는 경우

		if(rightChild > n && arr[parent] >= arr[leftChild]) return; // 오른쪽 자식 노드없고, 부모가 왼쪽 자식노드보다 큰 경우
		
		int biggerChild = leftChild;
		
		if(rightChild <= n) biggerChild = (arr[leftChild]>arr[rightChild])? leftChild : rightChild;
		
		if(arr[parent] > arr[biggerChild]) return;
		
		swap(arr, parent, biggerChild);
		
		maxHeapify(arr, biggerChild, n);
		
	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
}
