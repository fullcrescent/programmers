package programmers.level2;

public class 모음_사전 {

	public static void main(String[] args) {
		String word = "AAAAE";
		int answer = solution(word);
		System.out.println(answer);
	}
	
	public static int solution(String word) {
		char[] array = {'A', 'E', 'I', 'O', 'U'};
		int[] calculate = {781, 156, 31, 6, 1};
		
		int answer = 0;
		int index=0;
		
		while(index<word.length()) {
			char temp = word.charAt(index);
			
			for(int i=0; i<array.length;i++) {
				if(temp==array[i]) {
					answer += calculate[index] * i;
					break;
				}
			}
			
			index++;
			answer++;
		}
        
        return answer;
    }
}
