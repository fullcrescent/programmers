package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 주차_요금_계산 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
				"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
				"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] answer = solution(fees, records);
		System.out.println(Arrays.toString(answer));
		
		int[] fees1 = {180, 5000, 10, 600};
		String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
				"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
				"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] answer1 = solution1(fees1, records1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int[] fees, String[] records) {
		Map<String, Integer> timeMap = new HashMap<>();
		Map<String, Integer> sumMap = new HashMap<>();
		
		int lastTime = 60*23+59;
		
		for(String tempRecords : records) {
			String[] temp = tempRecords.split(" ");
			
			String[] time = temp[0].split(":");
			int hour = Integer.parseInt(time[0]);
			int min = Integer.parseInt(time[1]);
			
			if(temp[2].equals("IN")) {
				timeMap.put(temp[1], 60*hour+min);
			}else if(temp[2].equals("OUT"))  {
				int parkingTime = 60*hour+min-timeMap.get(temp[1]);
				if(sumMap.get(temp[1])==null) {
					sumMap.put(temp[1], parkingTime);
				}else {
					sumMap.put(temp[1], sumMap.get(temp[1])+(parkingTime));
				}
				
				timeMap.remove(temp[1]);
			}
		}
		
		Iterator<String> iter = timeMap.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			int parkingTime = lastTime-timeMap.get(key);
			
			if(sumMap.get(key)==null) {
				sumMap.put(key, parkingTime);
			}else {
				sumMap.put(key, sumMap.get(key)+parkingTime);
			}
		}
		
		Object[] sArray = sumMap.keySet().toArray();
		Arrays.sort(sArray);
		
		List<Integer> answer = new LinkedList<>();
		
		for(Object key : sArray) {
			int sumTime = sumMap.get(key);
			
			int overTime = sumTime - fees[0] > 0 ? sumTime - fees[0] : 0; 
			
			answer.add((int) (fees[1] + Math.ceil((double)overTime/fees[2]) * fees[3]));
		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
	
	// 다른 사람의 풀이 참고 
	public static int[] solution1(int[] fees, String[] records) {
		Map<String, Integer> map = new TreeMap<>();
		
		for(String record : records) {
			String[] temp = record.split(" ");
			
			int value = temp[2].equals("IN") ? -1 : 1;
			value *= timeToInt(temp[0]);
			map.put(temp[1], map.getOrDefault(temp[1], 0)+value);
		}
		
		int index = 0;
		int[] answer = new int[map.size()];
		
		for(int time : map.values()) {
			if(time<1) time += 1439;
			
			time -= fees[0];
			
			int cost = fees[1];
			
			if(time>0) {
				cost += (time%fees[2]==0 ? time/fees[2] : time/fees[2]+1)*fees[3];
			}
			
			answer[index++] = cost; 
		}
		
		return answer;
	}

	private static int timeToInt(String s) {
		String[] temp = s.split(":");
		return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
	}
}
