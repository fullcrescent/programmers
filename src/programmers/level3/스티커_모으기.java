package programmers.level3;

public class 스티커_모으기 {

	public static void main(String[] args) {
		int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
		int answer = solution(sticker);
		System.out.println(answer);
	}
	
	public static int solution(int[] sticker) {
		return Math.max(sum(sticker, 0, sticker.length-5), sum(sticker, 1, sticker.length-4));
	}
	
	private static int sum(int[] sticker, int index, int length) {
		int answer = sticker[index];
		
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
		
		if(index+2<=sticker.length-2+index) {
			answer += sticker[index+2];
		}
		
		return answer;
	}
}
