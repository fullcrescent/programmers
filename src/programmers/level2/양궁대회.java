package programmers.level2;

import java.util.Arrays;

public class 양궁대회 {

	public static void main(String[] args) {
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		int[] answer = solution(n, info);
		System.out.println(Arrays.toString(answer));
		
		int n1 = 5;
		int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};
		int[] answer1 = solution1(n1, info1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int n, int[] info) {
		answer = new int[info.length];
		boolean[] visit = new boolean[info.length];
		
		dfs(visit, info, n, 0);
		
		if(max>0) {
			return answer;
		}else {
			int[] temp = {-1};
			return temp;
		}
	}
	
	static int[] answer;
	static int max = 0;
	
	private static void dfs(boolean[] visit, int[] info, int n, int index) {
		if(index==info.length || n==0) {
			int[] temp = new int[visit.length];
			
			for(int i=0; i<visit.length; i++) {
				if(visit[i]) {
					temp[i] = info[i]+1;
				}
			}
			temp[visit.length-1] = n;
			
			score(temp, info);
			
			return;
		}
		
		for(int i=index; i<info.length; i++) {
			if(visit[i]) continue;
			
			if(n>info[i]) {
				visit[i] = true;
				dfs(visit, info, n-(info[i]+1), i+1);
			}else {
				dfs(visit, info, n, i+1);
			}
			visit[i] = false;
		}
	}

	private static void score(int[] temp, int[] info) {
		int ryan = 0;
		int apeach = 0;
		
		for(int i=0; i<info.length; i++) {
			if(info[i]<temp[i]) {
				ryan += 10-i;
			}else {
				if(info[i]==0) {
					continue;
				}
				apeach += 10-i;
			}
		}
		
		int score = ryan-apeach;
		
		if(max<score) {
			max = ryan-apeach;
			answer = temp;
		}else if(max==score) {
			for(int i=info.length-1; i>-1; i--) {
				if(answer[i]<temp[i]) {
					answer = temp;
					break;
				}else if(answer[i]>temp[i]) {
					break;
				}
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(int n, int[] info) {
		for(int i=0; i<1<<arrow; i++) {
			if(Integer.bitCount(i)<n) find(n, i, info);
		}
		
		return max==0 ? new int[] {-1} : answer1;
	}
	
	static int arrow = 11;
	static int[] answer1;
	static int max1 = 0;
	
	private static void find(int n, int i, int[] info) {
		int score = 0;
		int[] state = new int[arrow];
	}
}
