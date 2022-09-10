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
}