package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 배달 {

	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1,2,2},{2,3,3},{5,2,2},{1,4,1},{5,3,1},{5,4,2}};
		int K = 3;
		int answer = solution(N, road, K);
		System.out.println(answer);
	}

	public static int solution(int N, int[][] road, int K) {
		// 배달 거리가 가장 가까운 순으로 정렬 -> 크루스칼 알고리즘
		Queue<int[]> queue = new PriorityQueue<int[]>(N, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]!=o2[2]) {
					return Integer.compare(o1[2], o2[2]);
				}
				int big1 = o1[0]>o1[1] ? o1[0] : o1[1];
				int small1 = o1[0]<o1[1] ? o1[0] : o1[1];
				
				int big2 = o2[0]>o2[1] ? o2[0] : o2[1];
				int small2 = o2[0]<o2[1] ? o2[0] : o2[1];
				
				if(big1!=big2) {
					return Integer.compare(big1, big2);
				}else {
					return Integer.compare(small1, small2);
				}
			}
		});
		
		for(int[] temp : road) {
			queue.add(temp);
		}

		int answer=0;
		
		int[] mstValue = new int[N+1];
		int[] parent = new int[N+1];
		
		for(int i=0; i<parent.length; i++) {
			parent[i]=i;
		}
		
		while(!queue.isEmpty()) {
			int[] value=queue.poll();
			System.out.println(Arrays.toString(value));
			// 사이클 검사
			if(find(parent, value[0])!=find(parent, value[1])){
				int big = value[0]>value[1] ? value[0] : value[1];
				int small = value[0]<value[1] ? value[0] : value[1];
				
				parent[big] = small;
				mstValue[big] = value[2];
			}
		}
		
		for(int i=1; i<parent.length; i++) {
			if(find(parent, i)!=1) {
				continue;
			}
			if(weight(parent, mstValue, i)<=K) {
				answer++;
			}
		}
		
		return answer;
	}
	
	private static int find(int[] parent, int index) {
		if(parent[index]==index) {
			return index;
		}else {
			return find(parent, parent[index]);
		}
	}
	
	private static int weight(int[] parent, int[] mstValue, int index) {
		if(parent[index]==index){
        	return 0;
        }else {
			return mstValue[index] + weight(parent, mstValue, parent[index]);
		}
	}
	
}
