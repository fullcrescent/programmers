package programmers.level2;

public class 타일링 {

	public static void main(String[] args) {
		int n = 4;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		int answer = 3;
		int divide = 1000000007;
		int add = 2;
		
		n -= 2;
		
		while(n>0) {
			n -= 2;
			answer = (answer*3 + add)%divide;
			add *= 2;
		}
		
		return answer;
	}
}
