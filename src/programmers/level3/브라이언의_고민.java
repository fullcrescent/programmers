package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class 브라이언의_고민 {

	public static void main(String[] args) {
		String sentence = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjxRvRvRvRvRvRx";
		String answer = solution(sentence);
		System.out.println(answer);
		
//		System.out.println("테케");
//		System.out.println(solution("HaEaLaLaObWORLDb"));
//		System.out.println(solution("SpIpGpOpNpGJqOqA"));
//		System.out.println(solution("AxAxAxAoBoBoB"));
//		System.out.println(solution("aIaAM"));
//		System.out.println(solution("AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR"));
//		System.out.println(solution("aaA"));
//		System.out.println(solution("Aaa"));
//		System.out.println(solution("HaEaLaLaOWaOaRaLaD"));
//		System.out.println(solution("aHELLOWORLDa"));
//		System.out.println(solution("HaEaLaLObWORLDb"));
//		System.out.println(solution("HaEaLaLaObWORLDb"));
//		System.out.println(solution("aHbEbLbLbOacWdOdRdLdDc"));
//		System.out.println(solution("abAba"));
//		System.out.println(solution("xAaAbAaAx"));
//		System.out.println(solution("AbAaAbAaC"));
	}

	public static String solution(String sentence) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(char temp : sentence.toCharArray()) {
			if(Character.isLowerCase(temp)) map.put(temp, map.getOrDefault(temp, 0)+1);
			if(temp==' ') return "invalid";
		}

		StringBuffer sb = new StringBuffer();
		
		return patterRemove(sentence, sb, map).replaceAll(" +", " ").trim();
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
					
					iMove += 2;
					
					while(iMove<sentence.length() && temp==sentence.charAt(iMove)) {
						count++;
						if(Character.isLowerCase(sentence.charAt(++iMove))) return "invalid";
						iMove++;
					}
					
					if(count!=map.get(temp)) return "invalid";
					
					if(flag) sb.insert(sb.length()-1, " ");
					sb.append(sentence.substring(i, iMove).replaceAll(String.valueOf(temp), "") + " ");
					
					i = iMove-1;
				}else if(map.get(temp)==2) {						// 특정 단어 앞뒤
					while(temp!=sentence.charAt(++iMove)) {}
					
					if(Character.isLowerCase(sentence.charAt(i+1))||Character.isLowerCase((sentence.charAt(iMove-1)))) return "invalid";
					String addString = sentence.substring(i, iMove).replaceAll(String.valueOf(temp), "");
					
					addString = remove(addString, map);
					if(addString.equals("invalid")) return "invalid";
					
					if(flag) sb.append(" ");
					sb.append(addString.replaceAll("[a-z]", "") + " ");
					
					 i = iMove;
				}
				
				flag = false;
			}else {
				sb.append(temp);
				flag = true;
			}
		}
		
		return sb.toString();
	}

	private static String remove(String addString, Map<Character, Integer> map) {
		char temp =' ';
		int index = 1;
		
		Map<Character, Integer> tempMap = new HashMap<>();
		
		while(index<addString.length()) {
			if(temp!=' '&&temp!=addString.charAt(index)) {
				return "invalid";
			}
			
			temp = addString.charAt(index);
			
			if(!Character.isLowerCase(temp)) {
				if(index==1) {
					return addString;
				}else {
					return "invalid";
				}
			}
			
			tempMap.put(temp, tempMap.getOrDefault(temp, 0)+1);
			if(Character.isLowerCase(addString.charAt(++index))) return "invalid";
			index++;
		}
		
		
		return tempMap.get(temp)==map.get(temp) ? addString.replaceAll(String.valueOf(temp), "") : "invalid";
	}

}
