package programmers.level3;

/*2*n 타일링*/
public class 타일링 {

	public static void main(String[] args) {
		int n = 5;
		int answer = solution(n);
		System.out.println(answer);
	}

	public static int solution(int n) {
		long vertical = 1;
		long horizontal = 1;
		
		long index = 2;
		
		while(index++<n) {
			long temp = vertical; 
			vertical = ((vertical+horizontal)%1000000007);
			horizontal = temp;
		}
		
		return (int) ((vertical+horizontal)%1000000007);
	}

}
