package programmers.level2;

public class 스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = solution(skill, skill_trees);
		System.out.println(answer);
		
		String skill1 = "CBD";
		String[] skill_trees1 = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer1 = solution1(skill1, skill_trees1);
		System.out.println(answer1);
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int index;
		
		Loop1 :
		for(String skill_tree : skill_trees) {
			index = 0;
			for(char temp_skill_tree : skill_tree.toCharArray()) {
				for(int i=index; i<skill.length(); i++) {
					if(temp_skill_tree==skill.charAt(i)) {
						if(i==index) {
							index++;
							break;
						}else {
							continue Loop1;
						}
					}
				}
			}
			answer++;
		}
		
        return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(String skill, String[] skill_trees) {
		int answer = skill_trees.length;
		
		for(String temp : skill_trees) {
			if(skill.indexOf(temp.replaceAll("[^" + skill + "]", ""))!=0) {
				answer--;
			}
		}
		
		return answer;
	}
}
