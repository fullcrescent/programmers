package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 기지국_설치 {

	public static void main(String[] args) {
		int n = 16;
		int[] stations = {9};
		int w = 2;
		int answer = solution(n, stations, w);
		System.out.println(answer);
		
		int n1 = 16;
		int[] stations1 = {9};
		int w1 = 2;
		int answer1 = solution1(n1, stations1, w1);
		System.out.println(answer1);
	}
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		int left=1, right=1;
		
		for(int station : stations) {
			left = station-w;
			if(right<left) list.add(left-right);
			right = station+w+1;
		}
		
		if(right<n+1) list.add(n+1-right);
		
		for(int temp : list) {
			answer += temp/(2*w+1);
			answer += temp%(2*w+1)==0 ? 0 : 1;
		}

		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n, int[] stations, int w) {
		int answer = 0;
		int left=1, right=1;
		
		for(int station : stations) {
			left = station-w;
			answer += count(left, right, w);
			right = station+w+1;
		}
		
		answer += count(n+1, right, w);
		
		return answer;
	}

	private static int count(int left, int right, int w) {
		if(right<left) {
			int diff = left - right;
			return diff/(2*w+1) + (diff%(2*w+1)==0 ? 0 : 1);
		}
		
		return 0;
	}
	
}