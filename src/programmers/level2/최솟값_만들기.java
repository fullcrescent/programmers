package programmers.level2;

import java.util.Arrays;

public class 최솟값_만들기 {

	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		int answer = solution(A, B);
		System.out.println(answer);
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

}
