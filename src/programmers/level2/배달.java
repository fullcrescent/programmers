package programmers.level2;

import java.util.Arrays;

public class 배달 {

	public static void main(String[] args) {
		int N = 7;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{4,3,3},{3,5,2},{3,5,3},{5,6,1},{6,7,6}};
		int K = 5;
		int answer = solution(N, road, K);
		System.out.println(answer);
	}

	public static int solution(int N, int[][] road, int K) {
		// 배달 거리가 가장 가까운 순으로 정렬 -> 크루스칼 알고리즘
		Arrays.sort(road, (road1, road2)->Integer.compare(road1[2], road2[2]));
		
		int[] mstValue = new int[N+1];
		int[] sum = new int[N+1];
		int[] parent = new int[N+1];
		
		for(int i=0; i<parent.length; i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<road.length; i++) {
			// 사이클 검사
			if(find(parent, road[i][0])!=find(parent, road[i][1])){
				int big = road[i][0]>road[i][1] ? road[i][0] : road[i][1];
				int small = road[i][0]<road[i][1] ? road[i][0] : road[i][1];
				
				parent[big] = small;
				mstValue[big] = road[i][2];
			}
		}
		
		for(int i=1; i<sum.length; i++) {
			sum[i] = weight(parent, mstValue, i);
		}
		
		return (int) (Arrays.stream(sum).filter(i -> (i<=K)).count()-1);
	}

	private static int find(int[] parent, int index) {
		if(parent[index]==index) {
			return index;
		}else {
			return find(parent, parent[index]);
		}
	}
	
	private static int weight(int[] parent, int[] mstValue, int index) {
		if(parent[index]==index) {
			return 0;
		}else {
			return mstValue[index] + weight(parent, mstValue, parent[index]);
		}
	}
	
}
