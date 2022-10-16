package programmers.level4;

import java.util.Arrays;

public class 도둑질 {

	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		int answer = solution(money);
		System.out.println(answer);
	}
	
	public static int solution(int[] money) {
		if(money.length<4) return Arrays.stream(money).max().getAsInt();
		
		return Math.max(sum(Arrays.copyOfRange(money, 0, money.length-1)), sum(Arrays.copyOfRange(money, 1, money.length)));
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
