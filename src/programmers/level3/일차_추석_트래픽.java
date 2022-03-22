package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class 일차_추석_트래픽 {

	public static void main(String[] args) {
		String[] lines = {
				"2016-09-15 20:59:59.000 0.001s","2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
				};
		int answer = solution(lines);
		System.out.println(answer);
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		Map<Integer, int[]> map = new HashMap<>();
		
		int index=0;
		for(String line : lines) {
			String[] temp = line.split(" ");
			int[] array = new int[2];
			
			array[1] = Integer.parseInt(temp[1].replaceAll("[:.]", ""));
			
			int time = (int)(Double.parseDouble(temp[2].replaceAll("[a-z]", ""))*1000);
			
			if(Integer.parseInt(temp[1].replaceAll("[:.]", "").substring(2))<time) {
				array[0] = array[1] - time + 1 - 4040000;
			}else if(Integer.parseInt(temp[1].replaceAll("[:.]", "").substring(4))<time) {
				array[0] = array[1] - time + 1 - 40000;
			}else {
				array[0] = array[1] - time + 1;
			}
		
			map.put(index++, array);
		}
		
		for(int key : map.keySet()) {
			int[] temp = map.get(key);
			
			answer = Math.max(answer, checkTime(map, temp));
		}
		
		return answer;
	}

	private static int checkTime(Map<Integer, int[]> map, int[] value) {
		int start = 0;
		int end = 0;
		
		for(int key : map.keySet()) {
			int[] temp = map.get(key);
			if((temp[0]<=value[0]&&value[0]<=temp[1]) || (temp[0]<=value[0]+999&&value[0]+999<=temp[1]) 
					|| (value[0]<=temp[0]&&value[0]<=temp[1]&&temp[0]<=value[0]+999&&temp[1]<=value[0]+999)) {
				start++;
			}
		}
		
		for(int key : map.keySet()) {
			int[] temp = map.get(key);
			if((temp[0]<=value[1]&&value[1]<=temp[1]) || (temp[0]<=value[1]+999&&value[1]+999<=temp[1])
					|| (value[1]<=temp[0]&&value[1]<=temp[1]&&temp[0]<=value[1]+999&&temp[1]<=value[1]+999)) {
				end++;
			}
		}
		
		return start>end ? start : end;
	}

}
