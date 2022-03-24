package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 압축 {

	public static void main(String[] args) {
		String msg = "KAKAO";
		int[] answer = solution(msg);
		System.out.println(Arrays.toString(answer));
		
		String msg1 = "KAKAO";
		int[] answer1 = solution1(msg1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(String msg) {
		char alphabet = 'A';
		
		List<String> list = new LinkedList<>();
		List<Integer> answer = new LinkedList<>();
		
		while(alphabet!='['){
			list.add(String.valueOf(alphabet));
			alphabet++;
		}
		
		String temp = "";
		int index = 0;
		int tempIndex = -1;
		int answerIndex;
		
		while(index<msg.length()) {
			temp += msg.charAt(index);
			
			answerIndex = tempIndex+1;
			tempIndex = list.indexOf(temp);
			
			if(tempIndex>-1) {
				index++;
			}else {
				list.add(temp);
				answer.add(answerIndex);
				temp ="";
			}
			
		}
		
		answer.add(tempIndex+1);
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String msg) {
		List<String> list = new LinkedList<>();
		List<Integer> answer = new LinkedList<>();
		
		list.add("index");
		
		for(int i=0; i<26; i++) {
			list.add(String.valueOf((char)('A'+i)));
		}
		
		String temp = "";
		int index = 0;
		int tempIndex = -1;
		int answerIndex;
		
		while(index<msg.length()) {
			temp += msg.charAt(index);
			
			answerIndex = tempIndex;
			tempIndex = list.indexOf(temp);
			
			if(tempIndex>-1) {
				index++;
			}else {
				list.add(temp);
				answer.add(answerIndex);
				temp ="";
			}
		}
		
		answer.add(tempIndex);
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
