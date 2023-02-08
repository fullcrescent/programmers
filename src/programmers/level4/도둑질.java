package programmers.level4;

import java.util.Arrays;

public class 도둑질 {

	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		int answer = solution(money);
		System.out.println(answer);
		
		int[] money1 = {1, 2, 3, 1};
		int answer1 = solution1(money1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] money) {
		int[][] pick = new int[2][money.length];
		
		pick[0][0] = money[0];
		pick[0][1] = money[0];
		pick[1][0] = 0;
		pick[1][1] = money[1];
		
		for(int i=2; i<money.length; i++) {
			pick[0][i] = Math.max(pick[0][i-2]+money[i], pick[0][i-1]);
			pick[1][i] = Math.max(pick[1][i-2]+money[i], pick[1][i-1]);
		}
		
		return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
	}
}
