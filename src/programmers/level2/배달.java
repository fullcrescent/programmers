package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 배달 {

	public static void main(String[] args) {
		int N = 6;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		int answer = solution(N, road, K);
		System.out.println(answer);
	}

	public static int solution(int N, int[][] road, int K) {
		sum = new int[N];
		
		Arrays.sort(road, new Comparator<int[]>() {
			public int compare(int[] input1, int[] input2) {
				if(input1[0]==input2[0] && input1[1]==input2[1]) {
					return input1[2]-input2[2];
				}else if(input1[0]==input2[0]) {
					return input1[1]-input2[1];
				}else {
					return input1[0]-input2[0];
				}
			}
		});
		
		for(int i=0; i<road.length; i++) {
			for(int j=0; j<road[i].length; j++) {
				
			}
		}
		
		return 0;
	}
	
	static int[] sum;
	
	
	

}
