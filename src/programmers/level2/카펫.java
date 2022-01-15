package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 카펫 {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		int[] answer = solution(brown, yellow);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int brown, int yellow) {
		List<Integer> list = new LinkedList<>();
		
		int sum = brown+yellow;
		
		for(int i=1; i<=sum; i++) {
			if(sum%i==0) {
				list.add(i);
			}
		}
		
		int[] answer = new int[2];
		
		int width = list.size()/2;
		int height = list.size()/2-1;
		
		while(true) {
			if(list.size()%2==1) {
				answer[0] = answer[1] = list.get(width);
			}else {
				answer[0] = list.get(width);
				answer[1] = list.get(height);
			}
			
			if(brown==(answer[0]*2+answer[1]*2)-4) {
				break;
			}
			width++;
			height--;
		}
		
		return answer;
	}

}
