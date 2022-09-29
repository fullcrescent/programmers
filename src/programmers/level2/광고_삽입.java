package programmers.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class 광고_삽입 {

	public static void main(String[] args) throws ParseException {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"};
		String answer = solution(play_time, adv_time, logs);
		System.out.println(answer);
	}
	
	public static String solution(String play_time, String adv_time, String[] logs) throws ParseException {
		String answer = null;
		
		Arrays.sort(logs);
		
		String dateformat = "HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		List<Date> list = new ArrayList<>();
		list.add(sdf.parse("00:00:00"));
		
		Date[] start = new Date[logs.length];
		Date[] end= new Date[logs.length];
		Date addTime = sdf.parse(adv_time);
		
		for(int i=0; i<logs.length; i++) {
			start[i] = sdf.parse(logs[i].split("-")[0]);
			end[i] = sdf.parse(logs[i].split("-")[1]);
			list.add(start[i]);
		}
		
		long max = 0;
		
		for(int i=0; i<logs.length; i++) {
			Date temp = list.get(i);
			long tempSum = 0;
			
			for(int j=0; j<logs.length; j++) {
				long startTime = temp.getTime()<start[j].getTime() ? start[j].getTime() : temp.getTime();
				long endTime = temp.getTime()+(addTime.getTime()+32400000)<end[j].getTime() ?  temp.getTime()+(addTime.getTime()+32400000) : end[j].getTime();
				
				startTime += 32400000;
				endTime += 32400000;
				
				if(startTime<endTime) tempSum += endTime-startTime;
			}
			
			if(max<tempSum) {
				max = tempSum;
				answer = sdf.format(temp);
			}
		}
		
		return answer;
	}

}
