package programmers.level2;

public class 점프와_순간_이동 {
	public static void main(String[] args) {
		int n = 6;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		int answer = 1;
		
		while(n!=1) {
			if(n%2==0) {
				n /= 2;
			}else {
				n--;
				answer++;
			}
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int solution1(int n) {
		int answer = 1;
		
		while(n!=1) {
			if(n%2==0) {
				n /= 2;
			}else {
				n--;
				answer++;
			}
		}
		
		return answer;
	}
}
