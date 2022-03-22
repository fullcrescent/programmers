package programmers.level3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class 일차_추석_트래픽 {

	public static void main(String[] args) {
		String[] lines = {
				"2016-09-15 23:59:59.999 0.001s", "2016-09-15 23:59:59.999 0.001s", "2016-09-15 23:59:59.999 0.001s"
				};
		int answer = solution(lines);
		System.out.println(answer);
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		Map<Integer, long[]> map = new HashMap<>();
		
		int index=0;
		for(String line : lines) {
			String[] temp = line.split(" ");
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date = null;
			try {
				date = sdf.parse(temp[0] + " " + temp[1]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cal.setTime(date);
			long[] array = new long[2];
			array[1] = cal.getTimeInMillis();
			array[0] = cal.getTimeInMillis() - (long)(Double.parseDouble(temp[2].replaceAll("[a-z]", ""))*1000) + 1;
		
			map.put(index++, array);
		}
		
		for(int key : map.keySet()) {
			long[] temp = map.get(key);
			
			answer = Math.max(answer, checkTime(map, temp));
		}
		
		return answer;
	}

	private static int checkTime(Map<Integer, long[]> map, long[] value) {
		int start = 0;
		int end = 0;
		
		for(int key : map.keySet()) {
			long[] temp = map.get(key);
			if((temp[0]<=value[0]&&value[0]<=temp[1]) || (temp[0]<=value[0]+999&&value[0]+999<=temp[1])) {
				start++;
			}
		}
		
		for(int key : map.keySet()) {
			long[] temp = map.get(key);
			if((temp[0]<=value[1]&&value[1]<=temp[1]) || (temp[0]<=value[1]+999&&value[1]+999<=temp[1])) {
				end++;
			}
		}
		
		return start>end ? start : end;
	}

}
