package programmers.level2;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {

	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[] answer = solution(arr);
		System.out.println(Arrays.toString(answer));
		
		int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[] answer1 = solution1(arr1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int[][] arr) {
		int length = arr.length;
		quadCompress(arr, 0, 0, length, length);
		
		int[] answer = new int[2];
		answer[0] = count0;
		answer[1] = count1;
		return answer; 
	}
	
	static int count0 = 0;
	static int count1 = 0;
	
	private static void quadCompress(int[][] arr, int x1, int y1, int x2, int y2) {
		if(x1==x2 || y1==y2) {
			if(arr[y1][x1]==0) {
				count0++;
			}else{
				count1++;
			}
			return; 
		}
		
		int tempCount0 = 0;
		int tempCount1 = 0;
		
		int temp = arr[y1][x1];
		
		Loop1:
		for(int i=y1; i<y2; i++) {
			for(int j=x1; j<x2; j++) {
				if(arr[i][j]==0) {
					tempCount0++;
				}else {
					tempCount1++;
				}
				
				if(temp!=arr[i][j]) {
					break Loop1;
				}
			}
		}
		
		if(tempCount0==0) {
			count1++;
		}else if(tempCount1==0) {
			count0++;
		}else {
			quadCompress(arr, x1, y1, (x1+x2)/2, (y1+y2)/2);
			quadCompress(arr, (x1+x2)/2, y1, x2, (y1+y2)/2);
			quadCompress(arr, x1, (y1+y2)/2, (x1+x2)/2, y2);
			quadCompress(arr, (x1+x2)/2, (y1+y2)/2, x2, y2);
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(int[][] arr) {
		quadCompress1(arr, 0, 0, arr.length, arr.length);

		return new int[] {answer0, answer1}; 
	}
	
	static int answer0 = 0;
	static int answer1 = 0;
	
	private static void quadCompress1(int[][] arr, int x1, int y1, int x2, int y2) {
		int oneCount = 0;
		int max = (int) Math.pow(x2-x1, 2);
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				oneCount += arr[i][j];
			}
		}
		
		if(oneCount==0) answer0++;
		else if(oneCount==max) answer1++;
		else {
			quadCompress1(arr, x1, y1, (x1+x2)/2, (y1+y2)/2);
			quadCompress1(arr, (x1+x2)/2, y1, x2, (y1+y2)/2);
			quadCompress1(arr, x1, (y1+y2)/2, (x1+x2)/2, y2);
			quadCompress1(arr, (x1+x2)/2, (y1+y2)/2, x2, y2);
		}
	}

}
