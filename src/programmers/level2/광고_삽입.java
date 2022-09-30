package programmers.level2;

import java.util.Arrays;

public class 광고_삽입 {

	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"};
		String answer = solution(play_time, adv_time, logs);
		System.out.println(answer);
	}
	
	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = null;
		
		Arrays.sort(logs);
		
		long[] start = new long[logs.length];
		long[] end= new long[logs.length];
		long addTime = convertSeconds(adv_time);
		
		for(int i=0; i<logs.length; i++) {
			start[i] = convertSeconds(logs[i].split("-")[0]);
			end[i] = convertSeconds(logs[i].split("-")[1]);
		}
		
		long max = 0L;
		
		for(int i=0; i<logs.length; i++) {
			long temp = start[i];
			long tempSum = 0L;
			
			for(int j=0; j<logs.length; j++) {
				long endTime = temp+addTime;
				if(start[j]<endTime) {
					long startTime = temp<start[j] ? start[j] : temp;
					endTime = endTime<end[j] ?  endTime : end[j];
					
					if(startTime<endTime) tempSum += endTime-startTime;
				}else {
					break;
				}
			}
			
			if(max<tempSum) {
				max = tempSum;
				answer = convertTime(temp);
			}
		}
		
		return answer;
	}

	private static String convertTime(long temp) {
		return String.format("%02d:%02d:%02d", temp/3600, temp%3600/60, temp%60);
	}

	private static long convertSeconds(String time) {
		String[] temp = time.split(":");
		return Long.valueOf(temp[0])*3600 +  Long.valueOf(temp[1])*60 +  Long.valueOf(temp[2]);
	}

}
