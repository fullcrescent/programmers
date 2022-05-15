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
		
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		int[] answer1 = solution1(enroll1, referral1, seller1, amount1);
		System.out.println(Arrays.toString(answer1));
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
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Person> map = new HashMap<>();
		
		for(String name : enroll) {
			map.put(name, new Person(null, 0));
		}
		
		for(int i=0; i<enroll.length; i++) {
			if(!referral[i].equals("-")) {
				map.get(enroll[i]).referral = map.get(referral[i]);
			}
		}
		
		for(int i=0; i<seller.length; i++) {
			map.get(seller[i]).addMoney(amount[i]*100);
		}
		
		int[] answer = new int[enroll.length];
		
		for(int i=0; i<enroll.length; i++) {
			answer[i] = map.get(enroll[i]).money;
		}
		
		return answer;
	}
	
	static class Person{
		Person referral;
		int money;
		
		public Person(Person referral, int money) {
			this.referral = referral;
			this.money = money;
		}

		public void addMoney(int money) {
			int referralMoney = money/10;
			
			this.money += money - referralMoney;
			
			if(this.referral!=null) this.referral.addMoney(referralMoney);
		}
	}
}
