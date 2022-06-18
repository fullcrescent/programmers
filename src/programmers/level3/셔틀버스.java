package programmers.level3;

import java.util.Arrays;

public class 셔틀버스 {

	public static void main(String[] args) {
		int n = 2;
		int t = 10;
		int m = 5;
		String[] timetable = {"00:00", "00:00", "00:00", "00:00","00:00"};
		String answer = solution(n, t, m, timetable);
		System.out.println(answer);
		
		int n1 = 2;
		int t1 = 10;
		int m1 = 5;
		String[] timetable1 = {"00:00", "00:00", "00:00", "00:00","00:00"};
		String answer1 = solution1(n1, t1, m1, timetable1);
		System.out.println(answer1);
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
		Integer[] time = new Integer[timetable.length];
		int tempIndex = 0;
		
		for(String tempTime : timetable) {
			String temp[] = tempTime.split(":");
			
			time[tempIndex++] = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
		}
		
		Arrays.sort(time);
		
		int start = 540;
		int startTime = start;
		int endTime = startTime+(n-1)*t;
		
		int index = 0;
		boolean flag = false;
		
		while(startTime<=endTime) {
			int end = index+m;
			
			while(index<time.length && index<end) {
				if(time[index]<=startTime) {
					index++;
				}else {
					break;
				}
			}
			
			startTime += t;
			flag = end==index;
		}
		
		return convertString(index>0 && flag ? time[index-1]-1 : endTime);
	}

	private static String convertString(int value) {
		int hour = value/60;
		int min = value%60;
		
		return String.format("%02d", hour) + ":" + String.format("%02d", min);
	}
	
	// 다른 사람의 풀이 참고
	public static String solution1(int n, int t, int m, String[] timetable) {
		Integer[] time = new Integer[timetable.length];
		int tempIndex = 0;
		
		for(String tempTime : timetable) {
			String temp[] = tempTime.split(":");
			
			time[tempIndex++] = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
		}
		
		Arrays.sort(time);
		
		int startTime = 540;
		int endTime = startTime+(n-1)*t;
		
		int index = 0;
		int endIndex = 0;
		
		while(startTime<=endTime) {
			endIndex = index+m;
			
			while(index<time.length && index<endIndex) {
				if(time[index]<=startTime) {
					index++;
				}else {
					break;
				}
			}
			
			startTime += t;
		}
		
		return convertString1(index>0 && endIndex==index ? time[index-1]-1 : endTime);
	}
	
	private static String convertString1(int value) {
		int hour = value/60;
		int min = value%60;
		
		return String.format("%02d:%02d", hour, min);
	}
}
