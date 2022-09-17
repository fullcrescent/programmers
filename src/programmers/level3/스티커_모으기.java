package programmers.level3;

public class 스티커_모으기 {

	public static void main(String[] args) {
		int sticker[] = {1, 3, 2, 5, 4};
		int answer = solution(sticker);
		System.out.println(answer);
	}
	
	public static int solution(int sticker[]) {
		int index = 0; 
		int length = sticker.length-4;
		int answer = sticker[0];
		
		while(index<length) {
			if((sticker[index+2]) + (sticker[index+4]) > sticker[index+3]) {
				index += 2;
				
			}else {
				if(sticker[index]<sticker[index+1]) {
					answer += sticker[index+1]-sticker[index];
				}
				
				index += 3;
			}
			
			answer += sticker[index];
		}
		
		if(index+2<=sticker.length-2) {
			answer += sticker[index+2];
		}
		
		return answer;
	}
}
