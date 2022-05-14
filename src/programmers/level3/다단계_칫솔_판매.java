package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] answer = solution(enroll, referral, seller, amount);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, String> linkMap = new HashMap<>();
		Map<String, Integer> resultMap = new HashMap<>();
		
		for(int i=0; i<enroll.length; i++) {
			if(referral[i].equals("-")) {
				linkMap.put(enroll[i], "center");
			}else {
				linkMap.put(enroll[i], referral[i]);
			}
			resultMap.put(enroll[i], 0);
		}
		
		for(int i=0; i<seller.length; i++) {
			String tempSeller = seller[i];
			int tempAmount = amount[i]*100;
			
			while(true) {
				if(linkMap.get(tempSeller)==null || tempAmount/10==0) {
					resultMap.put(tempSeller, resultMap.getOrDefault(tempSeller, 0) + tempAmount);
					break;
				}else {
					resultMap.put(tempSeller, resultMap.getOrDefault(tempSeller, 0) + tempAmount-tempAmount/10);
				}
				tempSeller = linkMap.get(tempSeller);
				tempAmount = tempAmount/10;
			}
		}
		
		int[] answer = new int[enroll.length];
		
		for(int i=0; i<enroll.length; i++) {
			answer[i] = resultMap.get(enroll[i]);
		}
		
		return answer;
	}

}
