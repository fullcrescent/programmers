package programmers.level3;

import java.util.Arrays;

public class 숫자_게임 {

	public static void main(String[] args) {
		int[] A = {2,2,2,2};
		int[] B = {1,1,1,1};
		int answer = solution(A, B);
		System.out.println(answer);
	}

	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		
		boolean[] visit = new boolean[A.length];
		
		answer = 0;
		
		for(int i=B.length-1; i>-1; i--) {
			find(A, B[i], visit);
		}
		
		return answer;
	}
	
	static int answer;
	
	private static void find(int[] A, int findValue, boolean[] visit) {
		if(A[0]>findValue) {
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
			}
		}
		
		while(mid>-1 && visit[mid]) {
			mid--;
		}
		
		if(mid>-1) {
			visit[mid] = true;
			answer++;
		}
	}
}
