package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 기지국_설치 {

	public static void main(String[] args) {
		int n = 16;
		int[] stations = {14};
		int w = 2;
		int answer = solution(n, stations, w);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		int left=0, right=0;
		
		for(int station : stations) {
			left = station-w;
			if(right<left) list.add(left-right-1);
			right = station+w;
		}
		
		if(right<n) list.add(n-right);
		
		for(int temp : list) {
			answer += temp/(2*w+2)+1;
		}
		
		return answer;
	}
}
