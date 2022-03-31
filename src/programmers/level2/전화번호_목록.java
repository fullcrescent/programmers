package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 전화번호_목록 {
	public static void main(String args[]) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
		
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		boolean answer1 = solution1(phone_book1);
		System.out.println(answer1);
	}
	
	public static boolean solution(String[] phone_book) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList(phone_book));
		list.sort(null);

		for(int i=0; i<list.size()-1; i++){
			if(list.get(i+1).startsWith(list.get(i))) {
				return false;
			}
		}

		return true;
    }
	
	// 다른 사람의 풀이 참고
	public static boolean solution1(String[] phone_book) {
		Arrays.sort(phone_book);
		for(int i=0; i<phone_book.length-1; i++){
			if(phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return true;
    }
}
