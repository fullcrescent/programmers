package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 숫자의_표현 {

	public static void main(String[] args) {
		for(int i=2; i<1000; i++) {
			solution(i*2);
			System.out.println("======"+i);
		}
		
		
		int n = 52;
		int answer = solution(n);
		System.out.println(answer);
		
		int n1 = 52;
		int answer1 = solution1(n1);
		System.out.println(answer1);
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
				System.out.println(startIndex+1 + ":"+ endIndex);
				endIndex++;
			}else if(sum>n) {
				startIndex++;
			}else {
				endIndex++;
			}
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n) {
		int answer = 0;
		
		// endIndex까지의 합 endIndex(endIndex+1)/2,  startIndex까지의 합 startIndex(startIndex+1)/2
		// endIndex(endIndex+1) - startIndex(startIndex+1)  = 2x
		// (endIndex^2 - startIndex) - (startIndex^2 - endIndex) = 2x
		// (endIndex - startIndex)*(endIndex + startIndex + 1) = 2x
		// (endIndex - startIndex), (endIndex + startIndex + 1) 홀수 짝수 값 나눠가짐
		// 2x = 홀수 * 짝수
		// 2x = 홀수 * 2 * 짝수/2
		// x = 홀수 * 짝수/2
		// x의 홀수 약수의 갯수가지만큼 만들수 있음.
		for(int i=1; i<=n; i+=2) {
			if(n%i==0) {
				answer++;
			}
		}
		return answer;
	}
	
}
