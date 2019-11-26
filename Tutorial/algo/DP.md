# Dynamic Programming

> <a src=" https://youtu.be/FmXZG7D8nS4 ">실전 알고리즘 강좌</a>



### 동적 프로그래밍

- 하나의 문제를 단 한 번만 풀도록하는 알고리즘
- 작은 문제를 풀면 기록해 두었다가, 큰 문제에서 필요했을 때 가져다쓴다.
- DP의 전제
  1. 큰 문제를 작은 문제로 나눌 수 있다.
  2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.



### 피보나치 수열 예제

```java
public class Fibonacci {

	public static int[] D;
	
	public static int fibonacci(int n) {
		if(D[n]>0) return D[n];
		if(n>2) return D[n] = fibonacci(n-1) + fibonacci(n-2);
		return 1;
	}
	
	public static void main(String[] args) {
		
		D = new int[21];
		
		System.out.println(fibonacci(20));
		
	}
	
}
```



### 타일링 문제

> <a src="https://www.acmicpc.net/problem/11726">BOJ 11726 - 2xn 타일링</a>
>
> <a src="https://www.acmicpc.net/problem/11727">BOJ 11727 - 2xn 타일링 2</a>
>
> <a src="https://www.acmicpc.net/problem/2133">BOJ 2133 - 타일 채우기</a>
>
> <a src="https://www.acmicpc.net/problem/14852">BOJ 14852 - 타일 채우기3</a>