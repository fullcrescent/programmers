package programmers.level3;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 2, 4, 2, 5, 2};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		int answer = 0;
		
		while(true) {
			int temp = 0;
			
			for(int i=0; i<stones.length; i++) {
				if(stones[i]>0) {
					
					temp = 0;
				}else {
					temp++;
					if(temp==k) {
						return answer;
					}
				}
			}
			
			int min = 200000000;
			
			for(int i=0; i<stones.length; i++) {
				if(stones[i]>0)	min = Math.min(min, stones[i]);;
			}
			
			for(int i=0; i<stones.length; i++) {
				if(stones[i]<=min) {
					stones[i] = 0;
				}else {
					stones[i] -= min;
				}
			}
			
			answer += min;
		}
	}
}
