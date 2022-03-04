package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class 일차_추석_트래픽 {

	public static void main(String[] args) {
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		int answer = solution(lines);
		System.out.println(answer);
	}
	
	public static int solution(String[] lines) {
		Map<String, Integer> map = new HashMap<>();
		for(String temp : lines) {
			if(map.get(temp)==null) {
				map.put(temp, 1);
			}else {
				map.put(temp, map.get(temp));
			}
		}
		
		return 0;
	}

}
