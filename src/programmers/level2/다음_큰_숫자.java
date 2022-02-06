package programmers.level2;

public class 다음_큰_숫자 {

	public static void main(String[] args) {
		int n = 78;
		int answer = solution(n);
		System.out.println(answer);
		
		int n1 = 78;
		int answer1 = solution1(n1);
		System.out.println(answer1);
		
		int n2 = 78;
		int answer2 = solution2(n2);
		System.out.println(answer2);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n) {
		// Math.pow(2, zeroCount)에 해당
		int patternPrev = n&-n;
		
		// n^(n+patternPrev) 새로나온 1 + 그전까지의 1 + 0들 -> /patternPrev 0제거 -> >> 2 새로 나온 1과 전에 있던 1 두개 제거
		int patternPost = (n^(n+patternPrev))/patternPrev >> 2;
		
		return n + patternPrev + patternPost;
	}
	
	public static int solution2(int n) {
		int count = Integer.bitCount(n++);
		
		while(count!=Integer.bitCount(n)) {
			n++;
		}
		
		return n;
	}
}
