package programmers.level3;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 13;
		int[] times = {7, 10,12};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		long answer = 0;
		
		long left = 0;
		long right = (long)times[0] * (long)n;
		long mid;
		
		while(left<=right) {
			mid = (left+right)/2;
			long count = 0;
			
			for(int i=0; i<times.length; i++) {
				count += mid/times[i];
			}
			
			if(count>=n) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		return answer;
	}
}
