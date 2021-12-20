package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 전화번호_목록 {
	public static void main(String args[]) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
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
}
