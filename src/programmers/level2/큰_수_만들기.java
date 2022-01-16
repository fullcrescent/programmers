package programmers.level2;


public class 큰_수_만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		String answer = solution(number, k);
		System.out.println(answer);
	}

	public static String solution(String number, int k) {
		int start = 0;
		int end = k;
		
		StringBuffer answer = new StringBuffer();
		
		while(++end!=number.length()+1) {
			int index = start;
			
			for(int i=start+1; i<end; i++) {
				index = number.charAt(index)>=number.charAt(i) ? index : i;
			}
			
			answer.append(number.charAt(index));
			start=index+1;
		}
		
		return answer.toString();
	}

}
