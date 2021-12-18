package programmers.level2;

public class °ýÈ£_º¯È¯ {
	public static String solution(String p) {
//		return p=="" ? "" : stringSeparation(p, 0, p.length());
		return p=="" ? "" : stringSeparation1(p);
	}
	
	public static String stringSeparation1(String string) {
		int standard = 0;
		int index = 0;
		String reverse = "";
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i) == '(') {
				standard++;
				reverse += ")";
			}else if(string.charAt(i) == ')') {
				standard--;
				reverse += "(";
			} 
			
			if(standard == 0) {
				index=i;
				break;
			}
		}
		
		if(stringVerification1(string.substring(0, index+1))) {
			return string.substring(0, index+1) + (index+1 == string.length() ? "" : stringSeparation1(string.substring(index+1, string.length())));
		}else {
			return  "(" + (index+1 == string.length() ? "" : stringSeparation1(string.substring(index+1, string.length()))) + ")" + reverse.substring(1, reverse.length()-1);
		}
	}
	
	public static boolean stringVerification1(String string) {
		boolean verification = true;
		
		int standard = 0;
		for(int i=0; i<string.length(); i++	){
			if(string.charAt(i) == '(') {
				standard++;
			}else if(string.charAt(i) == ')') {
				standard--;
			} 
			
			if(standard < 0) {
				verification = false;
				break;
			}
		}
		
		return verification;
	}
	
	public static String stringSeparation(String string, int start, int end) {
		int left = 0;
		int right = 0;
		int index = 0;
		String reverse = "";
		for(int i=start; i<end; i++) {
			if(string.charAt(i) == '(') {
				left++;
				reverse += ")";
			}else if(string.charAt(i) == ')') {
				right++;
				reverse += "(";
			} 
			
			if(left == right) {
				index=i;
				break;
			}
		}

		if(stringVerification(string.substring(start, index+1))) {
			return string.substring(start, index+1) + (index+1 == end ? "" : stringSeparation(string, index+1, end ));
		}else {
			return  "(" + (index+1 == end ? "" : stringSeparation(string, index+1, end )) + ")" + reverse.substring(1, reverse.length()-1);
		}
	}

	public static boolean stringVerification(String string) {
		boolean verification = true;
		
		int left = 0;
		int right = 0;
		
		for(int i=0; i<string.length(); i++ ){
			if(string.charAt(i) == '(') {
				left++;
			}else if(string.charAt(i) == ')') {
				right++;
			} 
		
			if(left < right) {
				verification = false;
				break;
			}
		}
		return verification;
	}
	
	public static void main(String args[]) {
		String p = "()))((()";
		String answer = solution(p);
		
		System.out.println(answer);
	}
}
