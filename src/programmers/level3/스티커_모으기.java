package programmers.level3;

public class 스티커_모으기 {

	public static void main(String[] args) {
		int sticker[] = {1, 3, 2, 5, 4};
		int answer = solution(sticker);
		System.out.println(answer);
	}
	
	public static int solution(int sticker[]) {
		int index; 
		boolean[] visit;
		
		index = 0;
		visit = new boolean[sticker.length];
		int answer1 = sticker[0];
		
		while(index<sticker.length-4) {
			visit[index] = true;
			
			if((sticker[index+2]) + (sticker[index+4]) > sticker[index+3]) {
				index += 2;
			}else {
				index += 3;
			}
			
			answer1 += sticker[index];
		}
		
		if(index+2<=sticker.length-2) {
			answer1 += sticker[index+2];
		}
		
		index = 1;
		visit = new boolean[sticker.length];
		int answer2 = sticker[1];
		
		while(index<sticker.length-4) {
			visit[index] = true;
			
			if((sticker[index+2]) + (sticker[index+4]) > sticker[index+3]) {
				index += 2;
			}else {
				index += 3;
			}
			
			answer2 += sticker[index];
		}
		
		if(index+2<=sticker.length-1) {
			answer2 += sticker[index+2];
		}
		
		return Math.max(answer1, answer2);
	}
}
