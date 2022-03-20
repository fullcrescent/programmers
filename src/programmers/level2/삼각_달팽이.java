package programmers.level2;

import java.util.Arrays;

public class 삼각_달팽이 {

	public static void main(String[] args) {
		int n = 4;
		int[] answer = solution(n);
		System.out.println(Arrays.toString(answer));
		
		int n1 = 4;
		int[] answer1 = solution1(n1);
		System.out.println(Arrays.toString(answer1));
	}

	public static int[] solution(int n) {
		int start = 0;
		int length = fibonacci(n);
		int[] answer = new int[length];
		
		int index = 0;
		int count = 1;
		
		while(index<length) {
			for(int i=start; i<n; i++) {
				index += i;
				answer[index] = count++;
			}
			start += 2;
			
			for(int i=1; index<length-1;) {
				index += i;
				answer[index] = count++;
			}
			length = length-n-1;
			
			for(int i=n; i>start; i--) {
				index -= i;
				answer[index] = count++;
			}
			n--;
		}

		return answer;
	}
	
	private static int fibonacci(int n) {
		if(n==0) return 0;
		return n+fibonacci(n-1);
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(int n) {
		int[] answer = new int[n*(n+1)/2];
		int[][] temp = new int[n][n];
		
		int x = -1;
		int y = 0;
		int num = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(i%3==0) {
					x++;
				}else if(i%3==1) {
					y++;
				}else {
					x--;
					y--;
				}
				temp[x][y] = num++;
			}
		}
		
		int index = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(temp[i][j]==0) break;
				
				answer[index++] = temp[i][j];
			}
		}
		
		return answer;
	}
}
