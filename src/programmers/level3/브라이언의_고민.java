package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class 브라이언의_고민 {

	public static void main(String[] args) {
		String sentence = "SpIpGpOpNpGJqOqA";
		String answer = solution(sentence);
		System.out.println(answer);
	}

	public static String solution(String sentence) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(char temp : sentence.toCharArray()) {
			if(Character.isLowerCase(temp)) map.put(temp, map.getOrDefault(temp, 0)+1);
			if(temp==' ') return "invalid";
		}

		while(!sentence.equals("invalid") && validate(sentence)) {
			StringBuffer sb = new StringBuffer();
			
			sentence = patterRemove(sentence, sb, map);
		}
		
		return sentence.replaceAll(" +", " ").trim();
	}

	private static boolean validate(String sentence) {
		for(char temp : sentence.toCharArray()) {
			if(Character.isLowerCase(temp)) return true;
		}
		return false;
	}

	private static String patterRemove(String sentence, StringBuffer sb, Map<Character, Integer> map) {
		boolean flag = false;
		
		for(int i=0; i<sentence.length(); i++) {
			char temp = sentence.charAt(i);
			
			if(Character.isLowerCase(temp)) {
				int iMove = i;
				
				if(map.get(temp)!=2) {					// 단어 사이사이
					if(!flag) return "invalid";
					
					int count = 1;
					
					while(iMove+2<sentence.length() && temp==sentence.charAt(iMove+2)) {
						count++;
						if(Character.isLowerCase(sentence.charAt(++iMove))) return "invalid";
						iMove++;
					}
					
					if(count!=map.get(temp) || iMove+1>=sentence.length()) return "invalid";
					
					if(flag) sb.insert(sb.length()-1, " ");
					sb.append(sentence.substring(i, iMove+2).replaceAll(String.valueOf(temp), "") + " ");
					
					i = iMove+1;
				}else if(map.get(temp)==2) {						// 특정 단어 앞뒤
					while(temp!=sentence.charAt(++iMove)) {}
					
					if(Character.isLowerCase(sentence.charAt(i+1))||Character.isLowerCase((sentence.charAt(iMove-1)))) return "invalid";
					String addString = sentence.substring(i, iMove).replaceAll(String.valueOf(temp), "");
					
					if(!validate2(addString, map)) return "invalid";
					
					if(flag) sb.append(" ");
					sb.append(addString + " ");
					
					 i = iMove;
				}else {
					return "invalid";
				}
				
				flag = false;
			}else {
				sb.append(temp);
				flag = true;
			}
		}
		
		return sb.toString();
	}

	private static boolean validate2(String addString, Map<Character, Integer> map) {
		char tempChar=' ';
		int count = 0;
		
		for(char temp : addString.toCharArray()) {
			if(Character.isLowerCase(temp)) {
				if(tempChar==' '||tempChar==temp) {
					tempChar = temp;
				}else {
					return false;
				}
				
				count++;
			}
		}
		
		return tempChar==' ' || map.get(tempChar)==count;
	}

}
