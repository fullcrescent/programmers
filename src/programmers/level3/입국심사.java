package programmers.level3;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		long answer=0;
		while(n>0) {
			answer++;
			for(int time : times) {
				if(answer%time==0) {
					n--;
				}
			}
		}
		return answer;
	}
}
