package programmers.level3;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 13;
		int[] times = {7, 10,12};
		long answer = solution(n, times);
		System.out.println(answer);
		
		int n1 = 13;
		int[] times1 = {7, 10,12};
		long answer1 = solution1(n1, times1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static long solution1(int n, int[] times) {
		return find(n, times, 0, (long)times[0] * (long)n, 0);
	}

	private static long find(int n, int[] times, long left, long right, long answer) {
		if(left>right) {
			return answer;
		}
		
		long mid = (left+right)/2;
		long count = 0;
		
		for(int i=0; i<times.length; i++) {
			count += mid/times[i];
		}
		
		if(count>=n) {
			return find(n, times, left, mid-1, mid);
		}else {
			return find(n, times, mid+1, right, answer);
		}
	}
}
