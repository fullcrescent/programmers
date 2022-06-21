package programmers.level3;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		int answer = 0;
		
		int left = 0;
		int right = 200000000;
		int mid;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			int count = 0;
			
			for(int stone : stones) {
				if(stone>mid) {
					count = 0;
					continue;
				}
				
				count++;
				if(count==k) {
					break;
				}
			}
			
			if(count==k) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		return answer;
	}
}
