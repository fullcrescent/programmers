package programmers.level2;

import java.util.Arrays;

public class H_Index {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		int answer = solution(citations);
		System.out.println(answer);
		
		int[] citations1 = {3, 0, 6, 1, 5};
		int answer1 = solution1(citations1);
		System.out.println(answer1);
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
	public static int solution1(int[] citations) {
		Arrays.sort(citations);
		
		int max = 0;
		
		for(int i=0; i<citations.length; i++) {
			// 배열 값은 최소 인용 횟수, 길이값은 최대 논문수 서로 줄여가며 값 탐색
			int min = Math.min(citations[i], citations.length - i);
			if(max<min) max = min;
		}
		
		return max;
	}
	
}
