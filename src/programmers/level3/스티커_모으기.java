package programmers.level3;

import java.util.Arrays;

public class 스티커_모으기 {

	public static void main(String[] args) {
		int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
		int answer = solution(sticker);
		System.out.println(answer);
	}
	
	public static int solution(int[] sticker) {
		if(sticker.length<4) return Arrays.stream(sticker).max().getAsInt();
		
		return Math.max(sum(Arrays.copyOfRange(sticker, 0, sticker.length-1)), sum(Arrays.copyOfRange(sticker, 1, sticker.length)));
	}
	
	private static int sum(int[] temp) {
		int[] sum = new int[temp.length];
		
		sum[0] = temp[0];
		sum[1] = temp[1];
		sum[2] = sum[0] + temp[2];
		
		for(int i=3; i<temp.length; i++) {
			sum[i] = temp[i] + Math.max(sum[i-2], sum[i-3]);
		}
		
		return Math.max(sum[temp.length-1], sum[temp.length-2]);
	}
}