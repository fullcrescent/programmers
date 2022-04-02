package programmers.level2;

import java.util.Arrays;

public class 최솟값_만들기 {

	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		int answer = solution(A, B);
		System.out.println(answer);
		
		int[] A1 = {1, 4, 2};
		int[] B1 = {5, 4, 4};
		int answer1 = solution1(A1, B1);
		System.out.println(answer1);
	}
	
	public static int solution(int []A, int []B){
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		
		for(int i=0; i<A.length; i++) {
			sum += A[i] * B[A.length-(i+1)];
		}
		
		return sum;
	}
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int solution1(int []A, int []B){
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		
		for(int i=0; i<A.length; i++) {
			sum += A[i] * B[A.length-(i+1)];
		}
		
		return sum;
	}
}
