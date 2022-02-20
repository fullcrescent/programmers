package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 양궁대회 {

	public static void main(String[] args) {
		int n = 5;
		int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		int[] answer = solution(n, info);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, int[] info) {
		Map<Integer, Double> map = new HashMap<>();
			
		for(int i=0; i<info.length; i++) {
			if(info[i]>1) {
				map.put(i, ((double)(10-i)*info[i]/(info[i]+1)));
			}else {
				map.put(i, (double) (10-i));
			}
		}
		
		Object[] array = map.values().toArray();
		
		Arrays.sort(array);
		
		while(n>0) {
			for(Object key : array) {
				System.out.println(key.toString());
			}
			
		}
		
		
		
		
		
		return null; 
	
	}
}
