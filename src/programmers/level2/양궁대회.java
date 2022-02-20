package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 양궁대회 {

	public static void main(String[] args) {
		int n = 9;
		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		int[] answer = solution(n, info);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, int[] info) {
		int[] answer = new int[info.length];
		
		Map<Integer, Double> map = new HashMap<>();
			
		for(int i=0; i<info.length; i++) {
			if(info[i]>1) {
				map.put(i, ((double)(10-i)*info[i]/(info[i]+1)));
			}else {
				map.put(i, (double) (10-i));
			}
		}
		
		Object[] array = map.keySet().toArray();
		
		Arrays.sort(array, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return -Double.compare(map.get(o1), map.get(o2));
			}
		});
		
		int index = 0;
		
		while(n>0 && index<info.length) {
			int key = (int) array[index++];
			
			if(n<info[key]+1) {
				continue;
			}
			
			answer[key] = info[key]+1;
			n -= answer[key];
		}
		
		if(n>0) {
			answer[info.length-1] += n;
		}
		
		int ryan = 0;
		int apeach = 0;
		
		for(int i=0; i<info.length; i++) {
			if(info[i]<answer[i]) {
				ryan += 10-i;
			}else {
				if(info[i]==0) {
					continue;
				}
				apeach += 10-i;
			}
		}
		
		if(ryan>apeach) {
			return answer;
		}else {
			int[] temp = {-1};
			return temp;
		}
	}
}
