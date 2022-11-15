package programmers.level3;

import java.util.Arrays;

public class 스티커_모으기 {

	public static void main(String[] args) {
		int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
		int answer = solution(sticker);
		System.out.println(answer);

		int sticker1[] = {14, 6, 5, 11, 3, 9, 2, 10};
		int answer1 = solution1(sticker1);
		System.out.println(answer1);
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

	/* 다른 사람의 풀이 참고 */
	public static int solution1(int[] sticker) {
		if(sticker.length<4) return Arrays.stream(sticker).max().getAsInt();

		int[][] sum = new int[2][sticker.length];

		sum[0][0] = sticker[0];
		sum[0][1] = 0;
		sum[0][2] = sticker[0] + sticker[2];

		sum[1][0] = 0;
		sum[1][1] = sticker[1];
		sum[1][2] = sticker[2];

		for(int i=3; i<sticker.length; i++){
			sum[0][i] = sticker[i] + Math.max(sum[0][i-2], sum[0][i-3]);
			sum[1][i] = sticker[i] + Math.max(sum[1][i-2], sum[1][i-3]);
		}

		return Math.max(Math.max(sum[0][sticker.length-3], sum[0][sticker.length-2]), Math.max(sum[1][sticker.length-2],sum[1][sticker.length-1]));
	}
}