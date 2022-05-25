package programmers.level3;

import java.util.Arrays;

public class 숫자_게임 {

	public static void main(String[] args) {
		int[] A = {1,3,5,7};
		int[] B = {0,2,6,7};
		int answer = solution(A, B);
		System.out.println(answer);
		
		int[] A1 = {1,3,5,7};
		int[] B1 = {0,2,6,7};
		int answer1 = solution1(A1, B1);
		System.out.println(answer1);
	}

	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		boolean[] visit = new boolean[A.length];
		
		answer = 0;
		max = A.length-1;
		
		for(int i=B.length-1; i>-1; i--) {
			find(A, B[i], visit);
		}
		
		return answer;
	}
	
	static int answer;
	static int max;
	
	private static void find(int[] A, int findValue, boolean[] visit) {
		if(A[0]>=findValue) {
			visit[max] = true;
			while(max>-1 && visit[max]) {
				max--;
			}
			return;
		}
		
		int left = 0;
		int right = A.length-1;
		int mid = 0;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			if(A[mid]<findValue) {
				left = mid+1;
			}else {
				right = mid-1;
				mid--;
			}
		}
		
		while(mid>-1 && visit[mid]) {
			mid--;
		}
		
		if(mid>-1) {
			visit[mid] = true;
			answer++;
			
			while(max>-1 && visit[max]) {
				max--;
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] A, int[] B) {
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i=A.length-1, j=B.length-1; i>=0; i--) {
			if(A[i]<B[j]) {
				answer++;
				j--;
			}
		}
		
		return answer;
	}
}
