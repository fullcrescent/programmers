package programmers.level2;

public class 타일링 {

	public static void main(String[] args) {
		int n = 8;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		int divide = 1000000007;
		
		int vertical = 1;
		int horizontal = 1;
		
		int index = 2;
		
		while(index++<n) {
			int temp = vertical;
			vertical = ((vertical + horizontal) % divide);
			horizontal = temp;
		}
		
		int n2 = (vertical + horizontal) % divide;
		
		int add = (int) (Math.pow(2, n/2) -2);
		int answer = (n2*2 + add) % divide;
		
		return answer-1;
	}
}
