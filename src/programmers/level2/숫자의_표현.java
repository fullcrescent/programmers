package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 숫자의_표현 {

	public static void main(String[] args) {
		int n = 15;
		int answer = solution(n);
		System.out.println(answer);
	}

	public static int solution(int n) {
		int answer = 1;
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<n/2+2; i++) {
			list.add(i);
		}
		
		int temp = n;
		int startIndex = 0;
		int endIndex = 1;
		
		while(temp>0) {
			temp-=endIndex++;
		}
		endIndex--;
		while(endIndex!=n/2+2) {
			int sum = 0;
			for(int i=startIndex;i<endIndex;i++) {
				sum+=list.get(i);
			}
			
			if(sum==n) {
				answer++;
				endIndex++;
			}else if(sum>n) {
				startIndex++;
			}else {
				endIndex++;
			}
		}
		
		return answer;
	}
}
