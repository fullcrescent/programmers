package programmers.level2;

public class k진수에서_소수_개수_구하기 {

	public static void main(String[] args) {
		int n = 437670;
		int k = 3;
		int answer = solution(n, k);
		System.out.println(answer);
	}
	
	public static int solution(int n, int k) {
		String s = Integer.toString(n, k);
		StringBuilder sb = new StringBuilder();
		
		int answer = 0;
		
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp=='0') {
				if(isPrime(sb.toString())) {
					answer++;
				}
				sb.delete(0, sb.length());
			}else {
				sb.append(temp);
			}
		}
		
		if(sb.length()!=0) {
			if(isPrime(sb.toString())) {
				answer++;
			}
		}
		
		return answer;
	}

	private static boolean isPrime(String string) {
		if(string.equals("") || string.equals("1")) {
			return false;
		}
		
		long number = Long.parseLong(string);
		
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		
		return true;
	}
}
