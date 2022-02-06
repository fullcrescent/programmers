package programmers.level2;

public class 다음_큰_숫자 {

	public static void main(String[] args) {
		int n = 78;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		String nBinary = Integer.toBinaryString(n);
		
		int zeroCount = 0;
		int oneCount = 0;
		
		for(int i=nBinary.length()-1; i>-1; i--) {
			char temp = nBinary.charAt(i);
			
			if(temp=='0' && oneCount>0) {
				break;
			}else if(temp=='0') {
				zeroCount++;
			}else {
				oneCount++;
			}
		}
		
		int answer = n;
		answer += Math.pow(2, zeroCount);
		
		int index = 0;
		
		while(--oneCount>0) {
			answer += Math.pow(2, index++);
		}
		
		return answer;
	}
	
}
