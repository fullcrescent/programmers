package programmers.level2;

import java.util.Arrays;

public class H_Index {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		int answer = solution(citations);
		System.out.println(answer);
	}

	public static int solution(int[] citations) {
		int answer=0;
		
		while(true) {
			int count = answer;
			if(Arrays.stream(citations).filter(i -> i>=count).count()>=count) {
				answer++;
				continue;
			}
			
			break;
		}
		
		return answer-1;
	}
	
	// 다른 사람의 풀이 참고
}
