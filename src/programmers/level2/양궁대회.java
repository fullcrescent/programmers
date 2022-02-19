package programmers.level2;

import java.util.Arrays;

public class 양궁대회 {

	public static void main(String[] args) {
		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,8,1,1};
		int[] answer = solution(n, info);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, int[] info) {
		int[] answer = new int[info.length];
		
		int index = -1;
		
		while(n>0 && index++<info.length-1) {
			if(n<info[index]) {
				continue;
			}
			
			if(info[index]>1) {
				int tempSum = 0;
				for(int i=index+1; i<index+1+info[index]+1 && i<info.length ; i++) {
					tempSum += 10-i;
				}
				
				if(tempSum<(10-index)) {
					answer[index] = info[index]+1;
					n -= answer[index];
				}
			}else if(n>=info[index]+1) {
				answer[index] = info[index]+1;
				n -= answer[index];
			}
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
