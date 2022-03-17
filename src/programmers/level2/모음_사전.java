package programmers.level2;

public class 모음_사전 {

	public static void main(String[] args) {
		String word = "AAAAE";
		int answer = solution(word);
		System.out.println(answer);
		
		String word1 = "AAAAE";
		int answer1 = solution1(word1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(String word) {
		int answer = 0;
		int count = 3905;
		
		for(char temp : word.toCharArray()) {
			answer += "AEIOU".indexOf(temp)*(count/=5)+1;
		}
		
        return answer;
    }
}
