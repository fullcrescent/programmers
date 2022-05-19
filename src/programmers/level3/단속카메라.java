package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

	public static void main(String[] args) {
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int answer = solution(routes);
		System.out.println(answer);
		
		int[][] routes1 = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int answer1 = solution1(routes1);
		System.out.println(answer1);
	}
	
	public static int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>(){
			public int compare(int[] i1, int[] i2) {
				return Integer.compare(i1[0], i2[0]);
			}
		});
		
//		int start = 0;
		int end = 0;
		
		int answer = routes.length;
		
		for(int i=0; i<routes.length-1; i++) {
//			start = routes[i][0];
			end = routes[i][1];
			
			while(++i<routes.length && routes[i][0]<=end) {
//				start = routes[i][0];
				if(routes[i][1]<=end) {
					end = routes[i][1];
				}
				answer--;
			}
			
			i--;
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] routes) {
		Arrays.sort(routes, (i1, i2) -> Integer.compare(i1[1], i2[1]));
		
		int answer = 0;
		int min = -30000;
		
		for(int[] temp : routes) {
			if(min<temp[0]) {
				min = temp[1];
				answer++;
			}
		}
		return answer;
	}
}
