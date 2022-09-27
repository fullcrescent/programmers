package programmers.level2;

public class 타일링 {

	public static void main(String[] args) {
		int n = 6;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		int divide = 1000000007;
		
		int vertical = 1;
		int horizontal = 1;
		int fac = 1;
		
		int index = 2;
		
		while(index++<n) {
			int temp = vertical;
			vertical = ((vertical + horizontal) % divide);
			horizontal = temp;
			fac = (fac * (fac+1)) %divide ;
		}
		
		int n2 = (vertical + horizontal) % divide;
		
//		int add = Math.pow(3, fac-2);
		int answer = (n2*2) % divide;
		
		return answer-1;
	}
}
