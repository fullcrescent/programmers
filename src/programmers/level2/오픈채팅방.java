package programmers.level2;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;

public class 오픈채팅방 {
	public static void main(String args[]) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solution(record);
		System.out.println(Arrays.toString(answer));
		
		String[] record1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer1 = solution1(record1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static String[] solution(String[] record) {
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Integer length= 0;
		
		for(String data : record){
			String[] datas = data.split(" ");
			if(datas[0].equals("Enter")){
				map1.put(datas[1], datas[2]);
				map2.put(datas[1] + "_" + length, "e");
				length++;
			}
			if(datas[0].equals("Leave")){
				map2.put(datas[1] + "_" + length, "l");
				length++;
			}
			if(datas[0].equals("Change")){
				map1.put(datas[1], datas[2]);
			}
		}
		
		Iterator<String> iter = map2.keySet().iterator();
		String[] answer = new String[length];
		
		while(iter.hasNext()){
		String[] key =iter.next().split("_");
			answer[Integer.parseInt(key[1])] = map1.get(key[0]) + "님이" + (map2.get(key[0] + "_" + key[1]).equals("e") ? " 들어왔습니다." : " 나갔습니다.");
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static String[] solution1(String[] record) {
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Integer length= 0;
		
		for(String data : record){
			String[] datas = data.split(" ");
			if(datas[0].equals("Enter")){
				map1.put(datas[1], datas[2]);
				map2.put(datas[1] + "_" + length, "들어왔습니다.");
				length++;
			}
			if(datas[0].equals("Leave")){
				map2.put(datas[1] + "_" + length, "나갔습니다.");
				length++;
			}
			if(datas[0].equals("Change")){
				map1.put(datas[1], datas[2]);
			}
		}
		
		Iterator<String> iter = map2.keySet().iterator();
		String[] answer = new String[length];
		
		while(iter.hasNext()){
			String key =iter.next();
			answer[Integer.parseInt(key.split("_")[1])] = map1.get(key.split("_")[0]) + "님이 " + map2.get(key);
		}
		
		return answer;
	}
}
